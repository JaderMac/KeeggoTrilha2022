import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testeFrame {
	@Test
	public void interagirComFrame() {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - "
				+ "Automacao de testes/libs/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
		driver.switchTo().frame("Frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alertaDoFrame = driver.switchTo().alert();
		String mensagemDoFrame = alertaDoFrame.getText();
		Assert.assertEquals("Frame OK!",mensagemDoFrame);
		alertaDoFrame.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(mensagemDoFrame);
		driver.quit();
	}
	@Test
	public void interagirComJanelas() {
		System.setProperty("webdriver.chrome.driver",	
				"D://Java Completo//Livro - "
				+ "Automacao de testes/libs/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20Completo/Udemy%20-%20WebDriver%20e%20Grid/Arquivos/componentes.html");
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu Certo!");
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("e agora?");
		driver.quit();
	}
}
