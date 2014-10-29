/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.AsistenteDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Asistente;
import com.siapa.model.AsistentePK;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author monte
 */
@Service(value = "asistenteService")
public class AsistenteService extends GenericService<Asistente, AsistentePK> {

    @Autowired
    private AsistenteDao asistenteDao;

    @Override
    public GenericDao<Asistente, AsistentePK> getDao() {
        return asistenteDao;
    }

    public List<Asistente> findByAccId(Integer accId) {
        return asistenteDao.findByAccId(accId);
    }

}
