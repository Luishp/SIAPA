/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.PrestamoDao;
import com.siapa.dao.PrestamosAsociadosDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Asociados;
import com.siapa.model.Prestamo;
import com.siapa.model.PrestamosAsociados;
import com.siapa.service.generic.GenericService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "prestamoService")
public class PrestamoService extends GenericService<Prestamo, Integer> {
    
    @Autowired
    private PrestamoDao prestamoDao;
    @Autowired
    private PrestamosAsociadosDao prestamosAsociadosDao;
    
    @Override
    public GenericDao<Prestamo, Integer> getDao() {
        return prestamoDao;
    }
    
    public List<PrestamosAsociados> findPrestamosByAsociadoRc(Integer idAsociado) {
        List<PrestamosAsociados> prestamosAsociados = prestamosAsociadosDao.findPrestamosAsociados(idAsociado);
        return prestamosAsociados;
    }
    
    public List<Prestamo> findPrestamosByAsociado(Integer idAsociado) {
        List<PrestamosAsociados> prestamosAsociados = prestamosAsociadosDao.findPrestamosAsociados(idAsociado);
        List<Prestamo> prestamos = new ArrayList<Prestamo>();
        
        for (PrestamosAsociados pa : prestamosAsociados) {
            prestamos.add(pa.getPrestamo());
        }
        
        return prestamos;
    }
    
    public List<Prestamo> findPrestamosByDesembolso(Integer DesembolsoId) {
        return prestamoDao.findPrestamosByDesembolso(DesembolsoId);
    }
    
    public Prestamo fillPrestamo(Prestamo prestamo) {
        return prestamoDao.fillPrestamo(prestamo);
    }
}
