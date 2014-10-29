package com.siapa.service;

import com.siapa.dao.SsUsuariosDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.SsUsuarios;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ssUsuariosService")
public class SsUsuariosService extends GenericService<SsUsuarios, Integer> {

    @Autowired
    private SsUsuariosDao ssUsuariosDao;

    @Override
    public GenericDao<SsUsuarios, Integer> getDao() {
        return ssUsuariosDao;
    }

    public SsUsuarios checkLogin(String user, String password) {
        return this.ssUsuariosDao.checkLogin(user, password);
    }
}
