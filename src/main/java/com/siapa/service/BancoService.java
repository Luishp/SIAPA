package com.siapa.service;

import com.siapa.dao.BancoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Banco;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service(value = "bancoService")
public class BancoService extends GenericService<Banco, Integer> {

    @Autowired
    private BancoDao bancoDao;

    @Override
    public GenericDao<Banco, Integer> getDao() {
        return bancoDao;
    }

    public List<Banco> findAllActives() {
        return bancoDao.findAllActives();
    }

}
