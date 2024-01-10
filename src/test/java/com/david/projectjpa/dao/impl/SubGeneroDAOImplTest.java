package com.david.projectjpa.dao.impl;
import com.david.projectjpa.dao.SubGeneroDAO;
import com.david.projectjpa.entity.Genero;
import com.david.projectjpa.entity.SubGenero;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SubGeneroDAOImplTest {
    SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();
    @org.junit.jupiter.api.Test
    void save(){
        SubGenero subGenero = new SubGenero();
        subGenero.setDescripcion("Reque 1");
        subGenero.setFechaCreacion(LocalDateTime.now());
        subGenero.setFechaModificacion(LocalDateTime.now());
        subGenero.setStatus(true);

        Genero genero = new Genero();
        genero.setDescripcion("Regueton");
        genero.setFechaCreacion(LocalDateTime.now());
        genero.setFechaModificacion(LocalDateTime.now());
        genero.setStatus(true);

        subGenero.setGenero(genero);

        subGeneroDAO.save(subGenero);

    }
    @org.junit.jupiter.api.Test
    void update(){
        SubGenero subGeneroConsultado = this.subGeneroDAO.findById(6L);

        subGeneroConsultado.setDescripcion("David Hijo");
        subGeneroConsultado.getGenero().setDescripcion("David Padre");

        subGeneroDAO.update(subGeneroConsultado);
    }
    @org.junit.jupiter.api.Test
    void delete(){
        subGeneroDAO.delete(6L);
        System.out.printf("Registro eliminado correctamente");
    }
    @org.junit.jupiter.api.Test
    void findAll(){

       List<SubGenero> resultSubgeneros = this.subGeneroDAO.findAll();
        assertTrue(resultSubgeneros.size() > 0);
        resultSubgeneros.forEach(subGenero -> {
            System.out.println("Los subgeneros existentes son: " +subGenero.getDescripcion()+"-- Genero principal: " +subGenero.getGenero().getDescripcion());
        });
    }
}
