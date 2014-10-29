package com.siapa.service;

import com.siapa.dao.DeudaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Deuda;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "deudaService")
public class DeudaService extends GenericService<Deuda, Integer> {

    @Autowired
    private DeudaDao deudaDao;

    @Override
    public GenericDao<Deuda, Integer> getDao() {
        return deudaDao;
    }

    /**
     * Metodo para buscar las deudas Comerciales que tiene un asociado por del
     * identificador de el Asociado
     *
     * @param idSolicitud
     * @return Listado de objetos del tipo Deuda
     */
    public List<Deuda> deudasComercialesByIdAsociado(Integer idSolicitud) {
        return deudaDao.findDeudasComercialesByIdAsociado(idSolicitud);
    }

    /**
     * Metodo para buscar las deudas de Tarjetas de Credito que tiene un
     * asociado por del identificador de el Asociado
     *
     * @param idSolicitud
     * @return Listado de objetos del tipo Deuda
     */
    public List<Deuda> deudasTarjetasByIdAsociado(Integer idSolicitud) {
        return deudaDao.findDeudasTarjetasByIdAsociado(idSolicitud);
    }

        /**
     * Metodo para buscar las deudas de Tarjetas de Credito que tiene un
     * asociado por del identificador de el Asociado
     *
     * @param idSolicitud
     * @return Listado de objetos del tipo Deuda
     */
    public List<Deuda> deudasPrestamosFinByIdSolicitud(Integer idSolicitud) {
        return deudaDao.deudasPrestamosFinByIdSolicitud(idSolicitud);
    }
    
    
    public List<Deuda> findDeudasComercialesByAnalisis(Integer idAnalisisId) {
        return deudaDao.findDeudasComercialesByAnalisis(idAnalisisId);
    }
    
     public List<Deuda> findDeudasTarjetasByAnalisis(Integer idAnalisisId) {
         return deudaDao.findDeudasTarjetasByAnalisis(idAnalisisId);
     }
     
     public List<Deuda> deudasPrestamosFinByAnalisis(Integer idAnalisisId) {
         return deudaDao.deudasPrestamosFinByAnalisis(idAnalisisId);
     }
}
