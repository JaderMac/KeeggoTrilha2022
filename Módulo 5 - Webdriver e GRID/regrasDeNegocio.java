import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class regrasDeNegocio {
	
	@Test
	public void regraVegetariano() {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - "
				+ "Automacao de testes/libs/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
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
		driver.quit();
	}
	
	@Test
	public void regraEsportista() {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - "
				+ "Automacao de testes/libs/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
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
		driver.quit();
	}
	

}
