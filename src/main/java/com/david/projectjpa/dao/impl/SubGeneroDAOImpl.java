package com.david.projectjpa.dao.impl;

import com.david.projectjpa.dao.SubGeneroDAO;
import com.david.projectjpa.entity.SubGenero;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

public class SubGeneroDAOImpl implements SubGeneroDAO {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("persistenceConfiguration");
    @Override
    public void save(SubGenero subGenero) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        try {
            em.persist(subGenero);
            et.commit();
        }catch (Exception e ){
            et.rollback();
            System.out.printf("Error al realizar la inserción.");
        }finally{
            em.close();
        }

    }

    @Override
    public void update(SubGenero subGenero) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        try {
            em.merge(subGenero);
            et.commit();
        }catch (Exception e ){
            et.rollback();
            System.out.printf("Error al realizar la inserción.");
        }finally{
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        SubGenero  resultSubGenero = em.find(SubGenero.class, id);

        if (resultSubGenero != null){
            EntityTransaction et = em.getTransaction();
            et.begin();

            try{
                em.remove(resultSubGenero);
                et.commit();
            }catch (Exception e){
                et.rollback();
                System.out.println("Entidad no encontrada");
            }finally{
                em.close();
            }

        }

    }

    @Override
    public SubGenero findById(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        SubGenero result = em.find(SubGenero.class,id);

        if(result == null){
            throw new EntityNotFoundException("No se encontro la entidad");
        }

        return result;

    }

    @Override
    public List<SubGenero> findAll() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<SubGenero> consultSubGenero = em.createQuery("FROM SubGenero", SubGenero.class);

        return consultSubGenero.getResultList();
    }
}
