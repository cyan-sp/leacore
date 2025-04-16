package com.gmichel.commons.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class CommonMapper <D, E, R extends JpaRepository<E, Long>> {

    @Autowired
    protected R repository;

    public D entityToDTO(E entity) {
        return null;
    }
    public E dtoToEntity(D entity) {
        return null;
    }
}