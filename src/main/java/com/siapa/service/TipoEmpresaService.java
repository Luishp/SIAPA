package com.siapa.service;

import com.siapa.dao.TipoEmpresaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tipoempresa;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "tipoEmpresaService")
public class TipoEmpresaService extends GenericService<Tipoempresa, Integer> {

    @Autowired
    private TipoEmpresaDao tipoEmpresaDao;

    @Override
    public GenericDao<Tipoempresa, Integer> getDao() {
        return tipoEmpresaDao;
    }

}
