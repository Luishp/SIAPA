/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.SolicitudDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Deuda;
import com.siapa.model.Garantiaasignadaasesoria;
import com.siapa.model.Prestamo;
import com.siapa.model.Promocion;
import com.siapa.model.Propiedad;
import com.siapa.model.Referenciafamiliar;
import com.siapa.model.Referenciapersonal;
import com.siapa.model.Solicitud;
import com.siapa.pojos.rpt.solicitud.ReporteSolicitudCredito;
import com.siapa.pojos.rpt.solicitud.RptDatosAsociados;
import com.siapa.pojos.rpt.solicitud.RptDatosConyuge;
import com.siapa.pojos.rpt.solicitud.RptDatosCredito;
import com.siapa.pojos.rpt.solicitud.RptDeudasComerciales;
import com.siapa.pojos.rpt.solicitud.RptEmpleoAnt;
import com.siapa.pojos.rpt.solicitud.RptInfoFinanciera;
import com.siapa.pojos.rpt.solicitud.RptInformacionLaboral;
import com.siapa.pojos.rpt.solicitud.RptPrestamos;
import com.siapa.pojos.rpt.solicitud.RptPropiedades;
import com.siapa.pojos.rpt.solicitud.RptReferencias;
import com.siapa.pojos.rpt.solicitud.RptTarjetasCredito;
import com.siapa.service.generic.GenericService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "solicitudService")
public class SolicitudService extends GenericService<Solicitud, Integer> {

    @Autowired
    private SolicitudDao solicitudDao;

    @Override
    public GenericDao<Solicitud, Integer> getDao() {
        return solicitudDao;
    }

    /**
     * Metodo para buscar una solicitud e credito por medio de la asesoria
     * relacionada
     *
     * @param idAsesoria
     * @return
     */
    public Solicitud findSolicitudByIdAsesoria(Integer idAsesoria) {
        return solicitudDao.findSolicitudByIdAsesoria(idAsesoria);
    }

    public List<Solicitud> findAllReadies() {
        return solicitudDao.findAllReadies();
    }

    public Solicitud findSolicitudByIdSolicitud(Integer idSolicitud) {
        return solicitudDao.findSolicitudByIdSolicitud(idSolicitud);
    }

    public Solicitud fillSolicitud(Solicitud solicitud) {
        return solicitudDao.fillSolicitud(solicitud);
    }

    /**
     * Metodo para calcular la tasa efectiva
     *
     * @param tasaNominal
     * @return
     */
    public BigDecimal calcularTasaEfectiva(BigDecimal tasaNominal) {

        BigDecimal tasaEfectiva = new BigDecimal(0);

        BigDecimal uno = new BigDecimal("1");
        BigDecimal periodicidad = new BigDecimal("12");

        BigDecimal tasaperiodica = tasaNominal.divide(periodicidad, 4, RoundingMode.CEILING);
        BigDecimal base = (uno.add(tasaperiodica));

        tasaEfectiva = (base.pow(12)).subtract(uno);

        return tasaEfectiva;
    }

    public ReporteSolicitudCredito prepararSolicitudParaReporte(Integer solicitudId) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Solicitud s = new Solicitud(solicitudId);
        s = solicitudDao.fillSolicitud(s);

        //I y III DATOS DEL ASOCIADO
        RptDatosAsociados datosAsociados = new RptDatosAsociados();
        datosAsociados.setCodigo(s.getSolicitudCodigoasociado());
        datosAsociados.setNombre1(s.getSolicitudNombre1());
        datosAsociados.setNombre2(s.getSolicitudNombre2());
        datosAsociados.setApellido1(s.getSolicitudApellido1());
        datosAsociados.setApellido2(s.getSolicitudApellido2());
        datosAsociados.setApellidoCasado(s.getSolicitudApellidocasada());

