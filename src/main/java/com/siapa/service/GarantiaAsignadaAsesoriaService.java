/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.GarantiaAsignadaAsesoriaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Asesoria;
import com.siapa.model.Garantia;
import com.siapa.model.Garantiaasignadaasesoria;
import com.siapa.model.GarantiaasignadaasesoriaPK;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo fuentes
 */
@Service(value = "garantiaAsignadaAsesoriaService")
public class GarantiaAsignadaAsesoriaService extends GenericService<Garantiaasignadaasesoria, GarantiaasignadaasesoriaPK> {

    @Autowired
    private GarantiaAsignadaAsesoriaDao garantiaAsignadaAsesoriaDao;

    @Override
    public GenericDao<Garantiaasignadaasesoria, GarantiaasignadaasesoriaPK> getDao() {
        return garantiaAsignadaAsesoriaDao;
    }
    

    public boolean saveGarantiasAsignadas(Asesoria asesoria, List<Garantia> garantias) {
        try {

            for (Garantia ga : garantias) {
                if (ga.getCantidad() != null) {
                    Garantiaasignadaasesoria gaa = new Garantiaasignadaasesoria();

                    GarantiaasignadaasesoriaPK gaaPk = new GarantiaasignadaasesoriaPK();

                    gaaPk.setAsesoriaId(asesoria.getAsesoriaId());
                    gaaPk.setGarantiaId(ga.getGarantiaId());

                    gaa.setGarantiaasignadaasesoriaPK(gaaPk);
                    gaa.setAsesoria(asesoria);
                    gaa.setGarantia(ga);
                    gaa.setGaasCantidad(ga.getCantidad());

                    garantiaAsignadaAsesoriaDao.save(gaa);
                }
            }
        } catch (Exception e) {
            System.out.println("Error guardando la garantias asignadas"+e);
            return false;
        }

        return true;
    }
   

}
