package br.controller;


import br.base.Avaliador;
import br.base.Lance;
import br.base.Leilao;
import br.base.Usuario;

public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println(leiloeiro.getMaior()==1000.0);
		
		
	}

}
