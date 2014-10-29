/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Propiedad;
import com.siapa.service.generic.GenericService;
import java.util.List;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
public class PropiedadLazyModel extends GenericLazyModel<Propiedad, Integer>{

    public PropiedadLazyModel(List<Propiedad> propiedades,GenericService<Propiedad, Integer> service) {
        super(propiedades,service);
    }

    @Override
    public Propiedad getRowData(String rowKey) {
      for (Propiedad propiedad : getDatasource()) {
            if (propiedad.getPropiedadId().equals(Integer.valueOf(rowKey))) {
                return propiedad;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Propiedad element) {
         return element.getPropiedadId();
    }
    
}
