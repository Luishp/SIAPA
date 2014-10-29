package com.siapa.service;

import com.siapa.dao.PromocionDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Promocion;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "promocionService")
public class PromocionService extends GenericService<Promocion, Integer> {

    @Autowired
    private PromocionDao promocionDao;

    @Override
    public GenericDao<Promocion, Integer> getDao() {
        return promocionDao;
    }

}
