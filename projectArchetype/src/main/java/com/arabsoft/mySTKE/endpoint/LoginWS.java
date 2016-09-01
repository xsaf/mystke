package com.arabsoft.mySTKE.endpoint;

import java.io.StringWriter;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.arabsoft.mySTKE.business.LoginBusiness;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@WebService(targetNamespace = "http://loginws/")
@SOAPBinding(style = Style.RPC)
public class LoginWS extends SpringBeanAutowiringSupport {

	private Utilisateur utilisateur = new Utilisateur();
	private UtilisateurWS utilisateurWS = new UtilisateurWS();

	private String username;
	private String password;

	@Autowired
	@Qualifier(value = "loginBusiness")
	LoginBusiness loginBusiness;

	public LoginWS() {
		super();
	}

	@WebMethod(operationName = "getLogin")
	public String getLogin(@WebParam(name = "name") String name, @WebParam(name = "pass") String pass) {
		username = name;
		password = pass;
		utilisateur = loginBusiness.findUser(username, password);

		utilisateurWS.setNumMatrUser(utilisateur.getNumMatrUser());
		utilisateurWS.setNomUti(utilisateur.getNomUti());
		utilisateurWS.setPrenomUti(utilisateur.getPrenomUti());
		
		// String[] s = new String[3];
		// s[0] = utilisateur.getNumMatrUser();
		// s[1] = utilisateur.getNomUti();
		// s[2] = utilisateur.getPrenomUti();
		//
		// StringWriter sw = new StringWriter();
		// JAXB.marshal(s, sw);
		// String xmlString = sw.toString();

		String xmlString = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(UtilisateurWS.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
			JAXB.marshal(utilisateurWS, sw);
			xmlString = sw.toString();

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return xmlString;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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
