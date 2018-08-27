package com.algaworks.veiculos.teste;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.dominio.Proprietario;
import com.algaworks.veiculos.dominio.TipoCombustivel;
import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class PersistindoVeiculos {
	
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Jão");
		//proprietario.setTelefone("(34) 1234-5678");
		
		manager.persist(proprietario);
		
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setFabricante("GM");
		veiculo1.setModelo("Celta");
		veiculo1.setAnoFabricacao(2006);
		veiculo1.setAnoModelo(2006);
		veiculo1.setValor(new BigDecimal(11_000));
		veiculo1.setTipoCombustivel(TipoCombustivel.GASOLINA);
		veiculo1.setDataCadastro(new Date());
		veiculo1.setProprietario(proprietario);
		
		manager.persist(veiculo1);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setFabricante("VW");
		veiculo2.setModelo("Gol");
		veiculo2.setAnoFabricacao(2010);
		veiculo2.setAnoModelo(2010);
		veiculo2.setValor(new BigDecimal(17_200));
		veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo2.setDataCadastro(new Date());
		veiculo2.setProprietario(proprietario);
		
		manager.persist(veiculo2);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
