package com.algaworks.veiculos.teste;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Acessorio;
import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoVeiculoAcessorios {
	
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		
		System.out.println("Veículo: " + veiculo.getModelo());
		
		for (Acessorio acessorio : veiculo.getAcessorios()) {
			System.out.println("Acessório: " + acessorio.getDescricao());
		}
		
		manager.close();
		JpaUtil.close();
	}
}
