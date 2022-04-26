import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class tudaoUsandoBeforeEAfter {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public  void arrumaTudo() {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - "
				+ "Automacao de testes/libs/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void fechaTudo() {
		driver.quit();
	}
	@Test
	public void escreveNoCampo() {
		dsl.escreve("elementosForm:nome","Jader");
		Assert.assertEquals("Jader",dsl.ObterValorCampo("elementosForm:nome"));
	}
	@Test
	public void interagigTextArea() {
		dsl.escreve("elementosForm:sugestoes","Isso é uma sugestão!");
		Assert.assertEquals("Isso é uma sugestão!",dsl.ObterValorCampo("elementosForm:sugestoes"));
	}
	@Test
	public void InteragirRadioButton() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:3"));
	}
	@Test 
	public void interagirComCombo() {
		dsl.selecionarCombo("elementosForm:escolaridade","2o grau incompleto");
		Assert.assertEquals("2grauincomp", dsl.ObterValorCampo("elementosForm:escolaridade"));
	}
	@Test
	public void verificarValoresComboMultiplo() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(elemento);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3,allSelectedOptions.size());
	}
	@Test
	public void deveclicarBotao() {
		dsl.clicarBotao("buttonSimple");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		Assert.assertEquals("Obrigado!",botao.getAttribute("value"));
	}
	@Test
	public void deveIntetagirComLinks() {
		dsl.clicaLink("Voltar");
		Assert.assertEquals("Voltou!",dsl.obterTexto("resultado"));
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				dsl.obterTexto(By.className("facilAchar")));
	}
	
	
}
