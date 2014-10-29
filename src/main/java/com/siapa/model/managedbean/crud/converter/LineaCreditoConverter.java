/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model.managedbean.crud.converter;

import com.siapa.model.Lineacredito;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.LineaCreditoService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 *
 * @author Josue
 */
@Component(value = "lineacreditoConverter")
public class LineaCreditoConverter implements Converter{
    
    @Autowired
    private LineaCreditoService lineaCreditoService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
      Lineacredito lc= this.lineaCreditoService.findById(getKey(value));
        
        return lc;
        
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
        if (object instanceof Lineacredito) {
            Lineacredito o = (Lineacredito) object;
            return getStringKey(o.getLineacreditoId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Lineacredito.class.getName()});
            return null;
        }
    }
}
