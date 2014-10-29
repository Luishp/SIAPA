/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Solicitud;
import com.siapa.service.generic.GenericService;
import com.siapa.utils.PagedResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
public class SolicitudLazyModel extends GenericLazyModel<Solicitud, Integer> {

    public SolicitudLazyModel(GenericService<Solicitud, Integer> service) {
        super(service);
    }

    @Override
    public Solicitud getRowData(String rowKey) {
           for (Solicitud solicitud : getDatasource()) {
            if (solicitud.getSolicitudId().equals(Integer.valueOf(rowKey))) {
                return solicitud;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Solicitud element) {
       return element.getSolicitudId();
    }
    
    @Override
    public List<Solicitud> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        List<Solicitud> ret = new ArrayList<Solicitud>();
        List<Map<String, Object>> criterions = new ArrayList<Map<String, Object>>();
        Map<String, Object> filtersI=new HashMap<String, Object>();
                     
        filtersI.put("solicitudCompleta", false);
        
       
        criterions.add(filtersI);
        if (super.getService() != null) {
            PagedResult page = super.getService().getPage((first / pageSize) + 1, pageSize, "solicitudId", "desc", criterions);
            ret = page.getList();
            setRowCount(page.getCounter());
        }
        return ret;
    }
    
    
}
