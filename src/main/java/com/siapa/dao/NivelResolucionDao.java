package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Nivelresolucion;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "nivelResolucionDao")
public class NivelResolucionDao extends GenericDao<Nivelresolucion, Integer> {

    public List<Nivelresolucion> findAllActives() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT nr  FROM Nivelresolucion nr WHERE nr.activo='SI'");
        return q.list();
    }

}
