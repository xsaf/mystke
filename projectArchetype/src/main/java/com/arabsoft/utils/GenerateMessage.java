package com.arabsoft.utils;

import java.util.Iterator;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class GenerateMessage {
	public static void creatMessage(String messageName, String componentName) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle = ResourceBundle.getBundle("messages",
				facesContext.getViewRoot().getLocale());
		FacesMessage message;
		if (messageName.isEmpty()) {
			message = new FacesMessage();
		} else {
			message = new FacesMessage(bundle.getString(messageName));
			message.setSummary(bundle.getString(messageName));
			message.setDetail(bundle.getString(messageName));
		}
		UIComponent addressInput = findComponent(facesContext.getViewRoot(),
				componentName);
		if (addressInput != null)
			facesContext.addMessage(addressInput.getClientId(facesContext),
					message);
	}

	public static UIComponent findComponent(UIComponent parent, String id) {
		if (id.equals(parent.getId())) {
			return parent;
		}
		Iterator<UIComponent> kids = parent.getFacetsAndChildren();
		while (kids.hasNext()) {
			UIComponent kid = kids.next();
			UIComponent found = findComponent(kid, id);
			if (found != null) {
				return found;
			}
		}
		return null;
	}
}
