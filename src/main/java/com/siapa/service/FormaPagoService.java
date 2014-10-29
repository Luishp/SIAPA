package com.siapa.service;

import com.siapa.dao.FormaPagoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Formapago;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value="formaPagoService")
public class FormaPagoService extends GenericService<Formapago, Integer> {

    @Autowired
    private FormaPagoDao formaPagoDao;
            
    @Override
    public GenericDao<Formapago, Integer> getDao() {
        return formaPagoDao;
    }
    
    
}
