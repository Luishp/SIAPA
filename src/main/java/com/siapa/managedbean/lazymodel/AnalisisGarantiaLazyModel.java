package com.siapa.managedbean.lazymodel;

import com.siapa.dao.RegistrarGarantiasDao;
import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Analisis;
import com.siapa.model.Garantiaasignadaasesoria;
import com.siapa.service.RegistrarGarantiasService;
import com.siapa.service.generic.GenericService;
import com.siapa.utils.PagedResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
public class AnalisisGarantiaLazyModel extends GenericLazyModel<Analisis, Integer> {

   


    public AnalisisGarantiaLazyModel(GenericService<Analisis, Integer> service) {
        super(service);
    }

    @Override
    public Analisis getRowData(String rowKey) {
        for (Analisis analisis : getDatasource()) {
            if (analisis.getAnalisisId().equals(Integer.valueOf(rowKey))) {
                return analisis;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Analisis element) {
        return element.getAnalisisId();
    }

    @Override
    public List<Analisis> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        List<Analisis> ret = new ArrayList<Analisis>();
        List<Map<String, Object>> criterions = new ArrayList<Map<String, Object>>();
        Map<String, Object> filtersI = new HashMap<String, Object>();

        filtersI.put("analisisCompleto", false);
        criterions.add(filtersI);
        if (super.getService() != null) {
            PagedResult page = super.getService().getPage((first / pageSize) + 1, pageSize, "analisisId", "desc", criterions);
            ret = page.getList();
            setRowCount(page.getCounter());
        }
        
//            RegistrarGarantiasDao   registrarGarantiasService=new RegistrarGarantiasDao();
//
//        for (Analisis an : ret) {
//            
//            
//           Set<Garantiaasignadaasesoria> requeridas= registrarGarantiasService.findGarantiasExigidasByAnalisis(an.getAnalisisId());
//            
//           
//            for (Garantiaasignadaasesoria ga : requeridas) {
//
//                switch (ga.getGarantia().getGarantiaId().intValue()) {
//                    case 1:
//                        an.setgRealReq(ga.getGaasCantidad());
//                        break;
//                    case 2:
//                        an.setgHipotecariaReq(ga.getGaasCantidad());
//                        break;
//                    case 3:
//                        an.setgPrendariaReq(ga.getGaasCantidad());
//                        break;
//                    case 4:
//                        an.setgCodeudorReq(ga.getGaasCantidad());
//                        break;
//                    default:
//                        break;
//                }
//                  
//            }
//            
//            
//            Analisis analisisRegistradas=registrarGarantiasService.findallGarantiasByAnalisis(an.getAnalisisId());
//            
//            an.setgRealReg(analisisRegistradas.getRegistrogarantiarealList().size());
//            an.setgCodeudorReg(analisisRegistradas.getRegistrogarantiacodeudorList().size());
//            an.setgHipotecariaReg(analisisRegistradas.getRegistrogarantiahipotecariaList().size());
//            an.setgPrendariaReg(analisisRegistradas.getRegistrogarantiaprendariaList().size());
//            
//            
//        }

        return ret;
    }

}
