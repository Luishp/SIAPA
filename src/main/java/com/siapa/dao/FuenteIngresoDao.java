package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Fuenteingreso;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value="fuenteIngresoDao")
public class FuenteIngresoDao extends GenericDao<Fuenteingreso, Integer>{
    
}
