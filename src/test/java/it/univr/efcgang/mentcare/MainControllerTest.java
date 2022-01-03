package it.univr.efcgang.mentcare;



import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.po.PrescriptionEmptyPO;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainControllerTest extends BaseTest {

	@Test
	public void testWelcome() {
		driver.get(baseUrl);
	}

	@Test
	public void testTopMenu() {
		driver.get(baseUrl);
	}


	@Test
	public void testPrescriptionTableIsEmptyOnStartup(){
		driver.get(baseUrl);

		MenuPO menuPage = new MenuPO(driver);

		// Go to prescription page
		PrescriptionEmptyPO prescriptionEmptyPage = menuPage.goToPrescriptionPageEmpty();

		// Check I'm in correct page
		assertEquals("Prescription list",prescriptionEmptyPage.getTitle());

		// Check table is empty
		assertEquals(0,prescriptionEmptyPage.getRowsNumber());

	}

}
