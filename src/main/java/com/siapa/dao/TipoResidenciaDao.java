package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tiporesidencia;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "tipoResidenciaDao")
public class TipoResidenciaDao extends GenericDao<Tiporesidencia, Integer> {

}
