package com.inquira.pmeditor.util;

import com.inquira.processmodel.util.StringUtil;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.RichPopup.PopupHints;
import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public final class AdfUtil
{
  public static Locale getLocale()
  {
    return FacesContext.getCurrentInstance().getViewRoot().getLocale();
  }

  public static boolean isCurrentLanguage(String language)
  {
    return getLocale().getLanguage().equals(new Locale(language).getLanguage());
  }

  public static void redirect(String url) {
    try {
      getExternalContext().redirect(url);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void javascriptRedirect(String url) {
    addScript("redirect(" + StringUtil.toJson(url) + ");");
  }

  public static void addScript(String script) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ((ExtendedRenderKitService)Service.getRenderKitService(facesContext, ExtendedRenderKitService.class)).addScript(facesContext, script);
  }

  public static void addMessage(UIComponent component, FacesMessage message) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    facesContext.addMessage(component.getClientId(facesContext), message);
  }

  public static void addPartialTarget(UIComponent component) {
    RequestContext.getCurrentInstance().addPartialTarget(component);
  }

  public static String getRequestParameter(String name) {
	  //Added by Deevanshu
	  System.out.println("Parameter Map =="+(String)getExternalContext().getRequestParameterMap().get(name));
    //Ends
	  return (String)getExternalContext().getRequestParameterMap().get(name);
  }
  public static boolean requestParameterExists(String name) {
    return getExternalContext().getRequestParameterMap().containsKey(name);
  }
  public static String[] getRequestParameterValues(String name) {
    return (String[])getExternalContext().getRequestParameterValuesMap().get(name);
  }

  public static ExternalContext getExternalContext() {
	  //Added by Deevanshu
	  System.out.println("External Context =="+FacesContext.getCurrentInstance().getExternalContext());
	  System.out.println("Remote User"+FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
	  //Ends
    return FacesContext.getCurrentInstance().getExternalContext();
  }

  public static void fullRefresh()
  {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    String refreshPage = facesContext.getViewRoot().getViewId();
    ViewHandler viewHandler = facesContext.getApplication().getViewHandler();
    UIViewRoot viewRoot = viewHandler.createView(facesContext, refreshPage);
    facesContext.setViewRoot(viewRoot);
  }

  public static void showPopup(RichPopup popup, RichPopup.PopupHints hints) {
    RequestContext.getCurrentInstance().addPartialTarget(popup);
    if (null != hints)
      popup.show(hints);
    else
      popup.show(new RichPopup.PopupHints());
  }

  public static void sendRedirect(String jspxPage)
  {
    FacesContext context = FacesContext.getCurrentInstance();
    UIViewRoot newPage = context.getApplication().getViewHandler().createView(context, "/" + jspxPage);
    context.setViewRoot(newPage);
    context.renderResponse();
  }

  public static String getViewId()
  {
    return FacesContext.getCurrentInstance().getViewRoot().getViewId();
  }
}