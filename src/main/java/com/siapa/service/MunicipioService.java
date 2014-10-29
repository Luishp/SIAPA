package com.siapa.service;

import com.siapa.dao.MunicipioDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Municipios;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "municipioService")
public class MunicipioService extends GenericService<Municipios, Integer> {

    @Autowired
    private MunicipioDao municipioDao;

    @Override
    public GenericDao<Municipios, Integer> getDao() {
        return municipioDao;
    }


}
