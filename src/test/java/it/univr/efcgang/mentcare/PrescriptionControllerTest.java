package it.univr.efcgang.mentcare;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;


class TestPrescriptionTableIsEmpty extends BaseTest{


    @Test
    public void SystemOnline() {
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(300,300));
    }
}
