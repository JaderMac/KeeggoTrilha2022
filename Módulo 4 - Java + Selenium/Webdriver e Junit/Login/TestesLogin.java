package alura;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestesLogin {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void BeforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void AfterEach() {
		this.paginaDeLogin.fechar();
	}
	
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.preencheFormul�rioLogin("Fulano","pass");
		Assert.assertFalse(paginaDeLogin.IsPaginaDeLogin());
		Assert.assertEquals("fulano", paginaDeLogin.pegaNomeUsuarioLogado());
	}
	@Test
	public void n�oLogarComDadosInvalidos() {
		paginaDeLogin.preencheFormul�rioLogin("INVALIDO","123ABC");
		Assert.assertFalse(paginaDeLogin.IsPaginaDeLoginComErro());
	}
	
	@Test
	public void n�oDeveriaAcessarPaginaRestritaSemLogar() {
		paginaDeLogin.acessaPaginaRestrita();
		Assert.assertTrue(paginaDeLogin.IsPaginaDeLogin());
		Assert.assertFalse(paginaDeLogin.validaPresen�aDeTexto("Dados do Leil�o"));
	}

}
