package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.SsRoles;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "ssRolesDao")
public class SsRolesDao extends GenericDao<SsRoles, Integer> {

    public List<SsRoles> findByUrl(String url) {
        List<SsRoles> rolesYOpciones=null;
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT o FROM SsRoles o JOIN FETCH o.ssOpcionesSet op WHERE op.url LIKE :url ");
        q.setParameter("url", "%" + url + "%");
        rolesYOpciones=q.list();
        return rolesYOpciones;
    }
}
