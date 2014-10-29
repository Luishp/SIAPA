package com.siapa.service;

import com.siapa.dao.GarantiaCodeudorDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Registrogarantiacodeudor;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JosueRogelio
 */
@Service(value = "garantiaCodeudorService")
public class GarantiaCodeudorService extends GenericService<Registrogarantiacodeudor, Integer> {

    @Autowired
    private GarantiaCodeudorDao garantiaCodeudorDao;

    @Override
    public GenericDao<Registrogarantiacodeudor, Integer> getDao() {
       return  garantiaCodeudorDao;
    }

    public List<Registrogarantiacodeudor> findByAnalisisId(Integer idAnalisis) {
        return garantiaCodeudorDao.findByAnalisisId(idAnalisis);
    }
}
