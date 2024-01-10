package com.david.projectjpa.dao;

import com.david.projectjpa.entity.SubGenero;

import java.util.List;

public interface SubGeneroDAO {

    void save (SubGenero subGenero);
    void update (SubGenero subGenero);
    void delete (SubGenero subGenero);
    void findById(Long id);
    List<SubGenero> findAll();
}
