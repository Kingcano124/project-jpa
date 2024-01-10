package com.david.projectjpa.dao.impl;

import com.david.projectjpa.dao.SubGeneroDAO;
import com.david.projectjpa.entity.SubGenero;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class SubGeneroDAOImpl implements SubGeneroDAO {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("persistenceConfiguration");
    @Override
    public void save(SubGenero subGenero) {

    }

    @Override
    public void update(SubGenero subGenero) {

    }

    @Override
    public void delete(SubGenero subGenero) {

    }

    @Override
    public void findById(Long id) {

    }

    @Override
    public List<SubGenero> findAll() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<SubGenero> consultSubGenero = em.createQuery("FROM SubGenero", SubGenero.class);

        return consultSubGenero.getResultList();
    }
}
