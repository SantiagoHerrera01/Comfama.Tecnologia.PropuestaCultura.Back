package com.comfama.api.propuestasCultura.models;

import com.comfama.api.propuestasCultura.helpers.NegocioRespuestaPropuesta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "respuestas_propuestas")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespuestaPropuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta_propuesta")
    private Integer idRespuestaPropuesta;
    @ManyToOne
    @JoinColumn(name = "id_propuesta", referencedColumnName = "id_propuesta")
    private Propuesta propuesta;
    @Column(name = "fecha_recepcion")
    private LocalDateTime fechaRecepcion;
    @Column(name = "consulta_listas_publicas")
    private Boolean consultaListasPublicas;
    @ManyToOne
    @JoinColumn(name = "id_area_encargada", referencedColumnName = "id_area_encargada")
    private AreaEncargada areaEncargada;
    @Column(name = "negocio")
    @Enumerated(EnumType.STRING)
    private NegocioRespuestaPropuesta negocio = NegocioRespuestaPropuesta.FAMILIAS; //ENUM
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "monto_aprobado_por_cultura")
    private Double montoAprobadoPorCultura;
    @Column(name = "encargado_respuesta")
    private String encargadoRespuesta;
    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    private Estados estado;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "id_usuario_crea", referencedColumnName = "id_usuario")
    private Usuarios usuarios;
}