        if (s.getAsesoriaId().getIdasociados().getIdasocnatu() != null) {
            datosAsociados.setDui(s.getAsesoriaId().getIdasociados().getIdasocnatu().getNoDui());
            datosAsociados.setNit(s.getAsesoriaId().getIdasociados().getIdasocnatu().getNoNit());
            datosAsociados.setIsss(s.getAsesoriaId().getIdasociados().getIdasocnatu().getNoIsss());
            datosAsociados.setPasaporte("");
            datosAsociados.setProfesion(s.getAsesoriaId().getIdasociados().getIdasocnatu().getNivelEstudio());
            datosAsociados.setNacionalidad(s.getAsesoriaId().getIdasociados().getIdasocnatu().getNacionalidad());
            datosAsociados.setSexo(s.getAsesoriaId().getIdasociados().getIdasocnatu().getSexo());
            datosAsociados.setLugarexp(s.getAsesoriaId().getIdasociados().getIdasocnatu().getLugarExped());
            datosAsociados.setFechaexp(df.format(s.getAsesoriaId().getIdasociados().getIdasocnatu().getDateExped()));
            datosAsociados.setFechanac(df.format(s.getAsesoriaId().getIdasociados().getIdasocnatu().getDateNaci()));
            datosAsociados.setOtropais("");
            datosAsociados.setEstatuslegal(s.getAsesoriaId().getIdasociados().getIdasocnatu().getEstatusLegal());
            datosAsociados.setLugarnac(s.getAsesoriaId().getIdasociados().getIdasocnatu().getLugarNaci());
            datosAsociados.setEdad("");
            datosAsociados.setEstadocivil(s.getAsesoriaId().getIdasociados().getIdasocnatu().getEstatusLegal());
            datosAsociados.setNodependientes(s.getSolicitudNumdependiente());
            datosAsociados.setResidencia(s.getSolicitudResidenciaexntranjera());
            datosAsociados.setTiemporesidir(s.getAsesoriaId().getIdasociados().getIdasocnatu().getThmeses() != null ? s.getAsesoriaId().getIdasociados().getIdasocnatu().getThmeses().toString() : "0");
            datosAsociados.setDireccionresidencia(s.getAsesoriaId().getIdasociados().getIdasocnatu().getDireccionRes());
            datosAsociados.setTel(s.getAsesoriaId().getIdasociados().getIdasocnatu().getTelCasa1());
            datosAsociados.setCel(s.getAsesoriaId().getIdasociados().getIdasocnatu().getTelCel1());

        }

        //II  DATOS DEL CREDITO
        RptDatosCredito datosCredito = new RptDatosCredito();
        datosCredito.setIdSolicitud(s.getSolicitudId().toString());
        datosCredito.setMonto(s.getSolicitudMontosolicitado().toString());
        datosCredito.setPlazo(df.format(s.getSolicitudPlazosolicitado()));
        datosCredito.setDestino(s.getSolicitudDestino());
        datosCredito.setRecibesueldo(s.getSolicitudFechasueldo() != null ? s.getSolicitudFechasueldo().toString() : "");
        datosCredito.setDiapago(df.format(s.getSolicitudDiapago()));
        datosCredito.setFormapago(s.getFpId() != null ? s.getFpId().getFpNombre() : "");
        String garantia = "";
        for (Garantiaasignadaasesoria g : s.getAsesoriaId().getGarantiaasignadaasesoriaList()) {
            garantia = garantia.concat(g.getGarantia().getGarantiaNombre() + ";");
        }
        datosCredito.setGarantia(garantia);
        String promociones = "";
        for (Promocion p : s.getAsesoriaId().getPromocionList()) {
            promociones = promociones.concat(p.getPromocionNombre() + ";");
        }
        datosCredito.setAplicapromocion(promociones);

        //IV INFORMACION LABORAL
        RptInformacionLaboral informacionLaboral = new RptInformacionLaboral();
        informacionLaboral.setOtrosingresos("");      //Revisar
        informacionLaboral.setTipoempresa("");
        informacionLaboral.setNombreempresa(s.getSolicitudNombreempresa());
        informacionLaboral.setCargo(s.getSolicitudCargo());
        informacionLaboral.setDireccionempresa(s.getSolicitudDireccionempresa());
        informacionLaboral.setTiempodtrabmes(s.getSolicitudTiempotrabajomes() != null ? s.getSolicitudTiempotrabajomes().toString() : "");
        informacionLaboral.setTiempodtrabanio(s.getSolicitudTiempotrabajoanio() != null ? s.getSolicitudTiempotrabajoanio().toString() : "");
        informacionLaboral.setTelefono(s.getSolicitudTelefono());
        informacionLaboral.setFax(s.getSolicitudFaxempresa());
        informacionLaboral.setNrc(s.getSolicitudNegocionrc() != null ? s.getSolicitudNegocionrc().toString() : "");
        informacionLaboral.setNit(s.getSolicitudNegocionit());
        informacionLaboral.setActppalnegocio(s.getSolicitudNegocioactividad());
        informacionLaboral.setPropietariounico("");
        informacionLaboral.setNumpropietario(s.getSolicitudNegocionumpropietario() != null ? s.getSolicitudNegocionumpropietario().toString() : "");
        informacionLaboral.setParticipacion("");

