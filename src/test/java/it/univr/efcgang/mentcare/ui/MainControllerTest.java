package it.univr.efcgang.mentcare.ui;


import it.univr.efcgang.mentcare.BaseTest;
import it.univr.efcgang.mentcare.po.MainPO;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;



class MainControllerTest extends BrowserTest {

	@Test
	public void testLogin() throws InterruptedException {

		browserLogin("maria", "maria");
		assertTrue(mainPO.isLoggedIn());
	}

	@Test
	public void testLoginProfile() throws InterruptedException {

		browserLogin("maria", "maria");
		assertTrue(mainPO.isLoggedIn());

		browser.driver.get(url("/profile"));

		String title_txt = mainPO.profileTitle.getText().trim();
		String username_txt = mainPO.profileUsername.getText().trim();
		String roles_txt = mainPO.profileRoles.getText().trim();

		assertEquals(title_txt, "Profile");
		assertEquals(username_txt , "maria");
		assertEquals(roles_txt, "DOCTOR");
	}

	@Test
	public void testLoginDoctor() throws InterruptedException {

		browserLogin("maria", "maria");
		assertTrue(mainPO.isLoggedIn());

		ArrayList<String> names = new ArrayList<>();
		mainPO.menuItems.forEach( item -> names.add( item.getText() ) );
		System.out.println(names);
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
