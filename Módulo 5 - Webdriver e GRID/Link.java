import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class Link {
		@Test
		public void verificaLink (){
				System.setProperty("webdriver.chrome.driver",	
						"D://Java Completo//Livro - "
						+ "Automacao de testes/libs/drivers/chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");		
				driver.findElement(By.linkText("Voltar")).click();
				driver.quit();
				Assert.fail();
		}
		@Test
		public void deveBuscarTextoNaPagina() {
			System.setProperty("webdriver.chrome.driver",	
					"D://Java Completo//Livro - "
					+ "Automacao de testes/libs/drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
			driver.findElement(By.linkText("Voltar")).click();
			// Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
			
			Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
			Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",driver.findElement(By.tagName("span")).getText());
			driver.quit();
		}
}
