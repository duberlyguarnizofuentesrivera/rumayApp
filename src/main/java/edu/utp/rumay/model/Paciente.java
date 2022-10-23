package edu.utp.rumay.model;

import edu.utp.rumay.enums.Genero;
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
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombres;
    @NotNull
    private String dni;
    private int nacimiento; // Año de nacimiento, cuatro cifras, ejem.: 1987
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String celular;
    private String correo;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreado;
}
