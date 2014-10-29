package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Agendacomitecreditos;
import com.siapa.model.Analisisenagendacomitecreditos;
import com.siapa.model.AnalisisenagendacomitecreditosPK;
import com.siapa.service.generic.GenericService;
import com.siapa.utils.PagedResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.model.SortOrder;

public class AnalisisEnAgendaComiteCreditosLazyModel extends GenericLazyModel<Analisisenagendacomitecreditos, AnalisisenagendacomitecreditosPK> {

    public AnalisisEnAgendaComiteCreditosLazyModel(GenericService<Analisisenagendacomitecreditos, AnalisisenagendacomitecreditosPK> service) {
        super(service);
    }

    @Override
    public Analisisenagendacomitecreditos getRowData(String rowKey) {
        for (Analisisenagendacomitecreditos analisisenagendacomitecreditos : getDatasource()) {
            if (analisisenagendacomitecreditos.getAnalisisenagendacomitecreditosPK().equals(rowKey)) {
                return analisisenagendacomitecreditos;
            }
        }
        return null;
    }

    @Override
    public AnalisisenagendacomitecreditosPK getRowKey(Analisisenagendacomitecreditos element) {
        return element.getAnalisisenagendacomitecreditosPK();
    }

    @Override
    public List<Analisisenagendacomitecreditos> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        List<Analisisenagendacomitecreditos> ret = new ArrayList<Analisisenagendacomitecreditos>();
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
