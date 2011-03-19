/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinblog.controlers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author popi
 */
@ManagedBean
@Named(value="identityControler")
@SessionScoped
public class identityControler implements Serializable{

    /** Creates a new instance of identityControler */
    public identityControler() {
    }

}
