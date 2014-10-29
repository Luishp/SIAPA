package com.siapa.model.managedbean.crud.converter;

import com.siapa.model.Nivelresolucion;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.NivelResolucionService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Component(value = "nivelResolucionConverter")
public class NivelResolucionConverter implements Converter {

    @Autowired
    private NivelResolucionService nivelResolucionService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.nivelResolucionService.findById(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Nivelresolucion) {
            Nivelresolucion o = (Nivelresolucion) object;
            return getStringKey(o.getNrId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Nivelresolucion.class.getName()});
            return null;
        }
    }

}
