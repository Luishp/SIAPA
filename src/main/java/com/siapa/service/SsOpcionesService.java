package com.siapa.service;

import com.siapa.dao.SsOpcionesDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.SsMenus;
import com.siapa.model.SsOpciones;
import com.siapa.model.SsRoles;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ssOpcionesService")
public class SsOpcionesService extends GenericService<SsOpciones, Integer> {

    @Autowired
    private SsOpcionesDao ssOpcionesDao;

    @Override
    public GenericDao<SsOpciones, Integer> getDao() {
        return ssOpcionesDao;
    }

    public List<SsOpciones> getOpcionesByMenuRol(SsRoles rol, SsMenus menu) {
        return this.ssOpcionesDao.getOpcionesByMenuRol(menu, rol);
    }

}
