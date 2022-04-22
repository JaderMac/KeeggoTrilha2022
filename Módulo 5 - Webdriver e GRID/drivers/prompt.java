import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class prompt {
	@Test
	public void verificaPrompt (){
			System.setProperty("webdriver.chrome.driver",	
					"D://Java Completo//Livro - "
					+ "Automacao de testes/libs/drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");		
			driver.findElement(By.id("prompt")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Digite um numero",alert.getText());
			alert.sendKeys("19");
			alert.accept();
			Assert.assertEquals("Era 19?",alert.getText());
			alert.accept();
			Assert.assertEquals(":D",alert.getText());
			driver.quit();
	}
}
			
