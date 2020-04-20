package com.Divsoft.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Divsoft.Entidade.Funcionario;


@Repository
public  interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
