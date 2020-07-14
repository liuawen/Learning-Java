package com.imooc.springboot.databasecp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("===before class===");
    }

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
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