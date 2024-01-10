package com.david.projectjpa.dao;

import com.david.projectjpa.entity.Disquera;

import java.util.List;

public interface DisqueraDAO {
    void save(Disquera disquera);
    void update(Disquera disquera);
    void delete(Long id);

    List<Disquera> find();

    Disquera findById(Long id);

    Disquera consultByDescripcionJPQL(String descripcion);

    /**
     * Metodo que permite realizar una consulta a la entidad Disquera con código nativo.
     * @param descripcion {@link String} descripcion de la disquera.
     * @return {@link Disquera} la disquera consultada.
     */
    Disquera consultByDescripcionNative(String descripcion);

}
