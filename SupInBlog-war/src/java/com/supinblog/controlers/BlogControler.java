/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinblog.controlers;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author popi
 */
@ManagedBean
@Named(value="blogControler")
@Dependent
public class BlogControler {
    /** Creates a new instance of BlogControler */
    public BlogControler() {
    }

}
