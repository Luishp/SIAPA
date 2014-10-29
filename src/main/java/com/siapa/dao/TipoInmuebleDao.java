package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tipoinmueble;
import org.springframework.stereotype.Repository;

@Repository(value = "tipoInmuebleDao")
public class TipoInmuebleDao extends GenericDao<Tipoinmueble, Integer> {

}
