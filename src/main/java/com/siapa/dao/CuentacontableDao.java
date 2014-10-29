package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Cuentacontable;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CuentacontableDao extends GenericDao<Cuentacontable, String> {

    public List<Cuentacontable> findAllActives() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT c  FROM Cuentacontable c  WHERE c.activo='SI'");
        return q.list();
    }
}
