import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class alertSimples {
	@Test
	public void verificaAlertSimples (){
			System.setProperty("webdriver.chrome.driver",	
					"D://Java Completo//Livro - "
					+ "Automacao de testes/libs/drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");		
			driver.findElement(By.id("alert")).click();
			Alert alert = driver.switchTo().alert();
			String texto = alert.getText();
			Assert.assertEquals("Alert Simples",texto);
			alert.accept();
			driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}
}

