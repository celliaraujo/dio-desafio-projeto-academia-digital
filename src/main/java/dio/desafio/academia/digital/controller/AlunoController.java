package dio.desafio.academia.digital.controller;

import dio.desafio.academia.digital.model.Aluno;
import dio.desafio.academia.digital.model.AvaliacaoFisica;
import dio.desafio.academia.digital.model.form.AlunoForm;
import dio.desafio.academia.digital.model.form.AlunoUpdateForm;
import dio.desafio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno criarAluno(@RequestBody AlunoForm form) {
        return service.criarAluno(form);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody AlunoUpdateForm form){
        return service.atualizarAluno(id, form);
    }

    @GetMapping("/{id}")
    public Aluno retornarAluno(@PathVariable Long id){
        return service.retornarAluno(id);
    }

    @GetMapping
    public List<Aluno> retornarTodosOsAlunos(){
        return service.retornarTodosOsAlunos();
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping("/dataDeNascimento")
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                              String dataDeNacimento){
        return service.getAll(dataDeNacimento);
    }



    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        service.deletarAluno(id);

    }



}
