import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ComboMultiplaEscolha {
	@Test
	public void testeDeComboMultiplaEscolha() {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - "
				+ "Automacao de testes/libs/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
		
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(elemento);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		// Assert.assertEquals(3, combo.getAllSelectedOptions().size());
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3,allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2,allSelectedOptions.size());
		
		driver.quit();
	}
}
