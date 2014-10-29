package com.siapa.model.managedbean.crud.converter;

import com.siapa.model.Cuentacontable;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.CuentacontableService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cuentacontableConverter")
public class CuentacontableConverter implements Converter {

    @Autowired
    private CuentacontableService cuentacontableService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.cuentacontableService.findById(getKey(value));
    }

    java.lang.String getKey(String value) {
        java.lang.String key;
        key = value;
        return key;
    }

    String getStringKey(java.lang.String value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Cuentacontable) {
            Cuentacontable o = (Cuentacontable) object;
            return getStringKey(o.getCcId2());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cuentacontable.class.getName()});
            return null;
        }
    }
}
