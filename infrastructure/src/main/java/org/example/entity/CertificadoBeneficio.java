package org.example.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "certificado_beneficios")
public class CertificadoBeneficio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "caseid", length = 36)
    private String caseid;

    @Column(name = "mensage")
    private String mensage;

    @Column(name = "fecha_sol")
    private Instant fechaSol;

    @Column(name = "numero_solicitante")
    private Integer numeroSolicitante;

    @Column(name = "nombre_empresa", length = 50)
    private String nombreEmpresa;

    @Column(name = "tipo_solisitud", length = 2)
    private String tipoSolisitud;

    @Column(name = "fecha_finiquito")
    private Instant fechaFiniquito;

    @Column(name = "fecha_ult_giro")
    private Instant fechaUltGiro;

    @Column(name = "giros_pagados")
    private Integer girosPagados;

    @Column(name = "financiamento_CIC")
    private Integer financiamentoCic;

    @Column(name = "`financiamento _FCS`")
    private Integer financiamentoFcs;

    @Column(name = "`financiamento _totales_pagados`")
    private Integer financiamentoTotalesPagados;

    @Lob
    @Column(name = "pdf_certificado")
    private String pdfCertificado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public Instant getFechaSol() {
        return fechaSol;
    }

    public void setFechaSol(Instant fechaSol) {
        this.fechaSol = fechaSol;
    }

    public Integer getNumeroSolicitante() {
        return numeroSolicitante;
    }

    public void setNumeroSolicitante(Integer numeroSolicitante) {
        this.numeroSolicitante = numeroSolicitante;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipoSolisitud() {
        return tipoSolisitud;
    }

    public void setTipoSolisitud(String tipoSolisitud) {
        this.tipoSolisitud = tipoSolisitud;
    }

    public Instant getFechaFiniquito() {
        return fechaFiniquito;
    }

    public void setFechaFiniquito(Instant fechaFiniquito) {
        this.fechaFiniquito = fechaFiniquito;
    }

    public Instant getFechaUltGiro() {
        return fechaUltGiro;
    }

    public void setFechaUltGiro(Instant fechaUltGiro) {
        this.fechaUltGiro = fechaUltGiro;
    }

    public Integer getGirosPagados() {
        return girosPagados;
    }

    public void setGirosPagados(Integer girosPagados) {
        this.girosPagados = girosPagados;
    }

    public Integer getFinanciamentoCic() {
        return financiamentoCic;
    }

    public void setFinanciamentoCic(Integer financiamentoCic) {
        this.financiamentoCic = financiamentoCic;
    }

    public Integer getFinanciamentoFcs() {
        return financiamentoFcs;
    }

    public void setFinanciamentoFcs(Integer financiamentoFcs) {
        this.financiamentoFcs = financiamentoFcs;
    }

    public Integer getFinanciamentoTotalesPagados() {
        return financiamentoTotalesPagados;
    }

    public void setFinanciamentoTotalesPagados(Integer financiamentoTotalesPagados) {
        this.financiamentoTotalesPagados = financiamentoTotalesPagados;
    }

    public String getPdfCertificado() {
        return pdfCertificado;
    }

    public void setPdfCertificado(String pdfCertificado) {
        this.pdfCertificado = pdfCertificado;
    }

}