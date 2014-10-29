package com.siapa.service;

import com.siapa.dao.NivelResolucionDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Nivelresolucion;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service(value = "nivelResolucionService")
public class NivelResolucionService extends GenericService<Nivelresolucion, Integer> {

    @Autowired
    private NivelResolucionDao nivelResolucionDao;

    @Override
    public GenericDao<Nivelresolucion, Integer> getDao() {
        return nivelResolucionDao;
    }

    public List<Nivelresolucion> findAllActives() {
        return nivelResolucionDao.findAllActives();
    }

}
