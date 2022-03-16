package testes;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

class TestesLogin {
	
	@Test
	void helloTest() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver browser = new WebDriver();
		browser.navigate().to("http://localhost:8080/leiloes");
	}

}
