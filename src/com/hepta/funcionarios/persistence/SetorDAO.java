package com.hepta.funcionarios.persistence;

import javax.persistence.EntityManager;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;



public class SetorDAO {

	public void save(Setor setor) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(setor);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
	}
	
	public Setor find(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Setor Setor = null;
		try {
			Setor = em.find(Setor.class, id);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return Setor;
	}
	
}
