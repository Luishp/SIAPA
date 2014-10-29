package com.siapa.service;

import com.siapa.dao.TipoResidenciaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tiporesidencia;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "tipoResidenciaService")
public class TipoResidenciaService extends GenericService<Tiporesidencia, Integer> {

    @Autowired
    private TipoResidenciaDao tipoResidenciaDao;

    @Override
    public GenericDao<Tiporesidencia, Integer> getDao() {
        return tipoResidenciaDao;
    }
}
