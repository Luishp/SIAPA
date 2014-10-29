package com.siapa.service;

import com.siapa.dao.AsesoriaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Asesoria;
import com.siapa.pojos.rpt.asesoria.ReporteAsesoriaCreditopojo;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "asesoriaService")
public class AsesoriaService extends GenericService<Asesoria, Integer> {

    @Autowired
    private AsesoriaDao asesoriaDao;

    @Override
    public GenericDao<Asesoria, Integer> getDao() {
        return asesoriaDao;
    }

    /**
     * Metodo para buscar asesorias por id y cargar las entidades relacionadas
     *
     * @param idAsesoria
     * @return
     */
    public Asesoria findAsesoriaById(Integer idAsesoria) {
        return asesoriaDao.findAsesoriaById(idAsesoria);
    }

    /**
     * Metodo para buscar asesorias que no tienen asociada una solicitud de
     * credito
     *
     * @return
     */
    public List<Asesoria> findAsesoriaWithoutSolicitud() {
        return asesoriaDao.findAsesoriaWithoutSolicitud();
    }

    /**
     * Metodo para buscar Asesoria por medio de la solictud asociada
     *
     * @param idSolicitud
     * @return
     */
    public Asesoria findAsesoriaBySolicitud(Integer idSolicitud) {
        return asesoriaDao.findAsesoriaBySolicitud(idSolicitud);
    }

    public Asesoria fillAsesoria(Asesoria asesoria) {
        return asesoriaDao.fillAsesoria(asesoria);
    }

    public ReporteAsesoriaCreditopojo fillAsesoriaRpt(Asesoria asesoria) {
        ReporteAsesoriaCreditopojo pojo = new ReporteAsesoriaCreditopojo();
        Asesoria tmp = asesoriaDao.fillAsesoria(asesoria);

        pojo.setAsociadoCodigo(tmp.getIdasociados().getCodigo());
        pojo.setAsociadoNombre(tmp.getIdasociados().getIdasocnatu().getNombreCompleto());
        pojo.setAsociadoIngreso(tmp.getAsesoriaIngreso() != null ? tmp.getAsesoriaIngreso().toString() : "0.00");

        pojo.setCreditoLinea(tmp.getDetallelineacreditoId() != null ? tmp.getDetallelineacreditoId().getLineacreditoId().getLineacreditoNombre() : "");
        pojo.setCreditoGarantia("");
        pojo.setCreditoMonto(tmp.getAsesoriaMonto() != null ? tmp.getAsesoriaMonto().toString() : "0.00");
        pojo.setCreditoPlazo(tmp.getAsesoriaPlazo() != null ? tmp.getAsesoriaPlazo().toString() : "0.00");
        pojo.setCreditoTasaInteres(tmp.getAsesoriaTasa() != null ? tmp.getAsesoriaTasa().toString() : "0.00");
        pojo.setCreditoFormaPago(tmp.getFpId() != null ? tmp.getFpId().getFpNombre() : "");

        pojo.setGarantiaValorpropiedad(tmp.getAsesoriaValorpropiedad() != null ? tmp.getAsesoriaValorpropiedad().toString() : "0.00");
        pojo.setGarantiaValorconstruccion(tmp.getAsesoriaValorconstruccion() != null ? tmp.getAsesoriaValorconstruccion().toString() : "0.00");
        pojo.setGarantiaValorcompraventa(tmp.getAsesoriaValorcompraventa() != null ? tmp.getAsesoriaValorcompraventa().toString() : "0.00");
        pojo.setGarantiaValorhipotecaanterior(tmp.getAsesoriaValorhipotecaanterior() != null ? tmp.getAsesoriaValorhipotecaanterior().toString() : "0.00");
        pojo.setGarantiaValorhipotecaactual(tmp.getAsesoriaValorhipotecaactual() != null ? tmp.getAsesoriaValorhipotecaactual().toString() : "0.00");

        pojo.setCuotaCapitalintereses(tmp.getAsesoriaCapitalinteres() != null ? tmp.getAsesoriaCapitalinteres().toString() : "0.00");
        pojo.setCuotaSegurodeuda(tmp.getAsesoriaSegurodeuda() != null ? tmp.getAsesoriaSegurodeuda().toString() : "0.00");
        pojo.setCuotaSegurodaños(tmp.getAsesoriaSegurodanio() != null ? tmp.getAsesoriaSegurodanio().toString() : "0.00");
        pojo.setCuotaEstimada(tmp.getAsesoriaCuota() != null ? tmp.getAsesoriaCuota().toString() : "0.00");

        pojo.setGastosComplementoAportaciones(tmp.getAsesoriaRelacionaportacion() != null ? tmp.getAsesoriaRelacionaportacion().toString() : "0.00");
        pojo.setGastosComisionOtorgamiento(tmp.getAsesoriaComisionotorgamiento() != null ? tmp.getAsesoriaComisionotorgamiento().toString() : "0.00");
        pojo.setGastosValuoinmueble(tmp.getAsesoriaHonorariovaluo() != null ? tmp.getAsesoriaHonorariovaluo().toString() : "0.00");
        pojo.setGastosImpuestoHipoteca(tmp.getAsesoriaImpuestohipoteca() != null ? tmp.getAsesoriaImpuestohipoteca().toString() : "0.00");
        pojo.setGastosImpuestoCompraventa(tmp.getAsesoriaImpuestocompraventa() != null ? tmp.getAsesoriaImpuestocompraventa().toString() : "0.00");
        pojo.setGastosImpuestoTransferencia(tmp.getAsesoriaImpuestotransferencia() != null ? tmp.getAsesoriaImpuestotransferencia().toString() : "0.00");
        pojo.setGastosImpuestocancelacionhipoteca(tmp.getAsesoriaCancelacionhipoteca().toString());
        pojo.setGastosHonorarionotario(tmp.getAsesoriaHonorariojuridico() != null ? tmp.getAsesoriaHonorariojuridico().toString() : "0.00");
        pojo.setGastosTotalEstimado(tmp.getAsesoriaTotalgasto() != null ? tmp.getAsesoriaTotalgasto().toString() : "0.00");

        pojo.setAsesoraNombre("Carmen Elena Flores");
        pojo.setAsesoraTelefono("2235-2564");
        pojo.setAsesoraCelular("7598-3214");
        pojo.setAsesoraEmail("elena.flores@gmail.com");
        pojo.setAsesoraFecha("12/02/2014");

        pojo.setObservaciones("Sin Observacion");

        return pojo;
    }
}
