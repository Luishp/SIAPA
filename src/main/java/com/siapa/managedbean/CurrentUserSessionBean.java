package com.siapa.managedbean;

import com.siapa.managedbean.form.CurrentUserSessionForm;
import com.siapa.model.SsMenus;
import com.siapa.model.SsOpciones;
import com.siapa.model.SsRoles;
import com.siapa.security.AppUserDetails;
import com.siapa.service.SsMenusService;
import com.siapa.service.SsOpcionesService;
import com.siapa.utils.MenuList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;

@Named("currentUserSessionBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class CurrentUserSessionBean {

    private final static Log log = LogFactory.getLog(CurrentUserSessionBean.class);

    @Autowired
    private SsOpcionesService ssOpcionesService;
    @Autowired
    private SsMenusService ssMenusService;

    private CurrentUserSessionForm currentUserSessionForm;

    public CurrentUserSessionBean() {
    }

    public AppUserDetails getSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (getForm().getSessionUser() == null) {
            try {
                getForm().setSessionUser((AppUserDetails) authentication.getPrincipal());
            } catch (Exception e) {
                log.error("Could not retrieve session user. ", e);
            }
        }
        return getForm().getSessionUser();
    }

    private List<SsOpciones> obtenerMenuOpcion(SsRoles rol, SsMenus menu) {
        List<SsOpciones> opt = this.ssOpcionesService.getOpcionesByMenuRol(rol, menu);
        getForm().getOptions().addAll(opt);
        return opt;

    }

    public void calculateMenu() {
        if (getForm().getOptions() == null || getForm().getOptions().isEmpty()) {
            AppUserDetails usuario = getSessionUser();
            if (usuario != null && usuario.getUsuario() != null) {
                getForm().setMenusLst(new ArrayList<MenuList>());
                for (SsRoles rol : usuario.getUsuario().getSsRolesList()) {
                    List<SsMenus> mns = ssMenusService.getMenusByrol(rol);
                    getForm().setMenusLst(MenuList.GenerarMenu(mns));
                    for (MenuList menu : getForm().getMenusLst()) {
                        List<SsOpciones> opcionesMenu = obtenerMenuOpcion(rol, menu.getSsMenu());
                        menu.setSsOpciones(opcionesMenu);
                        for (MenuList subMenu : menu.getSubMenu()) {
                            List<SsOpciones> opcionesSubMenu = obtenerMenuOpcion(rol, subMenu.getSsMenu());
                            subMenu.setSsOpciones(opcionesSubMenu);
                        }
                    }
                }
            }
        }
//        return getForm().getOptions();
    }

    public CurrentUserSessionForm getForm() {
        if (currentUserSessionForm == null) {
            currentUserSessionForm = new CurrentUserSessionForm();
        }
        return currentUserSessionForm;
    }

}