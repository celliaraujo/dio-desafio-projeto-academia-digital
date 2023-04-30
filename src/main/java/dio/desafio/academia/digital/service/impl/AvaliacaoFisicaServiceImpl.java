package dio.desafio.academia.digital.service.impl;

import dio.desafio.academia.digital.model.Aluno;
import dio.desafio.academia.digital.model.AvaliacaoFisica;
import dio.desafio.academia.digital.model.form.AvaliacaoFisicaForm;
import dio.desafio.academia.digital.model.form.AvaliacaoFisicaUpdateForm;
import dio.desafio.academia.digital.repository.AlunoRepository;
import dio.desafio.academia.digital.repository.AvaliacaoFisicaRepository;
import dio.desafio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

            Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
            avaliacaoFisica.setAluno(aluno);
            avaliacaoFisica.setPeso(form.getPeso());
            avaliacaoFisica.setAltura(form.getAltura());
            return avaliacaoFisicaRepository.save(avaliacaoFisica);



    }

    @Override
    public Optional<AvaliacaoFisica> get(Long id) {
        return avaliacaoFisicaRepository.findById(id);
    }



    @Override
    public List<AvaliacaoFisica> getAll() {

        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}