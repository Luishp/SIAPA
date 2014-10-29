package com.siapa.service;

import com.siapa.dao.ResolucionDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Resolucion;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "resolucionService")
public class ResolucionService extends GenericService<Resolucion, Integer> {

    @Autowired
    private ResolucionDao resolucionDao;

    @Override
    public GenericDao<Resolucion, Integer> getDao() {
        return resolucionDao;
    }

    public Resolucion findResolucion(Resolucion resolucion) {
        return resolucionDao.findResolucion(resolucion);
    }

    public List<Resolucion> buscarParaEditar(Integer nivelResolucion) {
        return resolucionDao.buscarParaEditar(nivelResolucion);
    }

    public Resolucion fillResolucion(Resolucion resolucion) {
        return resolucionDao.fillResolucion(resolucion);
    }

}
