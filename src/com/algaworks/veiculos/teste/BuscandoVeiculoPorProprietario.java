package com.algaworks.veiculos.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.dominio.Proprietario;
import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoVeiculoPorProprietario {
	
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Proprietario proprietario = manager.find(Proprietario.class, 1L);
		
		//System.out.println(proprietario.getVeiculo().getModelo() + " - " + proprietario.getNome());
		
		manager.close();
		JpaUtil.close();
	}
}
