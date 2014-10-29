package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Asesoria;
import com.siapa.service.generic.GenericService;
import com.siapa.utils.PagedResult;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
public class AsesoriaLazyModel extends GenericLazyModel<Asesoria, Integer> {

    public AsesoriaLazyModel(GenericService<Asesoria, Integer> service) {
        super(service);
    }

    @Override
    public Asesoria getRowData(String rowKey) {
        for (Asesoria asesoria : getDatasource()) {
            if (asesoria.getAsesoriaId().equals(Integer.valueOf(rowKey))) {
                return asesoria;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Asesoria element) {
        return element.getAsesoriaId();
    }

    @Override
    public List<Asesoria> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        List<Asesoria> ret = new ArrayList<Asesoria>();
        List<Map<String, Object>> criterions = new ArrayList<Map<String, Object>>();
        Map<String, Object> filtersI=new HashMap<String, Object>();
        

        if (filters.containsKey("asesoriaId")) {
            filtersI.put("asesoriaId", Integer.valueOf(filters.get("asesoriaId")));
        }
        
        if (filters.containsKey("taId.taNombre")) {
            filtersI.put("taId.taNombre", filters.get("taId.taNombre"));
        }
        
        if (filters.containsKey("asesoriaPlazo")) {
            filtersI.put("asesoriaPlazo", Integer.valueOf(filters.get("asesoriaPlazo")));
        }
        
        if (filters.containsKey("asesoriaIngreso")) {
            filtersI.put("asesoriaIngreso",BigDecimal.valueOf(Double.valueOf(filters.get("asesoriaIngreso"))));
        }
        
        if (filters.containsKey("asesoriaMonto")) {
            filtersI.put("asesoriaMonto",BigDecimal.valueOf(Double.valueOf(filters.get("asesoriaMonto"))));
        }
        
        if (filters.containsKey("asesoriaTasa")) {
            filtersI.put("asesoriaTasa",BigDecimal.valueOf(Double.valueOf(filters.get("asesoriaTasa"))));
        }
       
        filtersI.put("asesoriaCompleta", false);
        criterions.add(filtersI);
        if (super.getService() != null) {
            PagedResult page = super.getService().getPage((first / pageSize) + 1, pageSize, "asesoriaId", "desc", criterions);
            ret = page.getList();
            setRowCount(page.getCounter());
        }
        return ret;
    }

}
