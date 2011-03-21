/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinblog.controlers;

import com.supinblog.services.entities.UserAccount;
import com.supinblog.services.services.BlogServiceLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author popi
 */
@ManagedBean
@Named(value="identityControler")
@SessionScoped
public class identityControler implements Serializable{
    private String name;         // name used to auth
    private String password;     // password used to auth
    private UserAccount user;    // curent User if auth.
    private UserAccount newUser; // tmp User used to register.
    
    public String resetUser(){
        this.user=null;
        return "index";
    }

    
    @EJB
    private BlogServiceLocal serv;// link to entities service.
    
    public String auth(){
        user= serv.getAuthenticatedUser(name, password);
        return user==null?"login":"index";
    }
    public String addUser(){
        serv.addUser(this.newUser);
        return "login";
    }
    /** Creates a new instance of identityControler */
    public identityControler() {
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated, getters, setters">
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public UserAccount getNewUser() {
        if(this.newUser==null)
            this.newUser = new UserAccount();
        return newUser;
    }

    public void setNewUser(UserAccount newUser) {
        if(this.newUser==null)
            this.newUser = new UserAccount();
        this.newUser = newUser;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public UserAccount getUser() {
        return user;
    }
    // </editor-fold>


}
