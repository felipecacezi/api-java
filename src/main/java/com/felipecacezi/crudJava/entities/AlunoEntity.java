package com.felipecacezi.crudJava.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "alunos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String email;
}