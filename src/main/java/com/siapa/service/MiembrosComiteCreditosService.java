/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.MiembrosComiteCreditosDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Miembroscomitecreditos;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author monte
 */
@Service(value = "miembrosComiteCreditosService")
public class MiembrosComiteCreditosService extends GenericService<Miembroscomitecreditos, Integer> {

    @Autowired
    private MiembrosComiteCreditosDao miembrosComiteCreditosDao;

    @Override
    public GenericDao<Miembroscomitecreditos, Integer> getDao() {
        return miembrosComiteCreditosDao;
    }

    public List<Miembroscomitecreditos> findAllActives() {
        return miembrosComiteCreditosDao.findAllActives();
    }

    public List<Miembroscomitecreditos> findByAccId(Integer accId) {
        return miembrosComiteCreditosDao.findByAccId(accId);
    }

}
