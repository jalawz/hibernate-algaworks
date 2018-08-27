package com.algaworks.veiculos.teste;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoVeiculo2 {
	
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
		
		System.out.println("Veículo de código " + veiculo.getCodigo() + " é um " + veiculo.getModelo());
		
		manager.close();
		JpaUtil.close();
	}
}
