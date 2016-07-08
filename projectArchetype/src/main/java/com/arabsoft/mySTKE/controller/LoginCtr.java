package com.arabsoft.mySTKE.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.validator.ValidatorException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;

import com.arabsoft.mySTKE.business.LoginBusiness;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@ManagedBean(name = "loginCtr")
@SessionScoped
public class LoginCtr implements PhaseListener {

	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());

	private String username;
	private String password;
	@ManagedProperty(value = "#{loginBusiness}")
	LoginBusiness loginBusiness;

	/**
	 * 
	 * Redirects the login request directly to spring security check. Leave this
	 * method as it is to properly support spring security.
	 * 
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String doLogin() throws ServletException, IOException {

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		context.getSessionMap().put("messageSpring", null);
		context.getSessionMap().put("SPRING_SECURITY_LAST_EXCEPTION", null);

		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/j_spring_security_check");

		dispatcher.forward((ServletRequest) context.getRequest(),
				(ServletResponse) context.getResponse());

		FacesContext.getCurrentInstance().responseComplete();
		Utilisateur p = loginBusiness.findUser(username);

		return null;
	}

	public void afterPhase(PhaseEvent event) {

	}

	public void validateRequiredUsername(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		if (value == null || value.equals("")) {
			logger.debug("Nom utilisateur est obligatoire ");

			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Matricule utilisateur obligatoire !",
					"Matricule utilisateur obligatoire !"));
		}

	}

	public void validateRequiredPassword(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		if (value == null || value.equals("")) {
			logger.debug("Mot de passe est obligatoire ");

			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Mot de passe utilisateur obligatoire !",
					"Mot de passe utilisateur obligatoire !"));
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 * 
	 * Do something before rendering phase.
	 */
	public void beforePhase(PhaseEvent event) {
		Exception e = (Exception) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get(WebAttributes.AUTHENTICATION_EXCEPTION);

		if (e instanceof BadCredentialsException) {
			logger.debug("Found exception in session map: " + e);

			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap()
					.put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Utilisateur ou mot de passe invalid.",
							"Utilisateur ou mot de passe invalid."));

		}
		FacesContext fc = event.getFacesContext();
		String view = fc.getViewRoot().getViewId();
		logger.debug("afterPhase viewId=" + view);
		/*
		 * if (WebXml.getInstance(fc).getFacesResourceKey( (HttpServletRequest)
		 * fc.getExternalContext().getRequest()) != null) { return; }
		 */

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.event.PhaseListener#getPhaseId()
	 * 
	 * In which phase you want to interfere?
	 */
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginBusiness getLoginBusiness() {
		return loginBusiness;
	}

	public void setLoginBusiness(LoginBusiness loginBusiness) {
		this.loginBusiness = loginBusiness;
	}

}
