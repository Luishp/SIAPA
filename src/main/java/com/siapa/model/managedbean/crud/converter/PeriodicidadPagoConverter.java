package com.siapa.model.managedbean.crud.converter;

import com.siapa.model.Periodicidadpago;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.PeriodicidadPagoService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "periodicidadPagoConverter")
public class PeriodicidadPagoConverter implements Converter {

    @Autowired
    private PeriodicidadPagoService periodicidadPagoService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.periodicidadPagoService.findById(getKey(value));
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
        if (object instanceof Periodicidadpago) {
            Periodicidadpago o = (Periodicidadpago) object;
            return getStringKey(o.getPpId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Periodicidadpago.class.getName()});
            return null;
        }
    }

}
