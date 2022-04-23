import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertaComConfirma {
	@Test
	public void verificaAlertConfirmando (){
			System.setProperty("webdriver.chrome.driver",	
					"D://Java Completo//Livro - "
					+ "Automacao de testes/libs/drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");		
			driver.findElement(By.id("confirm")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Assert.assertEquals("Confirmado", alert.getText());
			driver.quit();

	}
	@Test
	public void verificaAlertNegando (){
			System.setProperty("webdriver.chrome.driver",	
					"D://Java Completo//Livro - "
					+ "Automacao de testes/libs/drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");		
			driver.findElement(By.id("confirm")).click();
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			Assert.assertEquals("Negado", alert.getText());
			driver.quit();
	
	}
}
