/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinblog.converters;

import com.supinblog.services.entities.Tag;
import com.supinblog.services.services.BlogServiceLocal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author popi
 */
@FacesConverter(value="TagConverter")
@ManagedBean
@Named(value="noneItsATest")
@SessionScoped
public class TagConverter implements Converter {

    public TagConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BlogServiceLocal b = ((BlogServiceLocal) context.getApplication()
                    .evaluateExpressionGet(FacesContext.getCurrentInstance(), 
                                            "#{blogControler.serv}", BlogServiceLocal.class));
        return value == null || "".equals(value) ? 
                null: b.getTag(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Tag)value).getId().toString();
    }
    

}
