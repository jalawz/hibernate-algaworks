package com.algaworks.veiculos.teste;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class TestaDetached {
	
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo1 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela primeira vez...");
		
		System.out.println("Gerenciado? " + manager.contains(veiculo1));
		manager.detach(veiculo1);
		System.out.println("E agora? " + manager.contains(veiculo1));
		
		Veiculo veiculo2 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela segunda vez...");
		
		System.out.println("Mesmo veículo? " + (veiculo1 == veiculo2));
		
		manager.close();
		JpaUtil.close();
		
	}
}
