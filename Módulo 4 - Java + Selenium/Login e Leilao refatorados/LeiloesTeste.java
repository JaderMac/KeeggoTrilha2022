package leiloes;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeiloesTeste {

	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;

	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		this.paginaDeLeiloes = paginaDeLogin.preencheFormulárioLogin("Fulano","pass");
		this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
	}
	
	@AfterEach
	public void afterEach() {
		paginaDeLeiloes.fechar();
	}
	
	@Test
	public void cadastraNovoLeilao() {
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilão do dia " + hoje;
		String valor = "500.00";
		this.paginaDeLeiloes =  paginaDeCadastro.cadastrarLeilao(hoje, nome, valor);
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(hoje, nome, valor));
	}
	
	@Test
	public void deveriaCadastroLeilaoSemData() {
		this.paginaDeLeiloes =  paginaDeCadastro.cadastrarLeilao("", "", "");
		Assert.assertTrue(paginaDeLeiloes.isPaginaAtual());
		Assert.assertTrue(paginaDeLeiloes.isMensagensVisiveis());
	}

}
