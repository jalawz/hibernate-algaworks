package com.algaworks.veiculos.teste;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Proprietario;
import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoProprietarioTelefones {
	
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		Proprietario proprietario = manager.find(Proprietario.class, 1L);
		System.out.println("Proprietário: " + proprietario.getNome());
		
		for (String telefone: proprietario.getTelefones()) {
			System.out.println("Telefone: " + telefone);
		}
		
		manager.close();
		JpaUtil.close();
	}
}
