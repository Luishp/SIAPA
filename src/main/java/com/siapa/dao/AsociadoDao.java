package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Asociados;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "asociadoDao")
public class AsociadoDao extends GenericDao<Asociados, Integer> {
    
    public Asociados findByCodigo(String codigoAsociado){
       Query q=getSessionFactory().getCurrentSession()
               .createQuery("SELECT a FROM Asociados a LEFT JOIN FETCH a.idasocnatu LEFT JOIN FETCH a.idasocjuri WHERE a.codigo='"+codigoAsociado+"'");
       Asociados asociado=(Asociados) q.uniqueResult();
       return asociado;
       
    }
    
    
    
}
