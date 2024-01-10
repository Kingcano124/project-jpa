package com.david.projectjpa.dao.impl;
import com.david.projectjpa.dao.SubGeneroDAO;
import com.david.projectjpa.entity.SubGenero;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SubGeneroDAOImplTest {
    SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();
    @org.junit.jupiter.api.Test
    void findAll(){

       List<SubGenero> resultSubgeneros = this.subGeneroDAO.findAll();


        assertTrue(resultSubgeneros.size() > 0);
        resultSubgeneros.forEach(subGenero -> {
            System.out.println("Los subgeneros existentes son: " +subGenero.getDescripcion()+"-- Genero principal: " +subGenero.getGenero().getDescripcion());
        });
    }
}
