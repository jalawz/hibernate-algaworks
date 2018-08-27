package com.algaworks.veiculos.teste;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoVeiculo1 {
	
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		
//		System.out.println("Veículo de código " + veiculo.getCodigo() + " é um " + veiculo.getModelo());
//		System.out.println(veiculo.getDescricao());
		
		System.out.println("Veículo: " + veiculo.getModelo());
		System.out.println("-------");
		System.out.println(veiculo.getEspecificacoes());
		
		manager.close();
		JpaUtil.close();
	}
}
