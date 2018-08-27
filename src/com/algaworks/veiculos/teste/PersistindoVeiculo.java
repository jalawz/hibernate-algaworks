package com.algaworks.veiculos.teste;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.dominio.Proprietario;
import com.algaworks.veiculos.dominio.TipoCombustivel;
import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class PersistindoVeiculo {
	
	public static void main(String[] args) throws IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		// lẽ bytes do arquivo da imagem
		// Path path = FileSystems.getDefault().getPath("/home/paulo/Imagens/fiesta.jpg");
		// byte[] foto = Files.readAllBytes(path);
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João das Couves");
		//proprietario.setTelefone("(34) 1234-5678");
		
		manager.persist(proprietario);
		
		/*StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");*/
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Ford");
		veiculo.setModelo("New Fiesta");
		veiculo.setAnoFabricacao(2014);
		veiculo.setAnoModelo(2014);
		veiculo.setValor(new BigDecimal(38_000));
		veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo.setDataCadastro(new Date());
		veiculo.setProprietario(proprietario);
		
		manager.persist(veiculo);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
