/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinblog.filters;

import com.supinblog.controlers.BlogControler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
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
        publicPaths.add("/login.xhtml");
        publicPaths.add("/index.xhtml");
        publicPaths.add("/register.xhtml");
        publicPaths.add("/blog.xhtml");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = httpRequest.getServletPath();
        // System.out.println(path);
        //FacesContext.getCurrentInstance().getApplication().getELResolver().getCommonP
        /*FacesContext context = FacesContext.getCurrentInstance();
        MethodExpression e = context.getApplication().getExpressionFactory()
            .createMethodExpression(context.getELContext(), "#{blogControler}" , BlogControler.class, new Class[0]);
        */
        /*ELContext elcontext = FacesContext.getCurrentInstance().getELContext();
        BlogControler blogControler = (BlogControler) FacesContext.getCurrentInstance()
                .getApplication().getExpressionFactory().createValueExpression(
                        elcontext, 
                        "#{blogControler}",
                        Object.class)
                .getValue(elcontext);
        */
        
        /*System.out.println(blogControler);
        
        if ((publicPaths.contains(path)) || (blogControler != null && blogControler.getUser() != null)){*/
            chain.doFilter(request, response);
        /*} else{
            httpResponse.sendRedirect("login.xhtml");
        }*/
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }


}
