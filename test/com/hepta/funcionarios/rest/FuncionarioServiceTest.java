package com.hepta.funcionarios.rest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.*;


import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;



class FuncionarioServiceTest {

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Funcionario search = new Funcionario();
	}
	
	@Test
	void testFuncionarioRead() {
		Funcionario search = new Funcionario();
		search.getNome();
		search.getId();
		
		
	}

	@Test
	void testFuncionarioCreate() {
		Funcionario novoFuncionario = new Funcionario();
		novoFuncionario.setNome("Jackson");
		novoFuncionario.setEmail("jackson@jackson");
		novoFuncionario.setIdade(33);
		novoFuncionario.setSalario(300.00);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("funcionarios-bd");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(novoFuncionario);
		em.getTransaction().commit();
		
		Integer id = novoFuncionario.getId();
		assertNotNull(id);
		
		
	}

	@Test
	void testFuncionarioUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testFuncionarioDelete() {
		
	}

}
