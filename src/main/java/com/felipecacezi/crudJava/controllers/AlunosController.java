package com.felipecacezi.crudJava.controllers;

import com.felipecacezi.crudJava.dto.AlunoDTO;
import com.felipecacezi.crudJava.entities.AlunoEntity;
import com.felipecacezi.crudJava.services.CreateAluno;
import com.felipecacezi.crudJava.services.DeleteAluno;
import com.felipecacezi.crudJava.services.GetAluno;
import com.felipecacezi.crudJava.services.UpdateAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private CreateAluno createAluno;
    @Autowired
    private UpdateAluno updateAluno;
    @Autowired
    private GetAluno getAluno;
    @Autowired
    private DeleteAluno deleteAluno;

    @GetMapping("/todos")
    public ResponseEntity<List<AlunoEntity>> getAlunos(){
        List<AlunoEntity> alunos = this.getAluno.all();
        return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> postAlunos(@RequestBody AlunoDTO body){
        AlunoEntity create = this.createAluno.create(body);
        return ResponseEntity.ok(create);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoEntity> putAlunos(@PathVariable UUID id, @RequestBody AlunoDTO body){
        AlunoEntity update = this.updateAluno.update(id, body);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlunoEntity> deleteAlunos(@PathVariable UUID id){
        AlunoEntity delete = this.deleteAluno.delete(id);
        return ResponseEntity.ok(delete);
    }
}
