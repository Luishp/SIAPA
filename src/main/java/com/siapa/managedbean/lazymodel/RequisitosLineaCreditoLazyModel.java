/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Asesoria;
import com.siapa.model.Requisitolineacreditoempleado;
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
public class RequisitosLineaCreditoLazyModel extends GenericLazyModel<Requisitolineacreditoempleado, Integer>{

    public RequisitosLineaCreditoLazyModel(GenericService<Requisitolineacreditoempleado, Integer> service) {
        super(service);
    }

    @Override
    public Requisitolineacreditoempleado getRowData(String rowKey) {
      for (Requisitolineacreditoempleado requisito : getDatasource()) {
            if (requisito.getRequisitolineacreditoempleadoId().equals(Integer.valueOf(rowKey))) {
                return requisito;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Requisitolineacreditoempleado element) {
         return element.getRequisitolineacreditoempleadoId();
    }
    
    @Override
    public List<Requisitolineacreditoempleado> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        List<Requisitolineacreditoempleado> ret = new ArrayList<Requisitolineacreditoempleado>();
        List<Map<String, Object>> criterions = new ArrayList<Map<String, Object>>();
        Map<String, Object> filtersI=new HashMap<String, Object>();
        

        if (filters.containsKey("requisitolineacreditoempleadoId")) {
            filtersI.put("requisitolineacreditoempleadoId", Integer.valueOf(filters.get("requisitolineacreditoempleadoId")));
        }
  
        criterions.add(filtersI);
        if (super.getService() != null) {
            PagedResult page = super.getService().getPage((first / pageSize) + 1, pageSize, "requisitolineacreditoempleadoId", "desc", criterions);
            ret = page.getList();
            setRowCount(page.getCounter());
        }
        return ret;
    }
    
    
    
    
    
}
