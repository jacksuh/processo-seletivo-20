package com.hepta.funcionarios.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class funcionariosTeste {

	public static void main(String[] args) {
		
		Funcionario novoFuncionario = new Funcionario();
		novoFuncionario.setNome("Jackson");
		novoFuncionario.setEmail("jackson@jackson");
		novoFuncionario.setIdade(35);
		novoFuncionario.setSalario(300.00);
		
			
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("funcionarios-bd");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(novoFuncionario);
		em.getTransaction().commit();
	
	}
}
