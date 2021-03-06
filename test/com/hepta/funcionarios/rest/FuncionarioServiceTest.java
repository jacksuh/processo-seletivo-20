package com.hepta.funcionarios.rest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.*;


import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;
import com.hepta.funcionarios.persistence.SetorDAO;



class FuncionarioServiceTest {

	
	private FuncionarioDAO dao;
	private SetorDAO daoSetor;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}
	
	@Test
	void testFuncionarioRead() throws Exception {
		//Confirma se possui uma lista no Banco e Dados.
		List<Funcionario> funcionarios = new ArrayList<>();
		
		dao = new FuncionarioDAO();
		funcionarios = dao.getAll();
		
		assertNotEquals(0, funcionarios.size());
	}

	@Test
	void testFuncionarioCreate() throws Exception {
		//Cadastro do Setor
		Setor novoSetor = new Setor();
		novoSetor.setNome("RH");
		
		daoSetor = new SetorDAO();
		daoSetor.save(novoSetor);
		
		//Cadastro de funcionario
		Funcionario novoFuncionario = new Funcionario();
		novoFuncionario.setNome("Jackson");
		novoFuncionario.setEmail("jackson@jackson");
		novoFuncionario.setIdade(33);
		novoFuncionario.setSalario(300.00);	
		novoFuncionario.setSetor(novoSetor);
		
						
		dao = new FuncionarioDAO();
		dao.save(novoFuncionario);
		
		Integer id = novoFuncionario.getId();
		assertNotNull(id);
		
		
	}

	@Test
	void testFuncionarioUpdate() throws Exception {
		//Cadastro do Setor
		Setor novoSetor = new Setor();
		novoSetor.setNome("FINANCEIRO");
		
		daoSetor = new SetorDAO();
		daoSetor.save(novoSetor);
		
		//Cadastro de funcionario
		
		Funcionario novoFuncionario = new Funcionario();
		novoFuncionario.setNome("Jackson");
		novoFuncionario.setEmail("jackson@jackson");
		novoFuncionario.setIdade(33);
		novoFuncionario.setSalario(300.00);
		novoFuncionario.setSetor(novoSetor);
		
		dao = new FuncionarioDAO();
		dao.save(novoFuncionario);
		
		Integer id = novoFuncionario.getId();
		
		Funcionario f = dao.find(id);
		
		f.setNome("Jackson Silva");
		f.setSalario(500.00);
		
		dao = new FuncionarioDAO();
		dao.update(f);
		
		Funcionario fAtualizado = dao.find(id);
		
		assertEquals("Jackson Silva", fAtualizado.getNome());
		assertEquals(500.00, fAtualizado.getSalario());
		
		//Atualiza??o do Setor
		
		Integer idSetor = novoSetor.getId();
		
		Setor s = daoSetor.find(idSetor);
		
		s.setNome("RH");
		
		daoSetor = new SetorDAO();
		daoSetor.update(s);
		
		Setor sAtualizado = daoSetor.find(idSetor);
		
		assertEquals("RH", sAtualizado.getNome());
		
	}

	@Test
	void testFuncionarioDelete() throws Exception {
		//Cadastro do Setor
		Setor novoSetor = new Setor();
		novoSetor.setNome("TI");
		
		daoSetor = new SetorDAO();
		daoSetor.save(novoSetor);
		
		//Cadastro de funcionario
		Funcionario novoFuncionario = new Funcionario();
		novoFuncionario.setNome("Jackson");
		novoFuncionario.setEmail("jackson@jackson");
		novoFuncionario.setIdade(33);
		novoFuncionario.setSalario(300.00);
		novoFuncionario.setSetor(novoSetor);
		
		//Confirmar se o cadastro do funcionario foi deletado.
		dao = new FuncionarioDAO();
		dao.save(novoFuncionario);
		
		Integer id = novoFuncionario.getId();
		
		dao.delete(id);
		
		Funcionario f = dao.find(id);
		
		assertNull(f);
		
		//Confirmar se o cadastro do setor foi deletado.
		Integer idSetor = novoSetor.getId();
		
		daoSetor = new SetorDAO();
		daoSetor.delete(idSetor);
		
		Setor s = daoSetor.find(idSetor);
		
		assertNull(s);
		
	}

}
