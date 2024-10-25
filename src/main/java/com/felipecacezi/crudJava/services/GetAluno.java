package com.felipecacezi.crudJava.services;

import com.felipecacezi.crudJava.dto.AlunoDTO;
import com.felipecacezi.crudJava.entities.AlunoEntity;
import com.felipecacezi.crudJava.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAluno {

    private final AlunoRepository alunoRepository;

    @Autowired
    public GetAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoEntity> all(){
        return alunoRepository.findAll();
    }
}
