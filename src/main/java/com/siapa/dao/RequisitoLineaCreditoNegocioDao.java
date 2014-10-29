/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Requisitolineacreditonegocio;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue
 */
@Repository(value="requisitoLineaCreditoNegocioDao")
public class RequisitoLineaCreditoNegocioDao extends GenericDao<Requisitolineacreditonegocio, Integer>{
    
    
    
     public List<Requisitolineacreditonegocio> findRequisitosByIdLineaCredito(Integer idLineaCredito) {
         Query q= getSessionFactory().getCurrentSession().createQuery("Select rlcn from Requisitolineacreditonegocio rlcn WHERE rlcn.lineacreditoId.lineacreditoId= "+idLineaCredito);
         return q.list();
     }
}
