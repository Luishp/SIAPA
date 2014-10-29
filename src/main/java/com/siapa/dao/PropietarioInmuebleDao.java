/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Propietarioinmueble;
import com.siapa.model.PropietarioinmueblePK;
import com.siapa.model.Propietarioinmueble;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "propietarioInmuebleDao")
public class PropietarioInmuebleDao extends GenericDao<Propietarioinmueble, PropietarioinmueblePK> {

    public List<Propietarioinmueble> findByDlcId(Integer dlcId) {
        Query q = getSessionFactory().getCurrentSession().createQuery(" SELECT ge FROM Propietarioinmueble ge WHERE ge.registrogarantiahipotecaria.rghId = :dlcId ");
        q.setParameter("dlcId", dlcId);
        return q.list();
    }

}
