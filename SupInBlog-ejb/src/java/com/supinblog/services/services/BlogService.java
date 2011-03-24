/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinblog.services.services;

import com.supinblog.services.entities.Comment;
import com.supinblog.services.entities.Post;
import com.supinblog.services.entities.Tag;
import com.supinblog.services.entities.UserAccount;
import java.util.Date;
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
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addUser(UserAccount newUser) {
        entities.persist(newUser);
    }

    @Override
    public void addTag(Tag newTag) {
        entities.persist(newTag);
    }

    @Override
    public void addPost(Post newPost) {
        Date now = new Date();
        newPost.setCreationDate(now);
        newPost.setModificationDate(now);
        entities.persist(newPost);
    }
    
    @Override
    public List<Post> getPosts() {
        return (List<Post>)entities.createNamedQuery("Post.all").getResultList();
    }

    @Override
    public List<Tag> getTags() {
        return (List<Tag>)entities.createNamedQuery("Tag.all").getResultList();
    }

    @Override
    public void updatePost(Post post) {
        entities.merge(post);
    }
    @Override
    public void updateTag(Tag tag) {
        entities.merge(tag);
    }

    @Override
    public Tag getTag(String name) {
        return (Tag) entities.createNamedQuery("Tag.withName").setParameter("name", name).getSingleResult();
    }

    @Override
    public Tag getTag(long id) {
        try{
            return (Tag) entities.createNamedQuery("Tag.withId").setParameter("id", id).getSingleResult();
        }catch(NoResultException e) {
            return null;}
    }

    @Override
    public Post getPost(long id) {
        return (Post) entities.find(Post.class, id);
    }

    @Override
    public void addComment(Comment newComment) {
        Date now = new Date();
        newComment.setCreationDate(now);
        newComment.setModificationDate(now);
        entities.persist(newComment);
    }

    @Override
    public void updateComment(Comment comment) {
        entities.merge(comment);
    }
}