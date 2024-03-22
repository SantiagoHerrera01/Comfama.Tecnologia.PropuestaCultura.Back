package com.comfama.api.propuestasCultura.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false,updatable = false)
    private Integer idUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @ManyToOne
    @JoinColumn(name = "id_area_encargada", referencedColumnName = "id_area_encargada")
    private AreaEncargada areaEncargada;

    @Column(name = "correo_usuario")
    private String correoUsuario;

    @CreationTimestamp
    @Column(name = "fecha_creacion" , updatable = false)
    private LocalDateTime fechaCreacion;
}
