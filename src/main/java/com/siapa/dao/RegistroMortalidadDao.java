/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.RegistroMortalidad;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joao
 */
@Repository
public class RegistroMortalidadDao extends GenericDao<RegistroMortalidad, Integer>{
    public List <RegistroMortalidad>getRegistroMortalidad(){
        
        Query q=getSessionFactory().getCurrentSession().createQuery("SELECT prov FROM registro_mortalidad prov JOIN FETCH prov.idJaula");
        return q.list();
        
    }
    
}