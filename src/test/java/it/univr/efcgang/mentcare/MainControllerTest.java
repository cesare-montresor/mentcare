package it.univr.efcgang.mentcare;



import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.po.PrescriptionListEmptyPO;
import it.univr.efcgang.mentcare.po.PrescriptionListPO;
import org.junit.jupiter.api.Test;

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
		// TODO: se i test sono eseguiti insieme la tabella non inizia vuota
		driver.get(baseUrl);

		MenuPO menuPage = new MenuPO(driver);

		// Go to prescription page
		PrescriptionListEmptyPO prescriptionEmptyPage = menuPage.goToPrescriptionPageEmpty();

		// Check I'm in correct page
		assertEquals("Prescription list",prescriptionEmptyPage.getTitle());

		// Check table is empty
		assertEquals(0,prescriptionEmptyPage.getRowsNumber());

	}



}
