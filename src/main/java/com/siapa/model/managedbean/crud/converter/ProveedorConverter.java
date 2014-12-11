/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model.managedbean.crud.converter;

import com.siapa.model.Proveedor;
import com.siapa.model.TipoAlimento;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.ProveedorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import static javax.management.Query.value;
import static javax.management.Query.value;
import static javax.management.Query.value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Joao
 */
@Component(value = "proveedorConverter")
public class ProveedorConverter implements Converter {

    @Autowired
    private ProveedorService proveedorService;

//    @Override
//    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
//        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
//            return null;
//        }
//        return this.proveedorService.findById(getKey(value));
//
//    }
//
//    @Override
//    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
//        if (object == null
//                || (object instanceof String && ((String) object).length() == 0)) {
//            return null;
//        }
//        if (object instanceof Proveedor) {
//            Proveedor o = (Proveedor) object;
//            return getStringKey(o.getIdProveedor());
//        } else {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Proveedor.class.getName()});
//            return null;
//        }
//
//    }
//
//    java.lang.Integer getKey(String value) {
//        java.lang.Integer key;
//        key = Integer.valueOf(value);
//        return key;
//    }
//
//    String getStringKey(java.lang.Integer value) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(value);
//        return sb.toString();
//    }
    
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ProveedorService service = (ProveedorService) fc.getExternalContext().getApplicationMap().get("proveedorService");
                return service.getProveedor().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Proveedor) object).getId());
        }
        else {
            return null;
        }
    }  
}
