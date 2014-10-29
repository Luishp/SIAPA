/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.PagaduriaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Pagaduria;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue
 */
@Service(value = "pagaduriaService")
public class PagaduriaService extends GenericService<Pagaduria, Integer> {

    @Autowired
    private PagaduriaDao pagaduriaDao;

    @Override
    public GenericDao<Pagaduria, Integer> getDao() {
        return pagaduriaDao;
    }

    public List<Pagaduria> findAllActives() {
        return pagaduriaDao.findAllActives();
    }
}
