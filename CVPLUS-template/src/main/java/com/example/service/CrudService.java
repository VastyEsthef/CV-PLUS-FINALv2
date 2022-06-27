package com.example.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {

    List<T> getAll() throws Exception;

    T getOneById(ID id)throws Exception;

    Long create(T entity)throws Exception;

    void update(ID id, T entity)throws Exception;

    void delete(ID id)throws Exception;

    //Version 2
    T saveOrUpdate(T entity)throws Exception;
    Optional<T> getOne(ID id) throws Exception;

}