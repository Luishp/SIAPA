package com.siapa.service;

import com.siapa.dao.RegistrarGarantiasDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Analisis;
import com.siapa.model.Garantiaasignadaasesoria;
import com.siapa.service.generic.GenericService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "registrarGarantiasService")
public class RegistrarGarantiasService extends GenericService<Analisis, Integer> {

    @Autowired
    private RegistrarGarantiasDao registrarGarantiasDao;

    @Override
    public GenericDao<Analisis, Integer> getDao() {
        return registrarGarantiasDao;
    }

    public List<Analisis> findListWithGarantias() {

        List<Analisis> ret=findAll();

        for (Analisis an : ret) {
            
            
           Set<Garantiaasignadaasesoria> requeridas= obtenerGarantiasAsociadas(an.getAnalisisId());
            
           
            for (Garantiaasignadaasesoria ga : requeridas) {

                switch (ga.getGarantia().getGarantiaId().intValue()) {
                    case 1:
                        an.setgRealReq(ga.getGaasCantidad());
                        break;
                    case 2:
                        an.setgHipotecariaReq(ga.getGaasCantidad());
                        break;
                    case 3:
                        an.setgPrendariaReq(ga.getGaasCantidad());
                        break;
                    case 4:
                        an.setgCodeudorReq(ga.getGaasCantidad());
                        break;
                    default:
                        break;
                }
                  
            }
            
            
            Analisis analisisRegistradas=obtenerGarantiasAsignadasAnalisis(an.getAnalisisId());
            
            an.setgRealReg(analisisRegistradas.getRegistrogarantiarealList().size());
            an.setgCodeudorReg(analisisRegistradas.getRegistrogarantiacodeudorList().size());
            an.setgHipotecariaReg(analisisRegistradas.getRegistrogarantiahipotecariaList().size());
            an.setgPrendariaReg(analisisRegistradas.getRegistrogarantiaprendariaList().size());
            
            
        }
        
        
        
        
        return null;
    }

    /**
     * Metodo para obtener las garantias asignadas
     *
     * @param analisisId
     * @return
     */
    public Set<Garantiaasignadaasesoria> obtenerGarantiasAsociadas(Integer analisisId) {

        Analisis an = registrarGarantiasDao.findGarantiasExigidasByAnalisis(analisisId);
        Set<Garantiaasignadaasesoria> garantias = an.getSolicitudId().getAsesoriaId().getGarantiaasignadaasesoriaList();

        return garantias;
    }

    public Analisis obtenerGarantiasAsignadasAnalisis(Integer analisisId) {
        return registrarGarantiasDao.findallGarantiasByAnalisis(analisisId);
    }

}
