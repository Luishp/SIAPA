/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Requisitosolicitadoempleado;
import com.siapa.model.RequisitosolicitadoempleadoPK;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value="requisitoSolicitadoEmpleadoDao")
public class RequisitoSolicitadoEmpleadoDao extends GenericDao<Requisitosolicitadoempleado, RequisitosolicitadoempleadoPK> {

    public List<Requisitosolicitadoempleado> findRequisitosByAsesoria(Integer idAsesoria) {
        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery(
                        "SELECT rse FROM  Requisitosolicitadoempleado rse JOIN FETCH  rse.asesoria rsea JOIN FETCH  rse.requisitolineacreditoempleado drlc WHERE rsea.asesoriaId = :idAsesoria");
        q.setParameter("idAsesoria", idAsesoria);
        return q.list();
    }

    public List<Requisitosolicitadoempleado> findRequisitosLineaCreditoByAsesoria(Integer idAsesoria) {
        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery(
                        "SELECT rse FROM  Requisitosolicitadoempleado rse JOIN FETCH  rse.asesoria rsea JOIN FETCH  rse.requisitolineacreditoempleado drlc WHERE rsea.asesoriaId = :idAsesoria");
        q.setParameter("idAsesoria", idAsesoria);
        return q.list();
    }
}
