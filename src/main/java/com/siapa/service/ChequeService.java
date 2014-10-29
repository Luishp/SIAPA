/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.ChequeDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Cheque;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JosueRogelio
 */
@Service(value = "chequeService")
public class ChequeService extends GenericService<Cheque, Integer> {

    @Autowired
    private ChequeDao chequeDao;

    @Override
    public GenericDao<Cheque, Integer> getDao() {
        return chequeDao;
    }

    public List<Cheque> findChequesByDesembolso(Integer id) {
        return chequeDao.findChequesByDesembolso(id);
    }
}
