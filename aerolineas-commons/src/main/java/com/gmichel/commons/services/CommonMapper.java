package com.gmichel.commons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class CommonMapper <D, E, R extends JpaRepository<E, Long>> {

    @Autowired
    protected R repository;

    public D dtoToEntity(E entity) {
        return null;
    }

    public E entityToDto(D entity) {
        return null;
    }
}