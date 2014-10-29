package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Promocion;
import org.springframework.stereotype.Repository;

@Repository(value = "promocionDao")
public class PromocionDao extends GenericDao<Promocion, Integer> {

}
