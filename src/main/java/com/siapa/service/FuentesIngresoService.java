package com.siapa.service;

import com.siapa.dao.FuenteIngresoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Fuenteingreso;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "fuentesIngresoService")
public class FuentesIngresoService extends GenericService<Fuenteingreso, Integer> {

    @Autowired
    private FuenteIngresoDao fuenteIngresoDao;

    @Override
    public GenericDao<Fuenteingreso, Integer> getDao() {
        return fuenteIngresoDao;
    }

}
