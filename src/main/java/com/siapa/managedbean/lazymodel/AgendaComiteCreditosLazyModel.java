package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Agendacomitecreditos;
import com.siapa.service.generic.GenericService;
import com.siapa.utils.PagedResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.model.SortOrder;

public class AgendaComiteCreditosLazyModel extends GenericLazyModel<Agendacomitecreditos, Integer> {

    public AgendaComiteCreditosLazyModel(GenericService<Agendacomitecreditos, Integer> service) {
        super(service);
    }

    @Override
    public Agendacomitecreditos getRowData(String rowKey) {
        for (Agendacomitecreditos agendacomitecreditos : getDatasource()) {
            if (agendacomitecreditos.getAccId().equals(Integer.valueOf(rowKey))) {
                return agendacomitecreditos;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Agendacomitecreditos element) {
        return element.getAccId();
    }

    @Override
    public List<Agendacomitecreditos> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        List<Agendacomitecreditos> ret = new ArrayList<Agendacomitecreditos>();
        List<Map<String, String>> criterions = new ArrayList<Map<String, String>>();
        Map<String, String> m = new HashMap<String, String>();
        m.put("activo", "SI");
        criterions.add(m);
        criterions.add(filters);
        if (super.getService() != null) {
            PagedResult page = super.getService().getPage((first / pageSize) + 1, pageSize, "accFechareunion", "desc", criterions);
            ret = page.getList();
            setRowCount(page.getCounter());
        }
        return ret;
    }

}
