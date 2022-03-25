package leiloes;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
	
	protected WebDriver browser;
	
	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - Automacao de testes/libs/drivers/chromedriver.exe");
		if(browser == null) {
			this.browser = new ChromeDriver();
		} else {
			this.browser = browser;
		}
	}
	@AfterEach
	public void fechar() {
		this.browser.quit();
	}
	

}
