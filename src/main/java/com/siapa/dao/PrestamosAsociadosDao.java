/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Prestamo;
import com.siapa.model.PrestamosAsociados;
import com.siapa.model.PrestamosAsociadosPK;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "prestamosAsociadosDao")
public class PrestamosAsociadosDao extends GenericDao<Prestamo, PrestamosAsociadosPK> {

    public List<PrestamosAsociados> findPrestamosAsociados(Integer idAsociado) {

        Query q = getSessionFactory().getCurrentSession()
                .createQuery("Select pa From PrestamosAsociados pa JOIN FETCH pa.prestamo p  WHERE  pa.prestamosAsociadosPK.idasociados = " + idAsociado);

        return q.list();
    }

}
