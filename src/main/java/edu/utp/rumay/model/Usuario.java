package edu.utp.rumay.model;


import edu.utp.rumay.enums.RolDeUsuario;
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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombres;
    @NotNull
    private String dni;
    private String celular;
    @NotNull
    private String correo;
    @NotNull
    private String password;
    @Enumerated(EnumType.STRING)
    private RolDeUsuario rol;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreado;
}
