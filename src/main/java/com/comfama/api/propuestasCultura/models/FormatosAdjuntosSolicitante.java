package com.comfama.api.propuestasCultura.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "formatos_adjuntos_solicitante")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormatosAdjuntosSolicitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adjunto_solicitante")
    private Integer idAdjuntoSolicitante;

    @OneToOne
    @JoinColumn(name = "id_propuesta", referencedColumnName = "id_propuesta")
    private Propuesta propuesta;

    @Column(name = "ruta_formato_inhabilidades")
    private String rutaFormatoInhabilidades;

    @Column(name = "webUrl_formato_inhabilidades")
    private String webUrlFormatoInhabilidades;

    @Column(name = "fecha_creacion_formato_inhabilidades")
    private String fechaCreacionFormatoInhabilidades;

    @Column(name = "ruta_formato_tratamiento_datos")
    private String rutaFormatoTratamientoDatos;

    @Column(name = "webUrl_formato_tratamiento_datos")
    private String webUrlFormatoTratamientoDatos;

    @Column(name = "fecha_creacion_formato_tratamiento_datos")
    private String fechaCreacionFormatoTratamientoDatos;
}
