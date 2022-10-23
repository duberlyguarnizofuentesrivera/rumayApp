package edu.utp.rumay.model;

import edu.utp.rumay.enums.TipoRegistro;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RegistroClinico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ToString.Exclude
    @ManyToOne
    private HistoriaClinica historiaClinica;
    @NotNull
    private String descripcion;
    private String observaciones;
    @NotNull
    private TipoRegistro tipoRegistro;
    private boolean recetaEmitida;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreado;
}
