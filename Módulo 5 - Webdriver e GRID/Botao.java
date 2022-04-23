import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Botao {
		@Test
		public void veliricabotao (){
				System.setProperty("webdriver.chrome.driver",	
						"D://Java Completo//Livro - "
						+ "Automacao de testes/libs/drivers/chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
				driver.findElement(By.id("buttonSimple")).click();
				Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
				driver.close();
		}
}
