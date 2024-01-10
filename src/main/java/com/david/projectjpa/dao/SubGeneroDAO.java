package com.david.projectjpa.dao;

import com.david.projectjpa.entity.SubGenero;

import java.util.List;

public interface SubGeneroDAO {

    void save (SubGenero subGenero);
    void update (SubGenero subGenero);
    void delete (Long id);
    SubGenero findById(Long id);
    List<SubGenero> findAll();
}
