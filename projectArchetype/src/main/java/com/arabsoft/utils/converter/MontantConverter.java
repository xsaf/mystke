package com.arabsoft.utils.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class MontantConverter implements Serializable, Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Long valuee = (Long) value;
		String[] values = valuee.toString().split(" ");
		String montantFormatte = "";

		if (values != null && values.length != 0) {
			String montant = values[0];
			if (montant != null && montant.length() != 0) {
			//	montantFormatte = StrHandler.formatmnt(Long.valueOf(montant));
			}
		}

		return montantFormatte;
	}

}
