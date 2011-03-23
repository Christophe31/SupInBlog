/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinblog.filters;

import com.supinblog.controlers.BlogControler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author popi
 */
public class AccessFilter implements Filter {
    private FilterConfig filterConfig;

    private List<String> publicPaths;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        publicPaths = new ArrayList<String>();
        publicPaths.add("login.xhtml");
        publicPaths.add("index.xhtml");
        publicPaths.add("register.xhtml");
        publicPaths.add("blog.xhtml");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        BlogControler blogControler = (BlogControler) httpRequest.getSession().getAttribute("blogControler");
        if ((! publicPaths.contains(httpRequest.getServletPath())) && (blogControler == null || blogControler.getUser() == null)){
            httpResponse.sendRedirect("login.xhtml");
        } else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }


}
