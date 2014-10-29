/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Requisitolineacreditoempleado;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue
 */
@Repository(value = "requisitoLineaCreditoEmpleadoDao")
public class RequisitoLineaCreditoEmpleadoDao extends GenericDao<Requisitolineacreditoempleado, Integer> {

    public List<Requisitolineacreditoempleado> findRequisitosByIdLineaCredito(Integer idLineaCredito) {
        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery(
                        "SELECT rlce FROM  Requisitolineacreditoempleado rlce WHERE rlce.lineacreditoId.lineacreditoId = " + idLineaCredito);

        return q.list();
    }

}
