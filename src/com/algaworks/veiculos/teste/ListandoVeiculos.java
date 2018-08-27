package com.algaworks.veiculos.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class ListandoVeiculos {
	
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Query query = manager.createQuery("from Veiculo");
		
		@SuppressWarnings("unchecked")
		List<Veiculo> veiculos = query.getResultList();
		
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getCodigo() + " - "
					+ veiculo.getFabricante() + " "
					+ veiculo.getModelo() + ", ano "
					+ veiculo.getAnoFabricacao() + "/"
					+ veiculo.getAnoModelo() + " por "
					+ "R$" + veiculo.getValor());
		}
		
		manager.close();
		JpaUtil.close();
	}
}
