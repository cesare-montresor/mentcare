package it.univr.efcgang.mentcare;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class MainControllerTest extends BaseTest {

	MainControllerTest(){
		headless = false; //true;
		autoclose = true;
		selectedBrowser = BrowserDriver.Chrome;
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
