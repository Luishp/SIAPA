package com.siapa.service;

import com.siapa.dao.PrestamoFinancieroDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Prestamofinanciero;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "prestamoFinancieroService")
public class PrestamoFinancieroService extends GenericService<Prestamofinanciero, Integer> {

    @Autowired
    private PrestamoFinancieroDao prestamoFinancieroDao;

    @Override
    public GenericDao<Prestamofinanciero, Integer> getDao() {
        return prestamoFinancieroDao;
    }

    public List<Prestamofinanciero> findPrestamosfinancierosBySolicitud(Integer idSolicitud) {
        return prestamoFinancieroDao.findPrestamosFinancierosBySolicitud(idSolicitud);
    }

}
