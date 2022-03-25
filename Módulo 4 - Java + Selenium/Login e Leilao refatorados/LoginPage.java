package leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject  {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private static final String URL_LOGIN_ERROR = "http://localhost:8080/login?error";
	
		
	public LoginPage() {
		super(null);
		browser.navigate().to(URL_LOGIN);
	}

	public LeiloesPage preencheFormulárioLogin(String username, String name) {
		this.browser.findElement(By.id("username")).sendKeys("fulano");
		this.browser.findElement(By.id("password")).sendKeys("pass");
		this.browser.findElement(By.id("submit-bot")).click();
		return new LeiloesPage(browser);
	}

	public boolean IsPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public boolean IsPaginaDeLoginComErro() {
		return browser.getCurrentUrl().equals(URL_LOGIN_ERROR);
	}
	public String pegaNomeUsuarioLogado() {
		try {
			return this.browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null; 
		}
	}

	public void acessaPaginaRestrita() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean validaPresençaDeTexto(String Texto) {
		return this.browser.getPageSource().contains(Texto);
	}


}
