import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class desafioCadastro {
	
	@Test
	public void realizandoCadastroOk() {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - "
				+ "Automacao de testes/libs/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
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
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Isso � uma sugest�o!");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		String resultado = driver.findElement(By.id("resultado")).getText();
		Assert.assertTrue(resultado.contains("Cadastrado!"));
		Assert.assertTrue(resultado.contains("Jader"));
		Assert.assertTrue(resultado.contains("Machado"));
		Assert.assertTrue(resultado.contains("Masculino"));
		Assert.assertTrue(resultado.contains("Pizza"));
		Assert.assertTrue(resultado.contains("especializacao"));
		Assert.assertTrue(resultado.contains("Natacao"));
		Assert.assertTrue(resultado.contains("Isso � uma sugest�o!"));
		
	}
		

}
