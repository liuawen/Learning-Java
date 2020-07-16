package com.imooc.springboot.unittest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    //===before method===
    //===Hello IMOOC===
    //===after method===
    //
    //===after class===
    //16:49:37.784 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.imooc.springboot.unittest.HelloControllerTest]
    //16:49:37.784 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.imooc.springboot.unittest.HelloControllerTest]
    //2020-07-16 16:49:44.503  INFO 16036 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
    @Autowired
    private MockMvc mvc;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("===before class===");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("===before method===");
    }

    @Test
    public void hello() throws Exception {
        MvcResult result = mvc.perform(get("/hello").header("version","2").param("name", "IMOOC").contentType(MediaType.APPLICATION_JSON))
                        .andExpect(content().string("Hello IMOOC")).andReturn();

        System.out.println("==="+result.getResponse().getContentAsString()+"===");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("===after method===");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("===after class===");
    }

}