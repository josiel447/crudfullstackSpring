package com.exemplo.crudmongo.repository;

import com.exemplo.crudmongo.Model.Pessoa;
import org.springframework.data.Jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorycopy extends JpaRepository<Pessoa, Long> {
}


