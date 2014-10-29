package com.siapa.service;

import com.siapa.dao.CuentacontableDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Cuentacontable;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CuentacontableService extends GenericService<Cuentacontable, String> {

    @Autowired
    private CuentacontableDao cuentacontableDao;

    @Override
    public GenericDao<Cuentacontable, String> getDao() {
        return cuentacontableDao;
    }

    public List<Cuentacontable> findAllActives() {
        return cuentacontableDao.findAllActives();
    }

}
