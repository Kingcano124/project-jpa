package com.david.projectjpa.dao.impl;


import com.david.projectjpa.dao.DisqueraDAO;
import com.david.projectjpa.entity.Disquera;

import javax.persistence.*;
import java.util.List;

public class DisqueraDAOImpl implements DisqueraDAO {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("persistenceConfiguration");

    @Override
    public void save(Disquera disquera) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        try {
            em.persist(disquera);
            et.commit();
        }catch (Exception e){

           if(et != null){
               et.rollback();
           }
           e.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Override
    public void update(Disquera disquera) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        try {
            em.merge(disquera);
            et.commit();
        }catch (Exception e){

            if(et != null){
                et.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }

    }

    @Override
    public void delete(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        Disquera DisqueraConsulted = em.find(Disquera.class,id);

        if (DisqueraConsulted != null) {
            EntityTransaction et = em.getTransaction();
            et.begin();

            try {
                em.remove(DisqueraConsulted);
                et.commit();
            } catch (Exception e) {
                System.out.println("Error al eliminar el registro.");
                System.out.println(e.getMessage());
            } finally {
                em.close();
            }
        }else{
            throw new EntityNotFoundException("Entidad no encontrada");
        }
    }

    @Override
    public List<Disquera> find() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<Disquera> queryDisquera  = (TypedQuery<Disquera>) em.createQuery("FROM Disquera");

       return queryDisquera.getResultList();
    }

    @Override
    public Disquera findById(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        Disquera result = em.find(Disquera.class,id);

            if(result == null){
                throw new EntityNotFoundException("No se encontraron datos");
            }

        return result;
    }

    @Override
    public Disquera consultByDescripcionJPQL(String descripcion) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<Disquera> queryDisquera  = (TypedQuery<Disquera>) em.createQuery("FROM Disquera WHERE descripcion = :desc");
        queryDisquera.setParameter("desc",descripcion);

        return queryDisquera.getSingleResult();
    }

    @Override
    public Disquera consultByDescripcionNative(String descripcion) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<Disquera> queryDisquera  = (TypedQuery<Disquera>) em.createNativeQuery("SELECT * FROM disquera WHERE descripcion = :desc", Disquera.class);
        queryDisquera.setParameter("desc",descripcion);

        return queryDisquera.getSingleResult();
    }
}
