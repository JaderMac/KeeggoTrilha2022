import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ComboBox {
	@Test
	public void testeDeCombo() {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - "
				+ "Automacao de testes/libs/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
		
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(elemento);
		// combo.selectByIndex(2);
		// combo.selectByValue("superior");
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		driver.quit();
	}
}
