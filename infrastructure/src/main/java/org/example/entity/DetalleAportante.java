package org.example.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "detalle_aportantes")
public class DetalleAportante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "mensage", length = 2)
    private String mensage;

    @Column(name = "caseid", length = 36)
    private String caseid;

    @Column(name = "rut_empleador")
    private Integer rutEmpleador;

    @Column(name = "nombre_compania", length = 16)
    private String nombreCompania;

    @Column(name = "estado_contrato", length = 7)
    private String estadoContrato;

    @Column(name = "fecha_inicio_contrato")
    private Instant fechaInicioContrato;

    @Column(name = "fecha_fin")
    private Instant fechaFin;

    @Column(name = "tipo_contrato", length = 19)
    private String tipoContrato;

    @Column(name = "total_contribucion")
    private Integer totalContribucion;

    @Lob
    @Column(name = "monto_periodo")
    private String montoPeriodo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    public Integer getRutEmpleador() {
        return rutEmpleador;
    }

    public void setRutEmpleador(Integer rutEmpleador) {
        this.rutEmpleador = rutEmpleador;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(String estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

    public Instant getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(Instant fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public Instant getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Instant fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Integer getTotalContribucion() {
        return totalContribucion;
    }

    public void setTotalContribucion(Integer totalContribucion) {
        this.totalContribucion = totalContribucion;
    }

    public String getMontoPeriodo() {
        return montoPeriodo;
    }

    public void setMontoPeriodo(String montoPeriodo) {
        this.montoPeriodo = montoPeriodo;
    }

}