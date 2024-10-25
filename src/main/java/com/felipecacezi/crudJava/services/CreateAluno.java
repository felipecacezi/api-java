package com.felipecacezi.crudJava.services;

import com.felipecacezi.crudJava.dto.AlunoDTO;
import com.felipecacezi.crudJava.entities.AlunoEntity;
import com.felipecacezi.crudJava.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAluno {

    private final AlunoRepository alunoRepository;
    private String nome;
    private String email;

    @Autowired
    public CreateAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoEntity create(AlunoDTO data){
        AlunoEntity aluno = new AlunoEntity();
        aluno.setNome(data.nome());
        aluno.setEmail(data.email());
        alunoRepository.save(aluno);

        return aluno;
    }
}
