package com.siapa.service;

import com.siapa.dao.SsRolesDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.SsRoles;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsRolesService extends GenericService<SsRoles, Integer> {

    @Autowired
    private SsRolesDao ssRolesDao;

    @Override
    public GenericDao<SsRoles, Integer> getDao() {
        return ssRolesDao;
    }

    public List<SsRoles> findByUrl(String url) {
        return ssRolesDao.findByUrl(url);
    }

}
