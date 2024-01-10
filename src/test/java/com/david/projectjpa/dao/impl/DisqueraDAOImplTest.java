package com.david.projectjpa.dao.impl;

import com.david.projectjpa.dao.DisqueraDAO;
import com.david.projectjpa.entity.Disquera;
import org.w3c.dom.ls.LSInput;

import javax.persistence.EntityNotFoundException;
import java.lang.invoke.StringConcatFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraDAOImplTest {

    private DisqueraDAO disqueraDAO = new DisqueraDAOImpl();

    @org.junit.jupiter.api.Test
    void save() {

        Disquera disquera = new Disquera();
        disquera.setDescripcion("Esto es una descripcion");
        disquera.setFechaCreacion(LocalDateTime.now());
        disquera.setStatus(true);

        this.disqueraDAO.save(disquera);
    }

    @org.junit.jupiter.api.Test
    void update() {

        Disquera disqueraConsultada = this.disqueraDAO.findById(9L);

        if(disqueraConsultada != null){
            disqueraConsultada.setDescripcion("Twenty one pilost");
            disqueraDAO.update(disqueraConsultada);
        }
    }

    @org.junit.jupiter.api.Test
    void delete() {

            disqueraDAO.delete(9L);
            System.out.printf("Disquera eliminada correctamente.");
    }

    @org.junit.jupiter.api.Test
    void find() {
        List<Disquera> disquerasConsulted = this.disqueraDAO.find();
        assertTrue(disquerasConsulted.size()>0);
        disquerasConsulted.forEach(disquera -> {
            System.out.println("Disquera: "+disquera.getDescripcion());
        });

    }

    @org.junit.jupiter.api.Test
    void findById() {

       try{
           Disquera disquera = this.disqueraDAO.findById(9L);
           /*if(disquera == null) {
               throw new EntityNotFoundException("No se encontraron datos con el criterio de busqueda");
           }*/
           System.out.println("La disquera recuperada es: "+disquera.getDescripcion());
       }catch (EntityNotFoundException e){
           System.out.println(e.getMessage());
       }

    }

    @org.junit.jupiter.api.Test
    void consultByDescripcionJPQL(){
        Disquera resultDisquera = this.disqueraDAO.consultByDescripcionJPQL("LP");

        assertNotNull(resultDisquera);
        System.out.println("La disquera consultada es: "+resultDisquera.getDescripcion()+"- estado - "+resultDisquera.isStatus());
    }

    @org.junit.jupiter.api.Test
    void consultByDescripcionNative(){
        Disquera resultDisquera = this.disqueraDAO.consultByDescripcionNative("LP");

        assertNotNull(resultDisquera);
        System.out.println("La disquera consultada es: "+resultDisquera.getDescripcion()+" - estado - "+resultDisquera.isStatus());
    }
}