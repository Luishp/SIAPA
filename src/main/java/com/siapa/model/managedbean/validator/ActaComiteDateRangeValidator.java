/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model.managedbean.validator;

import com.siapa.model.managedbean.crud.util.JsfUtil;
import java.util.Date;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author monte
 */
@FacesValidator("actaComiteDateRangeValidator")
public class ActaComiteDateRangeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        if (value == null) {
            return; // Let required="true" handle.
        }

        UIInput startDateComponent = (UIInput) component.getAttributes().get("actaComiteStartDateComponent");

        if (!startDateComponent.isValid()) {
            return; // Already invalidated. Don't care about it then.
        }

        Date startDate = (Date) startDateComponent.getValue();

        if (startDate == null) {
            return; // Let required="true" handle.
        }

        Date endDate = (Date) value;

        if (startDate.after(endDate)) {
            startDateComponent.setValid(false);
            JsfUtil.addErrorMessage("La fecha inicial debe ser menor a la final.");
            throw new ValidatorException(new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "La fecha inicial debe ser menor a la final.", null));
            
        }

    }

}