        //V EMPLEO ANTERIOR
        RptEmpleoAnt empleoAnt = new RptEmpleoAnt();
        empleoAnt.setEmpresaanterior(s.getSolictudNombreempresaanterior());
        empleoAnt.setDirempresaant(s.getSolictudDireccionempresaanterior());
        empleoAnt.setFechaingresoant(s.getSolictudFechaingresoanterior() != null ? df.format(s.getSolictudFechaingresoanterior()) : "");
        empleoAnt.setFecharetiroant(s.getSolictudFecharetiroanterior() != null ? df.format(s.getSolictudFecharetiroanterior()) : "");
        empleoAnt.setTelant(s.getSolictudTelefonoanterior() != null ? s.getSolictudTelefonoanterior() : "");
        empleoAnt.setCargoant(s.getSolictudCargoanterior() != null ? s.getSolictudCargoanterior() : "");

        //VI DATOS DEL CONYUGUE
        RptDatosConyuge datosConyuge = new RptDatosConyuge();
        datosConyuge.setNombreconyuge(s.getSolicitudNombrecompletoconyuge());
        datosConyuge.setNombreemp(s.getSolicitudNombreempresaconyugue());
//        datosConyuge.setLugartrab(s.getSolicitud);
        datosConyuge.setTiempotrabmes(s.getSolicitudTiemoptrabajomesconyugue() != null ? s.getSolicitudTiemoptrabajomesconyugue().toString() : "0.00");
        datosConyuge.setTiempotrabanio(s.getSolicitudTiempotrabajoanioconyugue() != null ? s.getSolicitudTiempotrabajoanioconyugue().toString() : "0.00");
        datosConyuge.setTel(s.getSolicitudTelefonoconyuge());
        datosConyuge.setCargo(s.getSolicitudCargoconyugue());
        datosConyuge.setSueldo(s.getSolicitudSueldoconyuge() != null ? s.getSolicitudSueldoconyuge().toString() : "");
        datosConyuge.setNumDependientes(s.getSolicitudNumdependienteconyugue() != null ? s.getSolicitudNumdependienteconyugue().toString() : "");

        //VII INFORMACION FINANCIERA
        RptInfoFinanciera infoFinanciera = new RptInfoFinanciera();

        infoFinanciera.setSueldo(s.getSolicitudSueldo() != null ? s.getSolicitudSueldo().toString() : "0.00");
        infoFinanciera.setComision(s.getSolicitudIngresoComision() != null ? s.getSolicitudIngresoComision().toString() : "0.00");
        infoFinanciera.setOtrosingresos(s.getSolicitudIngresoOtros() != null ? s.getSolicitudIngresoOtros().toString() : "0.00");
        infoFinanciera.setNegocioprop(s.getSolicitudIngresoNegocioPropio() != null ? s.getSolicitudIngresoNegocioPropio().toString() : "0.00");
        infoFinanciera.setTotalingresos(s.getSolicitudTotalingreso() != null ? s.getSolicitudTotalingreso().toString() : "0.00");

        infoFinanciera.setGastovida(s.getSolicitudGastovida() != null ? s.getSolicitudGastovida().toString() : "0.00");
        infoFinanciera.setPagodeuda(s.getSolicitudPagodeudaactual() != null ? s.getSolicitudPagodeudaactual().toString() : "0.00");
        infoFinanciera.setPagovivienda(s.getSolicitudPagovivienda() != null ? s.getSolicitudPagovivienda().toString() : "0.00");
        infoFinanciera.setRet(s.getSolicitudDescuento() != null ? s.getSolicitudDescuento().toString() : "0.00");
        infoFinanciera.setTotalegreso(s.getSolicitudTotalegreso() != null ? s.getSolicitudTotalegreso().toString() : "0.00");
        infoFinanciera.setRentaNeta(s.getSolicitudRentaneta() != null ? s.getSolicitudRentaneta().toString() : "0.00");

