package com.siapa.service;

import com.siapa.dao.TipoInmuebleDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tipoinmueble;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "tipoInmuebleService")
public class TipoInmuebleService extends GenericService<Tipoinmueble, Integer> {

    @Autowired
    private TipoInmuebleDao tipoInmuebleDao;

    @Override
    public GenericDao<Tipoinmueble, Integer> getDao() {
        return tipoInmuebleDao;
    }

}
