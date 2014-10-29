package com.siapa.service;

import com.siapa.dao.DepartamentoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Departamentos;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "departamentoService")
public class DepartamentoService extends GenericService<Departamentos, Integer> {

    @Autowired
    private DepartamentoDao departamentoDao;

    @Override
    public GenericDao<Departamentos, Integer> getDao() {
        return departamentoDao;
    }

}
