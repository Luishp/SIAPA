/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Registrogarantiaprendaria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JosueRogelio
 */
@Repository(value = "garantiaPredariaDao")
public class GarantiaPrendariaDao extends GenericDao<Registrogarantiaprendaria, Integer> {

}
