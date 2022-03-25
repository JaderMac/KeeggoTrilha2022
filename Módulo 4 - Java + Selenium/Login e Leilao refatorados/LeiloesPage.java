package leiloes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage extends PageObject {
	
	private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/new";
	private static final String URL_LEILOES = "http://localhost:8080/leiloes";
	
	
	public LeiloesPage(WebDriver browser) {
		super(null);
	}

	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(URL_CADASTRO_LEILOES);
		return new CadastroLeilaoPage(browser);
	}

	public boolean isLeilaoCadastrado(String hoje, String nome, String valor) {
		WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabelaLeiloes tbody tr:last-child"));
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		return colunaNome.getText().equals(nome) && colunaDataAbertura.getText().equals(hoje) 
		&& colunaValorInicial.getText().equals(valor);
	}

	public boolean isPaginaAtual() {
		return this.browser.getCurrentUrl().equals(URL_LEILOES);
	}

	public boolean isMensagensVisiveis() {
		String pagesource = this.browser.getPageSource();
		return pagesource.contains("minimo 3 caracteres") &&	
				pagesource.contains("não deve estar em branco") && 
				pagesource.contains("deve ser um valor maior de 0.1") && 
				pagesource.contains("deve ser uma data no formato dd/MM/yyyy");
	}
}
