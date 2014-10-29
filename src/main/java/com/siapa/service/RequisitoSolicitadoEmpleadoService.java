/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.RequisitoLineaCreditoEmpleadoDao;
import com.siapa.dao.RequisitoSolicitadoEmpleadoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Asesoria;
import com.siapa.model.Requisitolineacreditoempleado;
import com.siapa.model.Requisitosolicitadoempleado;
import com.siapa.model.RequisitosolicitadoempleadoPK;
import com.siapa.service.generic.GenericService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "requisitoSolicitadoEmpleadoService")
public class RequisitoSolicitadoEmpleadoService extends GenericService<Requisitosolicitadoempleado, RequisitosolicitadoempleadoPK> {

    @Autowired
    public RequisitoSolicitadoEmpleadoDao requisitoSolicitadoEmpleadoDao;

    @Autowired
    public RequisitoLineaCreditoEmpleadoDao requisitoLineaCreditoEmpleadoDao;

    @Override
    public GenericDao<Requisitosolicitadoempleado, RequisitosolicitadoempleadoPK> getDao() {
        return requisitoSolicitadoEmpleadoDao;
    }

    /**
     * Metodo para guardar los requisitos de la linea de credito solicitados a
     * un asociado
     *
     * @param asesoria
     * @param requisitosSeleccionados
     * @return
     */
    public boolean saveDocumentos(Asesoria asesoria, Requisitolineacreditoempleado[] requisitosSeleccionados) {
        try {

            for (Requisitolineacreditoempleado rei : requisitosSeleccionados) {
                Requisitosolicitadoempleado rse = new Requisitosolicitadoempleado();

                RequisitosolicitadoempleadoPK rsePk = new RequisitosolicitadoempleadoPK();
                rsePk.setAsesoriaId(asesoria.getAsesoriaId());
                rsePk.setRequisitolineacreditoempleadoId(rei.getRequisitolineacreditoempleadoId());

                rse.setRequisitosolicitadoempleadoPK(rsePk);
                rse.setAsesoria(asesoria);
                rse.setRequisitolineacreditoempleado(rei);

                requisitoSolicitadoEmpleadoDao.save(rse);

            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * Metodo para buscar los requisitos solicitados a un asociado segun la
     * linea de credito
     *
     * @param idAsesoria
     * @return
     */
    public List<Requisitosolicitadoempleado> findRequisitosByAsesoria(Integer idAsesoria) {
        return requisitoSolicitadoEmpleadoDao.findRequisitosByAsesoria(idAsesoria);
    }
    
    /**
     * Metodo para obtener los requisitos de una linea de credito relacionados
     * con la asesoria del asociado
     *
     * @param idAsesoria
     * @return
     */
    public List<Requisitolineacreditoempleado> findRequisitosLineaCreditoByAsesoria(Integer idAsesoria) {
        List<Requisitolineacreditoempleado> rlc=new ArrayList<Requisitolineacreditoempleado>();
        List<Requisitosolicitadoempleado> rse=requisitoSolicitadoEmpleadoDao.findRequisitosLineaCreditoByAsesoria(idAsesoria);

        for(Requisitosolicitadoempleado re:rse){
            rlc.add(re.getRequisitolineacreditoempleado());
        }
        return rlc;
    }
        
    /**
     * Metodo para actualizar los requisitos de la linea de credito entregados
     * por el asociado
     *
     * @param requisitos
     * @param idAsesoria
     */
    public void updateRequisitosByAsesoria(Requisitosolicitadoempleado[] requisitos,Integer idAsesoria) {

        try {
            List<Requisitosolicitadoempleado> requisitosExistentes = requisitoSolicitadoEmpleadoDao.findRequisitosByAsesoria(idAsesoria);

            for (Requisitosolicitadoempleado re : requisitosExistentes) {
                re.setRsnEntregado(false);
                requisitoSolicitadoEmpleadoDao.merge(re);

            }

            for (Requisitosolicitadoempleado rse : requisitos) {
                rse.setRsnEntregado(true);
                requisitoSolicitadoEmpleadoDao.merge(rse);
            }

        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }

}
