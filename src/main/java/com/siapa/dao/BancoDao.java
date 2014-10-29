package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Banco;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "bancoDao")
public class BancoDao extends GenericDao<Banco, Integer> {

    public List<Banco> findAllActives() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT b  FROM Banco b LEFT JOIN FETCH  b.ccId2 Cuentacontable  WHERE b.activo='SI'");
        return q.list();
    }

}
