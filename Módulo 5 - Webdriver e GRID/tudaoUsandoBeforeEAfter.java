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
	
	WebDriver driver;
	
	@Before
	public  void arrumaTudo() {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - "
				+ "Automacao de testes/libs/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");	
	}
	
	@After
	public void fechaTudo() {
		driver.quit();
	}
	
	@Test
	public void realizandoCadastroOk() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Jader");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Machado");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(elemento);
		combo.selectByValue("especializacao");
		elemento = driver.findElement(By.id("elementosForm:esportes"));
		Select comboEsporte = new Select(elemento);
		comboEsporte.selectByVisibleText("Natacao");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Isso é uma sugestão!");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Jader"));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Machado"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Pizza"));
		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("especializacao"));
		Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Natacao"));
		Assert.assertTrue(driver.findElement(By.id("descSugestoes")).getText().endsWith("Isso é uma sugestão!"));
	}
	
	@Test
	public void regraEsportista() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Jader");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Machado");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		WebElement combo = driver.findElement(By.id("elementosForm:esportes"));
		Select elemento = new Select(combo);
		elemento.selectByIndex(0);
		elemento.selectByIndex(4);
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alertaDeRegra = driver.switchTo().alert();
		String textoAlerta = alertaDeRegra.getText();
		Assert.assertEquals("Voce faz esporte ou nao?", textoAlerta);
	}
	
	@Test
	public void regraVegetariano() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Jader");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Machado");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alertaDeRegra = driver.switchTo().alert();
		String textoDoAlerta = alertaDeRegra.getText();
		alertaDeRegra.accept();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?",textoDoAlerta);
	}

}
