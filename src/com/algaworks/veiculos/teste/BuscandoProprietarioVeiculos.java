package com.algaworks.veiculos.teste;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Proprietario;
import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoProprietarioVeiculos {
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Proprietario proprietario = manager.find(Proprietario.class, 1L);
		
		System.out.println("Proprietário: " + proprietario.getNome());
		
		for (Veiculo veiculo : proprietario.getVeiculos()) {
			System.out.println("Veículo: " + veiculo.getModelo());
		}
		
		manager.close();
		JpaUtil.close();
	}
}
