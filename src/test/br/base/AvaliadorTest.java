package test.br.base;

import static org.junit.Assert.*;

import org.junit.Test;

import br.base.Avaliador;
import br.base.Lance;
import br.base.Leilao;
import br.base.Usuario;

public class AvaliadorTest {
	

	@Test
	public void deveEntenderLeilaoSemLances() {
		//definindo cenário
				Leilao leilao = new Leilao("Playstation 8");
				Avaliador leiloeiro = new Avaliador();
				
				//ação
				leiloeiro.avalia(leilao);
				
				//validação
				//System.out.println(leiloeiro.getMaior()==1000.0);
				assertEquals(0.0, leiloeiro.getMaior(),0.00001);
				assertEquals(Double.MAX_VALUE, leiloeiro.getMenor(),0.0001);
	}
	@Test
	public void deveEntenderLancesEmOrdemCrescenteLimitrofes() {
		//definindo cenário
				Leilao leilao = new Leilao("Playstation 8");
				Usuario joao = new Usuario("João");
				Usuario maria= new Usuario("Maria");
				Usuario pedro= new Usuario("Pedro");
				Avaliador leiloeiro = new Avaliador();
				
				//ação
				leilao.propoe(new Lance(joao, 90.0));
				leilao.propoe(new Lance(maria, 90.001));
				leilao.propoe(new Lance(pedro, 90.01));
				leiloeiro.avalia(leilao);
				
				//validação
				//System.out.println(leiloeiro.getMaior()==1000.0);
				assertEquals(90.01, leiloeiro.getMaior(),0.00001);
	}
	@Test
	public void deveEntenderLeilaoComUmLance() {
		//definindo cenário
				Leilao leilao = new Leilao("Playstation 8");
				Usuario joao = new Usuario("João");
				Avaliador leiloeiro = new Avaliador();
				
				//ação
				leilao.propoe(new Lance(joao, 90.0));
				leiloeiro.avalia(leilao);
				
				//validação
				//System.out.println(leiloeiro.getMaior()==1000.0);
				assertEquals(90.0, leiloeiro.getMaior(),0.00001);
				assertEquals(90.0, leiloeiro.getMenor(),0.00001);
	}
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		//definindo cenário
				Leilao leilao = new Leilao("Playstation 8");
				Usuario joao = new Usuario("João");
				Usuario maria= new Usuario("Maria");
				Usuario pedro= new Usuario("Pedro");
				Avaliador leiloeiro = new Avaliador();
				
				//ação
				leilao.propoe(new Lance(joao, 90.0));
				leilao.propoe(new Lance(maria, 500.0));
				leilao.propoe(new Lance(pedro, 1000.0));
				leiloeiro.avalia(leilao);
				
				//validação
				//System.out.println(leiloeiro.getMaior()==1000.0);
				assertEquals(1000.0, leiloeiro.getMaior(),0.00001);
	}
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		//definindo cenário
		Leilao leilao = new Leilao("Playstation 8");
		Usuario joao = new Usuario("João");
		Usuario maria= new Usuario("Maria");
		Usuario pedro= new Usuario("Pedro");
		Avaliador leiloeiro = new Avaliador();
		
		//ação
		leilao.propoe(new Lance(joao, 990.0));
		leilao.propoe(new Lance(maria, 500.0));
		leilao.propoe(new Lance(pedro, 100.0));
		leiloeiro.avalia(leilao);
		
		//validação
		//System.out.println(leiloeiro.getMaior()==1000.0);
		assertEquals(990.0, leiloeiro.getMaior(),0.00001);
	}
	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {
		//definindo cenário
		Leilao leilao = new Leilao("Playstation 8");
		Usuario joao = new Usuario("João");
		Usuario maria= new Usuario("Maria");
		Usuario pedro= new Usuario("Pedro");
		Avaliador leiloeiro = new Avaliador();
		
		//ação
		leilao.propoe(new Lance(joao, 99.0));
		leilao.propoe(new Lance(joao, 990.0));
		leilao.propoe(new Lance(maria, 50.0));
		leilao.propoe(new Lance(maria, 500.0));
		leilao.propoe(new Lance(maria, 450.0));
		leilao.propoe(new Lance(pedro, 100.0));
		leiloeiro.avalia(leilao);
		
		//validação
		//System.out.println(leiloeiro.getMaior()==1000.0);
		assertEquals(990.0, leiloeiro.getMaior(),0.00001);
	}

}
