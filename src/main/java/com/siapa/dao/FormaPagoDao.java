package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Formapago;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "formaPagoDao")
public class FormaPagoDao extends GenericDao<Formapago, Integer>  {
    
}

