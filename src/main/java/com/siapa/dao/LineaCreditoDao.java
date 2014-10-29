package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Lineacredito;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "lineaCreditoDao")
public class LineaCreditoDao extends GenericDao<Lineacredito, Integer> {

    public List<Lineacredito> findAllActives() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT l  FROM Lineacredito l LEFT JOIN FETCH  l.ccId2 Cuentacontable  WHERE l.activo='SI'");
        return q.list();
    }

    public List<Lineacredito> findAllLC() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT lc from Lineacredito lc");
        return q.list();

    }

    public Lineacredito findAllDet(Integer id) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT Lc from Lineacredito Lc    LEFT OUTER JOIN FETCH Lc.requisitolineacreditonegocioList reqn where Lc.lineacreditoId= " + id);
        return (Lineacredito) q.uniqueResult();

    }

}