        infoFinanciera.setAportacion(s.getSolicitudAportacionactivo() != null ? s.getSolicitudAportacionactivo().toString() : "0.00");
        infoFinanciera.setAhorro(s.getSolicitudAhorroactivo() != null ? s.getSolicitudAhorroactivo().toString() : "0.00");
        infoFinanciera.setOtros(s.getSolicitudOtroactivo() != null ? s.getSolicitudOtroactivo().toString() : "0.00");
        infoFinanciera.setPropiedades(s.getSolicitudValorpropiedad() != null ? s.getSolicitudValorpropiedad().toString() : "0.00");
        infoFinanciera.setVehiculo(s.getSolicitudValorvehiculo() != null ? s.getSolicitudValorvehiculo().toString() : "0.00");
        infoFinanciera.setTotalactivos(s.getSolicitudTotalactivo() != null ? s.getSolicitudTotalactivo().toString() : "0.00");

        infoFinanciera.setPrestamos(s.getSolicitudPrestamo() != null ? s.getSolicitudPrestamo().toString() : "0.00");
        infoFinanciera.setTotaldebefinanc(s.getSolicitudDeudaif() != null ? s.getSolicitudDeudaif().toString() : "0.00");
        infoFinanciera.setTotaldebeotros(s.getSolicitudOtradeuda() != null ? s.getSolicitudOtradeuda().toString() : "0.00");
        infoFinanciera.setTotalpasivo(s.getSolicitudTotalpasivo() != null ? s.getSolicitudTotalpasivo().toString() : "0.00");

        infoFinanciera.setCapital(s.getSolicitudCapital() != null ? s.getSolicitudCapital().toString() : "0.00");

        //VIII PROPIEDADES
        List<RptPropiedades> propiedades = new ArrayList<RptPropiedades>();

        for (Propiedad pro : s.getPropiedadList()) {
            RptPropiedades propiedad = new RptPropiedades();
            propiedad.setClaseprop(pro.getPropiedadClase());
            propiedad.setUbicacion(pro.getPropiedadUbicacion());
            propiedad.setValor(pro.getPropiedadValor() != null ? pro.getPropiedadValor().toString() : "0.00");
            propiedad.setHipoteca(pro.getPropiedadHipotecafavor());

            propiedades.add(propiedad);
        }

//        for (Prestamo pres : s.getP) {
        List<RptPrestamos> prestamosInternos = new ArrayList<RptPrestamos>();
        RptPrestamos prestamoInterno = new RptPrestamos();
        prestamoInterno.setNombrebanco("");
        prestamoInterno.setNumprestamo("");
        prestamoInterno.setCuota("");
        prestamoInterno.setFechaotorga("");
        prestamoInterno.setValororiginal("");
        prestamoInterno.setSaldoactual("");
        prestamoInterno.setVencimiento("");
        prestamosInternos.add(prestamoInterno);

//        }
        List<RptDeudasComerciales> deudascomerciales = new ArrayList<RptDeudasComerciales>();
        List<RptTarjetasCredito> tarjetascredito = new ArrayList<RptTarjetasCredito>();
        List<RptPrestamos> prestamosExternos = new ArrayList<RptPrestamos>();

