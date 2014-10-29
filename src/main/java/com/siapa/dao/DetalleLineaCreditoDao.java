/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Detallelineacredito;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue
 */
@Repository(value = "detalleLineaCreditoDao")
public class DetalleLineaCreditoDao extends GenericDao<Detallelineacredito, Integer> {

    public Detallelineacredito getDetalleLineaCredito(Integer idLineaCredito, BigDecimal monto) {
        List<Detallelineacredito> detalles;
        Query q = getSessionFactory().getCurrentSession()
                .createQuery("SELECT dlc FROM Detallelineacredito dlc WHERE dlc.lineacreditoId =" + idLineaCredito + " order by dlc.detallelineacreditoMonto");
        detalles = q.list();

        if (detalles.size() == 1) {
            return detalles.get(0);
        }

        for (Detallelineacredito dlc : detalles) {
            int i = dlc.getDetallelineacreditoMonto().compareTo(monto);
            if (i >= 0) {
                return dlc;
            }
        }

        return null;
    }

    public List<Detallelineacredito> findDetallebyLineaCredito(Integer idLineaCredito) {
        Query q = getSessionFactory().getCurrentSession().createQuery("Select detalle from Detallelineacredito detalle where detalle.lineacreditoId.lineacreditoId=" + idLineaCredito);
        return q.list();
    }

}
