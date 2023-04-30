package dio.desafio.academia.digital.service.impl;

import dio.desafio.academia.digital.model.Aluno;
import dio.desafio.academia.digital.model.Matricula;
import dio.desafio.academia.digital.model.form.MatriculaForm;
import dio.desafio.academia.digital.repository.AlunoRepository;
import dio.desafio.academia.digital.repository.MatriculaRepository;
import dio.desafio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {

        if(bairro == null){
            return matriculaRepository.findAll();
        }else{
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
        }

    }

    @Override
    public void deletarMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }



}