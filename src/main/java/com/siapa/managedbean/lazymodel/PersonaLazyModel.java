
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Persona;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Joao
 */
public class PersonaLazyModel extends GenericLazyModel<Persona, Integer> {

    public PersonaLazyModel(GenericService<Persona, Integer> service) {
        super(service);
    }

    @Override
    public Persona getRowData(String rowKey) {
        for (Persona persona : getDatasource()) {
            if (persona.getIdPersona().equals(Integer.valueOf(rowKey)));
            return persona;
        }
        return null;
    }

    @Override
    public Integer getRowKey(Persona element) {
        return element.getIdPersona();
    }

}
