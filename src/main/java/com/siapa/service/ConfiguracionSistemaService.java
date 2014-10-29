package com.siapa.service;

import com.siapa.dao.ConfiguracionSistemaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Configuracionsistema;
import com.siapa.service.generic.GenericService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "configuracionSistemaService")
public class ConfiguracionSistemaService extends GenericService<Configuracionsistema, Integer> {

    @Autowired
    private ConfiguracionSistemaDao configuracionSistemaDao;

    @Override
    public GenericDao<Configuracionsistema, Integer> getDao() {
        return configuracionSistemaDao;
    }

    public Configuracionsistema findConfiguracionByNombre(String nombreVariable) {
        return configuracionSistemaDao.findConfiguracionByNombre(nombreVariable);
    }

    public String findValueString(String nombreVariable) {
        return configuracionSistemaDao.findValueString(nombreVariable);
    }

    public BigDecimal findValueDecimal(String nombreVariable) {
        return configuracionSistemaDao.findValueDecimal(nombreVariable);
    }

    public Integer findValueInteger(String nombreVariable) {
        return configuracionSistemaDao.findValueInteger(nombreVariable);
    }
}
