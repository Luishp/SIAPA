package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Municipios;
import org.springframework.stereotype.Repository;

@Repository(value = "municipioDao")
public class MunicipioDao extends GenericDao<Municipios, Integer> {

}
