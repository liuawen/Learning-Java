interface ReadingListRepository {

	List<Book> findByReader(String reader)

	void save(Book book)

}