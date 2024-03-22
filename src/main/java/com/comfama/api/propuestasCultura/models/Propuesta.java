package com.comfama.api.propuestasCultura.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "propuesta")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Propuesta {
    @Id
    @Column(name = "id_propuesta", nullable = false)
    private String idPropuesta;

    @Column(name = "Departamento")
    private String departamento;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "nombre_propuesta")
    private String nombrePropuesta;

    @Column(name= "fecha_inicio_evento")
    private LocalDate fechaInicioEvento;

    @Column(name= "fecha_fin_evento")
    private LocalDate fechaFinEvento;

    @Column(name = "tipo_poblacion")
    private String tipoPoblacion;

    @Column(name = "numero_personas")
    private Integer numeroPersonas;

    @Column(name = "entidades_aliadas")
    private String entidadesAliadas;

    @Column(name = "presentacion_general")
    private String presentacionGeneral;

    @CreationTimestamp
    @Column(name = "fecha_presentacion_propuesta", updatable = false)
    private LocalDate fechaPresentacionPropuesta;

    @Column(name = "descripcion_actividades")
    private String descripcionActividades;

    @Column(name = "trayectoria")
    private String trayectoria;

    @Column(name = "contraprestaciones")
    private String contraprestaciones;

    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "aporte_comfama_monetario")
    private Double aporteComfamaMonetario;

    @Column(name = "aporte_comfama_especie")
    private String aporteComfamaEspecie;

    @Column(name = "porcentaje_aporte_comfama")
    private Double porcentajeAporteComfama;

    @ManyToOne
    @JoinColumn(name = "id_solicitante", referencedColumnName = "id_solicitante")
    private Solicitante solicitante;

    @ManyToOne
    @JoinColumn(name ="idEstado", referencedColumnName = "id_estado")
    private Estados estado;

    @ManyToOne
    @JoinColumn(name ="idAreaEncargada", referencedColumnName = "id_area_encargada")
    private AreaEncargada areaEncargada;


    @PrePersist
    public void setIdPropuesta() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String fechaFormateada = LocalDateTime.now().format(formatter);

        this.idPropuesta = this.solicitante.getNumeroDocumento() + "_" + fechaFormateada;
    }
}
