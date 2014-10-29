/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Analisis;
import com.siapa.service.generic.GenericService;
import com.siapa.utils.PagedResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.model.SortOrder;

/**
 *
 * @author JosueRogelio
 */
public class AnalisisLazyModel  extends GenericLazyModel<Analisis, Integer>{

    public AnalisisLazyModel(GenericService<Analisis, Integer> service) {
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
        Map<String, Object> filtersI=new HashMap<String, Object>();
                     
        filtersI.put("analisisCompleto", false);
        
       
        criterions.add(filtersI);
        if (super.getService() != null) {
            PagedResult page = super.getService().getPage((first / pageSize) + 1, pageSize, "analisisId", "desc", criterions);
            ret = page.getList();
            setRowCount(page.getCounter());
        }
        return ret;
    }
    
   
}
