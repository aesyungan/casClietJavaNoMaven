/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayungan.bean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.jasig.cas.client.authentication.AttributePrincipal;

/**
 *
 * @author Alex
 */
@ManagedBean
@ViewScoped
public class indexController {

    String nameUser = "";

    public indexController() {
        System.out.println("Hola");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        nameUser = "";
        nameUser += request.getRemoteUser();
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void logOut() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.invalidate();
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        //close session en cas server
        externalContext.redirect("https://ayungan.me:8443/cas/logout");
    }

}
