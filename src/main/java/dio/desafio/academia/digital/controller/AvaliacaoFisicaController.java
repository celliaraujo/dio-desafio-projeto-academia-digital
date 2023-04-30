package dio.desafio.academia.digital.controller;

import dio.desafio.academia.digital.model.AvaliacaoFisica;
import dio.desafio.academia.digital.model.form.AvaliacaoFisicaForm;
import dio.desafio.academia.digital.repository.AvaliacaoFisicaRepository;
import dio.desafio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;
    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}