        for (Deuda deuda : s.getDeudaList()) {
            //X DEUDAS COMERCIALES

            if (deuda.getTdId().getTdId() == 3) {
                RptDeudasComerciales deudaComercial = new RptDeudasComerciales();
                deudaComercial.setNombreinst(deuda.getDeudaNombreinstitucion());
                deudaComercial.setCuota(deuda.getDeudaCuota() != null ? deuda.getDeudaCuota().toString() : "0.00");
                deudaComercial.setFechaotorga(deuda.getDeudaFechaotorgado() != null ? df.format(deuda.getDeudaFechaotorgado()) : "");
                deudaComercial.setValororiginal(deuda.getDeudaValororiginal() != null ? deuda.getDeudaValororiginal().toString() : "0.00");
                deudaComercial.setSaldoactual(deuda.getDeudaSaldoactual() != null ? deuda.getDeudaSaldoactual().toString() : "0.00");
                deudaComercial.setVencimiento(deuda.getDeudaFechavencimiento() != null ? df.format(deuda.getDeudaFechavencimiento()) : "");
                deudascomerciales.add(deudaComercial);

            } else if (deuda.getTdId().getTdId() == 2) {
                //IX PRESTAMOS INSTITUCIONES FINANCIERAS
                RptPrestamos prestamoExterno = new RptPrestamos();
                prestamoExterno.setNombrebanco(deuda.getDeudaNombreinstitucion());
                prestamoExterno.setNumprestamo(deuda.getDeudaNumprestamo());
                prestamoExterno.setCuota(deuda.getDeudaCuota() != null ? deuda.getDeudaCuota().toString() : "0.00");
                prestamoExterno.setFechaotorga(deuda.getDeudaFechaotorgado() != null ? deuda.getDeudaFechaotorgado().toString() : "0.00");
                prestamoExterno.setValororiginal(deuda.getDeudaValororiginal() != null ? deuda.getDeudaValororiginal().toString() : "0.00");
                prestamoExterno.setSaldoactual(deuda.getDeudaSaldoactual() != null ? deuda.getDeudaSaldoactual().toString() : "0.00");
                prestamoExterno.setVencimiento(deuda.getDeudaFechavencimiento() != null ? df.format(deuda.getDeudaFechavencimiento()) : "0.00");
                prestamosExternos.add(prestamoExterno);

            } else if (deuda.getTdId().getTdId() == 1) {
                //XI TARJETAS DE CREDITO
                RptTarjetasCredito tarjetaCredito = new RptTarjetasCredito();
                tarjetaCredito.setEmisor(deuda.getDeudaNombreinstitucion());
                tarjetaCredito.setNumtarjeta(deuda.getDeudaNumtarjeta());
                tarjetaCredito.setFechaemision(deuda.getDeudaFechaotorgado() != null ? df.format(deuda.getDeudaFechaotorgado()) : "");
                tarjetaCredito.setLimite(deuda.getDeudaLimite() != null ? deuda.getDeudaLimite().toString() : "");
                tarjetaCredito.setSaldoactual(deuda.getDeudaSaldoactual() != null ? deuda.getDeudaSaldoactual().toString() : "0.00");
                tarjetaCredito.setPagominimo(deuda.getDeudaPagominimo() != null ? deuda.getDeudaPagominimo().toString() : "0.00");

                tarjetascredito.add(tarjetaCredito);
            }

        }

        //XII REFERENCIAS FAMILIARES
        List<RptReferencias> referenciasFamiliares = new ArrayList<RptReferencias>();

        for (Referenciafamiliar rf : s.getReferenciafamiliarList()) {
            RptReferencias referenciaFamiliar = new RptReferencias();
            referenciaFamiliar.setNombre(rf.getRfNombrecompleto());
            referenciaFamiliar.setDireccion(rf.getRfDireccion());
            referenciaFamiliar.setTelefono(rf.getRfTelefono());
            referenciaFamiliar.setParentesco(rf.getRfParentesco());

            referenciasFamiliares.add(referenciaFamiliar);
        }

        //XIII REFERENCIAS PERSONALES
        List<RptReferencias> referenciasPersonales = new ArrayList<RptReferencias>();
        for (Referenciapersonal rp : s.getReferenciapersonalList()) {
            RptReferencias referenciaPersonal = new RptReferencias();
            referenciaPersonal.setNombre(rp.getRpNombrecompleto());
            referenciaPersonal.setDireccion(rp.getRpDireccion());
            referenciaPersonal.setTelefono(rp.getRpTelefono());
            referenciaPersonal.setParentesco(rp.getRfTiempoconocerlo());//Resvisar el parentesco
            referenciasPersonales.add(referenciaPersonal);
        }

        //LLENAR SOLICITUD
        ReporteSolicitudCredito pojo = new ReporteSolicitudCredito();

        pojo.setDatosasociados(datosAsociados);
        pojo.setDatoscredito(datosCredito);
        pojo.setDatosconyuge(datosConyuge);
        pojo.setDeudascomerciales(deudascomerciales);
        pojo.setEmpleoanterior(empleoAnt);
        pojo.setInfofinanciera(infoFinanciera);
        pojo.setInfolaboral(informacionLaboral);
        pojo.setPrestamosext(prestamosExternos);
        pojo.setPrestamosint(prestamosInternos);
        pojo.setPropiedades(propiedades);
        pojo.setRefenciasfam(referenciasFamiliares);
        pojo.setReferenciasper(referenciasPersonales);
        pojo.setTarjetascredito(tarjetascredito);

        return pojo;
    }

}
