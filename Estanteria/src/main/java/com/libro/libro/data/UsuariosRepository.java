package com.libro.libro.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, String> {

}