package com.siapa.model.managedbean.crud.converter;

import com.siapa.model.Garantia;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.GarantiaService;
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
@Component(value = "garantiaConverter")
public class GarantiaConverter implements Converter{

    @Autowired
    private GarantiaService garantiaService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        Garantia ga=this.garantiaService.findById(getKey(value));
         
        return this.garantiaService.findById(getKey(value));
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
        if (object instanceof Garantia) {
            Garantia o = (Garantia) object;
            return getStringKey(o.getGarantiaId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Garantia.class.getName()});
            return null;
        }
    }

}
