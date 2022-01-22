package it.univr.efcgang.mentcare;


import it.univr.efcgang.mentcare.config.DemoData;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//@SpringBootTest: run spring boot before stating the tests
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTest {

    public String baseUrl = "http://localhost:8080";
    @Autowired
    private DemoData demoData;

    public void clearDb(){
        demoData.clearDemoData();
    }
    @AfterEach
    public void resetDb(){
        demoData.resetDemoData();
    }
    /*
    public void printAllDb(){
        demoData.printAllRepository();
    }
    */
}

