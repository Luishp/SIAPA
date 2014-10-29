/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.IngresoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Ingreso;
import com.siapa.model.IngresoPK;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "ingresoService")
public class IngresoService extends GenericService<Ingreso, IngresoPK> {

    @Autowired
    private IngresoDao ingresoDao;

    @Override
    public GenericDao<Ingreso, IngresoPK> getDao() {
        return ingresoDao;
    }
    
    
    public boolean guardarFuentesIngresos(List<Ingreso> ingresos) {
     
        try {
            for (Ingreso ing : ingresos) {
                IngresoPK ingPK = new IngresoPK();
                ingPK.setFiId(ing.getFuenteingreso().getFiId());
                ingPK.setSolicitudId(ing.getSolicitud().getSolicitudId());
                ing.setIngresoPK(ingPK);
                ingresoDao.save(ing);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    
    
        /**
     * Metodo para buscar Ingresos Asociados a una Solicitud de Credito
     *
     * @param idSolicitud
     * @return
     */
    public List<Ingreso> findIngresosBySolicitud(Integer idSolicitud) {
        return ingresoDao.findIngresosBySolicitud(idSolicitud);
    }

}
