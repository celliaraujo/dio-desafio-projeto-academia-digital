package dio.desafio.academia.digital.controller;

import dio.desafio.academia.digital.model.Matricula;
import dio.desafio.academia.digital.model.form.MatriculaForm;
import dio.desafio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }

    @DeleteMapping("/{id}")
    public void deletarMatricula(@PathVariable Long id){
        service.deletarMatricula(id);
    }

}
