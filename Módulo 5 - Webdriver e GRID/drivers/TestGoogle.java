import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGoogle {
		
		@Test
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver",	
					"D://Java Completo//Livro - "
					+ "Automacao de testes/libs/drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			// driver.manage().window().setPosition(new Point(100, 100));
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.manage().window().maximize();
			driver.get("https://www.google.com");
			Assert.assertEquals("Google", driver.getTitle());
			driver.quit();
		}
}
