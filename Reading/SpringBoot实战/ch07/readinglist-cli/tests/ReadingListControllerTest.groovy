import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.mockito.Mockito.*

class ReadingListControllerTest {

	@Test
	void shouldReturnReadingListFromRepository() {
		List<Book> expectedList = new ArrayList<Book>()
		expectedList.add(new Book(
				id: 1,
				reader: "Craig",
				isbn: "9781617292545",
				title: "Spring Boot in Action",
				author: "Craig Walls",
				description: "Spring Boot in Action is ..."
			))

		def mockRepo = mock(ReadingListRepository.class)
		when(mockRepo.findByReader("Craig")).thenReturn(expectedList)
		
		def controller = new ReadingListController(readingListRepository: mockRepo)

		MockMvc mvc = standaloneSetup(controller)
						.build()
		mvc.perform(get("/"))
			.andExpect(view().name("readingList"))
			.andExpect(model().attribute("books", expectedList))

	}

}