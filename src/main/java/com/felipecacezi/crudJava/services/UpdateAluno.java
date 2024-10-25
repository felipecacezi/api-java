package com.felipecacezi.crudJava.services;

import com.felipecacezi.crudJava.dto.AlunoDTO;
import com.felipecacezi.crudJava.entities.AlunoEntity;
import com.felipecacezi.crudJava.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UpdateAluno {

    private final AlunoRepository alunoRepository;
    private String nome;
    private String email;

    @Autowired
    public UpdateAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoEntity update(UUID id, AlunoDTO data){
        AlunoEntity aluno = alunoRepository
            .findById(id)
            .orElseThrow(
                    () ->  new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Impossível continuar, motivo: aluno não encontrado."
                    )
            );

        aluno.setNome(data.nome());
        aluno.setEmail(data.email());
        alunoRepository.save(aluno);

        return aluno;
    }
}
