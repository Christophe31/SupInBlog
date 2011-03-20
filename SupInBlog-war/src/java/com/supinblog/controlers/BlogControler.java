/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinblog.controlers;

import com.supinblog.services.entities.Post;
import com.supinblog.services.services.BlogServiceLocal;
import java.util.List;
import javax.ejb.EJB;
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
    @EJB
    private BlogServiceLocal serv;

    public List<Post> getAllPosts() {
        return serv.getPosts();
    }
    
    /** Creates a new instance of BlogControler */
    public BlogControler() {
    }
    

}
