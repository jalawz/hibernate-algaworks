package com.algaworks.veiculos.teste;

import javax.persistence.Persistence;

public class CriaTabelas {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("AlgaWorksPU");
	}
}
