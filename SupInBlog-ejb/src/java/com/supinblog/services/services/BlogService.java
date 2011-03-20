/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinblog.services.services;

import com.supinblog.services.entities.Comment;
import com.supinblog.services.entities.Post;
import com.supinblog.services.entities.Tag;
import com.supinblog.services.entities.UserAccount;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author popi
 */
@Stateless
public class BlogService implements BlogServiceLocal {
    @PersistenceContext(unitName="SupInBlog-ejbPU")
    private EntityManager entities;
    
    @Override
    public UserAccount getAuthenticatedUser(String name, String password) {
        try{
            return (UserAccount) entities.createNamedQuery("UserAccount.auth")
                    .setParameter("name", name)
                    .setParameter("pwd", password)
                    .getSingleResult();
        }catch(NoResultException e) {
            return null;}
    }
    
    @Override
    public List<Comment> getPostComments(long postId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addUser(UserAccount newUser) {
        entities.persist(newUser);
    }

    @Override
    public List<Post> getPosts() {
        return (List<Post>)entities.createNamedQuery("Post.all").getResultList();
    }


 
}
