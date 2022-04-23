import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class CampoTreinamento {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testeDeCamposTextos() {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - "
				+ "Automacao de testes/libs/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Jader");
		Assert.assertEquals("Jader", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}
	

}

