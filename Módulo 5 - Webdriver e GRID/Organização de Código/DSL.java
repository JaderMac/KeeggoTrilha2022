import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escreve(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String ObterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}

	public void clicarRadio(String id_campo) {
		driver.findElement(By.id(id_campo)).click();
	}
	
	public boolean isRadioMarcado(String id_campo) {
		return  driver.findElement(By.id(id_campo)).isSelected();
	}
	
	public void selecionarCombo(String id_campo, String valor) {
		WebElement element = driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		
	}
	public String obterValorCombo(String id_campo) {
		WebElement element = driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public void clicarBotao(String string) {
		driver.findElement(By.id(string)).click();
	}

	public void clicaLink(String string) {
		driver.findElement(By.linkText(string)).click();
	}
	
	public String obterTexto(By by) {
		return	driver.findElement(by).getText();
	}
	
	public String obterTexto(String string) {
		return	obterTexto(By.id(string));
	}
	

}
