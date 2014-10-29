/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Sucursal;
import org.springframework.stereotype.Repository;

@Repository(value = "sucursalDao")
public class SucursalDao extends GenericDao<Sucursal, Integer> {

}
