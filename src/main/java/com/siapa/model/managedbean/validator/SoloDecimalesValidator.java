/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model.managedbean.validator;

import java.math.BigDecimal;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@FacesValidator("soloDecimalesValidator")
public class SoloDecimalesValidator implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       
       
     if(value!=null){
        
        if (!(value instanceof BigDecimal)) {
         
            throw new ValidatorException(new FacesMessage(
                    FacesMessage.SEVERITY_FATAL, value.toString(), " No es un Numero Ejemplo 0.00"));
          
            }

        
        BigDecimal valor = (BigDecimal) value;

        if (valor.compareTo(BigDecimal.ZERO)==-1) {
            throw new ValidatorException(new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Debe ser mayor que 0.00", null));
        }
    }
    
    
    
    
    }



    
}
