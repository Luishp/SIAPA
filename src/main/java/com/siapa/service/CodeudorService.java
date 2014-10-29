package com.siapa.service;


import com.siapa.dao.CodeudorDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Codeudor;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "codeudorService")
public class CodeudorService extends GenericService<Codeudor, Integer> {

    @Autowired
    private CodeudorDao codeudorDao;

    @Override
    public GenericDao<Codeudor, Integer> getDao() {
        return codeudorDao;
    }
}
