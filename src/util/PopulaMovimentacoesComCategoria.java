package util;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import modelo.Categoria;
import modelo.Conta;
import modelo.Movimentacao;
import modelo.TipoMovimentacao;

public class PopulaMovimentacoesComCategoria {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setNome("Viagem");
		
		Categoria categoria2 = new Categoria();
		categoria2.setNome("Negocios");
				
		Conta conta = manager.find(Conta.class, 2);

		Movimentacao movimentacao = new Movimentacao();
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		movimentacao.setData(amanha);
		movimentacao.setDescricao("Viagem a SP");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("1000.0"));
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem ao RJ");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("1300.0"));
		movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
		
		movimentacao.setConta(conta);
		movimentacao2.setConta(conta);
		
		manager.persist(categoria);
		manager.persist(categoria2);
		manager.persist(movimentacao);
		manager.persist(movimentacao2);
		
		manager.getTransaction().commit();
		manager.close();
	}
	
}
