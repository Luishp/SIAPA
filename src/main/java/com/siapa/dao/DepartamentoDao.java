package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Departamentos;
import org.springframework.stereotype.Repository;

@Repository(value = "departamentoDao")
public class DepartamentoDao extends GenericDao<Departamentos, Integer> {

}
