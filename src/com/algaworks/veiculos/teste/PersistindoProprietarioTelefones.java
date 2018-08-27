package com.algaworks.veiculos.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.dominio.Proprietario;
import com.algaworks.veiculos.util.JpaUtil;

public class PersistindoProprietarioTelefones {
	
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Sebastião");
		proprietario.getTelefones().add("(34) 1234-5678");
		proprietario.getTelefones().add("(11) 9876-5432");
		
		manager.persist(proprietario);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
