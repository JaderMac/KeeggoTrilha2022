package alura;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesLogin {
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;
	
	@BeforeAll
	public static void BeforeAll() {
		System.setProperty("webdriver.chrome.driver",	
		"D://Java Completo//Livro - Automacao de testes/libs/drivers/chromedriver.exe");
	}
	
	@BeforeEach
	public void beforeEach() {
		this.browser = new ChromeDriver();
		browser.navigate().to(URL_LOGIN);
	}
	
	@AfterEach
	public void AfterEach() {
		this.browser.quit();
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		// browser.findElement(By.id("botaoLogin")).click();
		browser.findElement(By.id("login-form")).submit();
		Assert.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
		Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
	}
	@Test
	public void nãoLogarComDadosInvalidos() {

		
		browser.findElement(By.id("username")).sendKeys("INVÁLIDO");
		browser.findElement(By.id("password")).sendKeys("PORTEIRA");
		browser.findElement(By.id("login-form")).submit();
		Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		Assert.assertThrows(NoSuchElementException.class, 
				() -> browser.findElement(By.id("usuario-logado")));
	}
	
	@Test
	public void nãoDeveriaAcessarPaginaRestritaSemLogar() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
		Assert.assertTrue(browser.getCurrentUrl().equals(URL_LOGIN));
		Assert.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
	}

}
