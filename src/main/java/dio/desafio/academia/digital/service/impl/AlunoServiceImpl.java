package dio.desafio.academia.digital.service.impl;

import dio.desafio.academia.digital.infra.utils.JavaTimeUtils;
import dio.desafio.academia.digital.model.Aluno;
import dio.desafio.academia.digital.model.AvaliacaoFisica;
import dio.desafio.academia.digital.model.form.AlunoForm;
import dio.desafio.academia.digital.model.form.AlunoUpdateForm;
import dio.desafio.academia.digital.repository.AlunoRepository;
import dio.desafio.academia.digital.repository.MatriculaRepository;
import dio.desafio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository repository;
    @Autowired
    private MatriculaRepository repositoryMatricula;

    @Override
    public Aluno criarAluno(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return repository.save(aluno);
    }

    @Override
    public Aluno retornarAluno(Long id) {
        return repository.findById(id).get();

    }

    @Override
    public List<Aluno> retornarTodosOsAlunos() {
        return repository.findAll();
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {

        if(dataDeNascimento == null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }

    }

    @Override
    public Aluno atualizarAluno(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = repository.findById(id).get();
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
        return repository.save(aluno);
    }

    @Override
    public void deletarAluno(Long id) {
        Aluno aluno = repository.findById(id).get();
        repositoryMatricula.deleteByAluno(aluno);
        repository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

        Aluno aluno = repository.findById(id).get();

        return aluno.getAvaliacoes();

    }

}