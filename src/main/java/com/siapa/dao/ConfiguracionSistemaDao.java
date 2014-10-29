package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Configuracionsistema;
import java.math.BigDecimal;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "configuracionSistemaDao")
public class ConfiguracionSistemaDao extends GenericDao<Configuracionsistema, Integer> {

    public Configuracionsistema findConfiguracionByNombre(String nombreVariable) {
        Query q = getSessionFactory().getCurrentSession()
                .createQuery("SELECT cs FROM Configuracionsistema cs WHERE cs.configuracionSistemaNombre = '" + nombreVariable + "'");

        return (Configuracionsistema) q.uniqueResult();

    }

    public String findValueString(String nombreVariable) {
        Query q = getSessionFactory().getCurrentSession()
                .createQuery("SELECT cs FROM Configuracionsistema cs WHERE cs.configuracionSistemaNombre = '" + nombreVariable + "'");
        Configuracionsistema cs = (Configuracionsistema) q.uniqueResult();
        return cs.getConfiguracionSistemaValor();

    }

    public BigDecimal findValueDecimal(String nombreVariable) {
        BigDecimal val = BigDecimal.ZERO;
        Query q = getSessionFactory().getCurrentSession()
                .createQuery("SELECT cs FROM Configuracionsistema cs WHERE cs.configuracionSistemaNombre = '" + nombreVariable + "'");
        Configuracionsistema cs = (Configuracionsistema) q.uniqueResult();

        if (cs != null) {
            try {
                val = new BigDecimal(cs.getConfiguracionSistemaValor());
            } catch (Exception e) {
                return BigDecimal.ZERO;

            }
        }

        return val;
    }

    public Integer findValueInteger(String nombreVariable) {
        Integer val = 0;
        Query q = getSessionFactory().getCurrentSession()
                .createQuery("SELECT cs FROM Configuracionsistema cs WHERE cs.configuracionSistemaNombre = '" + nombreVariable + "'");
        Configuracionsistema cs = (Configuracionsistema) q.uniqueResult();

        if (cs != null) {
            try {
                val = Integer.valueOf(cs.getConfiguracionSistemaValor());
            } catch (NumberFormatException e) {
                return 0;

            }
        }

        return val;

    }

}
