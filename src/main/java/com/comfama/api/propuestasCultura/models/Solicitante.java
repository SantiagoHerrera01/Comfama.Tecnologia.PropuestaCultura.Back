package com.comfama.api.propuestasCultura.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "solicitantes")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Solicitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitante", nullable = false,updatable = false)
    private Integer idSolicitante;
    @Column(name = "nombre_proponente")
    private String nombreProponente;
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    private TipoDocumento tipoDocumento;
    @Column(name = "nombres", nullable = false, length = 25)
    private String nombres;
    @Column(name = "apellidos",nullable = false, length = 35)
    private String apellidos;
    @Column(name = "numero_documento", nullable = false, length = 12)
    private String numeroDocumento;
    @Column(name = "telefono_fijo", nullable = false, length = 10)
    private String telefonoFijo;
    @Column(name = "telefono_celular", nullable = false, length = 10)
    private String telefonoCelular;
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

}
