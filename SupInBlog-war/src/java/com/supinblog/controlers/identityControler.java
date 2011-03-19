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
    private String name;
    private String password;
    private UserAccount user;
    
    @EJB
    private BlogServiceLocal serv;
    
    public String auth(){
        user= serv.getAuthenticatedUser(name, password);
        return user==null?"login":"index";
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
