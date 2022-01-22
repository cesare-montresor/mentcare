package it.univr.efcgang.mentcare;


import org.springframework.boot.test.context.SpringBootTest;


//@SpringBootTest: run spring boot before stating the tests
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTest {

    public String baseUrl = "http://localhost:8080";
}

