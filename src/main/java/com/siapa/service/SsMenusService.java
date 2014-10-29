package com.siapa.service;

import com.siapa.dao.SsMenusDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.SsMenus;
import com.siapa.model.SsRoles;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ssMenuService")
public class SsMenusService extends GenericService<SsMenus, Integer> {

    @Autowired
    private SsMenusDao ssMenusDao;

    @Override
    public GenericDao<SsMenus, Integer> getDao() {
        return ssMenusDao;
    }

    public List<SsMenus> getMenusByrol(SsRoles rol) {
        return this.ssMenusDao.getMenusByrol(rol);
    }
}
