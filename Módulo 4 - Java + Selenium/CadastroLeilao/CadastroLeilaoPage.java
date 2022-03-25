package leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {
	
	private WebDriver browser;

	public CadastroLeilaoPage(WebDriver browser) {
		this.browser = browser;
	}

	public LeiloesPage cadastrarLeilao(String hoje, String nome, String valor) {
		this.browser.findElement(By.id("nome")).sendKeys(nome);
		this.browser.findElement(By.id("valorInicial")).sendKeys(valor);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(hoje);
		this.browser.findElement(By.id("button-submit")).submit();
		return new LeiloesPage(browser);
	}

}
