package com.siapa.service;

import com.siapa.dao.AsociadoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Asociados;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "asociadoService")
public class AsociadoService extends GenericService<Asociados, Integer> {

    @Autowired
    private AsociadoDao asociadoDao;

    @Override
    public GenericDao<Asociados, Integer> getDao() {
        return asociadoDao;
    }

    /**
     * Metodo para buscar un asociado por medio del codigo
     * @param codigoAsociado
     * @return 
     */
    public Asociados findByCodigo(String codigoAsociado) {
        return asociadoDao.findByCodigo(codigoAsociado);
    }

}
