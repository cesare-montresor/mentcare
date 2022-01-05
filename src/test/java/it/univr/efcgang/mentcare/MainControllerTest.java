package it.univr.efcgang.mentcare;


import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;



class MainControllerTest extends BaseTest {

	@Test
	public void testLogin() throws InterruptedException {
		browserLogin("maria", "maria");
		browser.driver.get(url("/profile"));
		WebElement title = browser.driver.findElement(By.xpath("//h1"));
		assertEquals(title.getText().toLowerCase(), "profile");
	}

	@Test
	public void testWelcome() {
		driver.get(baseUrl);
	}

	@Test
	public void testTopMenu() {
		driver.get(baseUrl);
	}






}
