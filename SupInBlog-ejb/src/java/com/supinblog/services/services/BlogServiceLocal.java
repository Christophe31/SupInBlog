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
import javax.ejb.Local;


/**
 *
 * @author popi
 */
@Local
public interface BlogServiceLocal {
    public UserAccount getAuthenticatedUser(String name, String password);
    public List<Comment> getPostComments(long postId);
    public List<Post> getPosts();

    public void addUser(UserAccount newUser);
}
