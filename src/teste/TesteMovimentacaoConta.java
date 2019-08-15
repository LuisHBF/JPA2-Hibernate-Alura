package teste;

import javax.persistence.EntityManager;

import modelo.Conta;
import modelo.Movimentacao;
import util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Movimentacao movimentacao = manager.find(Movimentacao.class, 1);
		Conta conta = movimentacao.getConta();
		System.out.println(conta.getMovimentacoes().size());
	}
}
