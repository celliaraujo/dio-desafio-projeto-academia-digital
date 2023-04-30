package dio.desafio.academia.digital.service;

import dio.desafio.academia.digital.model.Aluno;
import dio.desafio.academia.digital.model.AvaliacaoFisica;
import dio.desafio.academia.digital.model.form.AlunoForm;
import dio.desafio.academia.digital.model.form.AlunoUpdateForm;


import java.util.List;
import java.util.Optional;

public interface IAlunoService {
    /**
     * Cria um Aluno e salva no banco de dados.
     * @param form formulário referente aos dados para criação de um Aluno no banco de dados.
     * @return Aluno recém-criado.
     */
    Aluno criarAluno(AlunoForm form);

    /**
     * Retorna um Aluno que está no banco de dados de acordo com o seu Id.
     *
     * @param id id do Aluno que será exibido.
     * @return Aluno de acordo com o Id fornecido.
     */
    Aluno retornarAluno(Long id);

    /**
     * Retorna os Alunos que estão no banco de dados.
     * @return Uma lista os Alunos que estão salvas no DB.
     */
    List<Aluno> retornarTodosOsAlunos();



    /**
     * Retorna os Alunos que estão no banco de dados.
     * @return Uma lista os Alunos que estão salvas no DB.
     */
    List<Aluno> getAll(String dataDeNascimento);


    /**
     * Atualiza o Aluno.
     * @param id id do Aluno que será atualizado.
     * @param formUpdate formulário referente aos dados necessários para atualização do Aluno
     * no banco de dados.
     * @return Aluno recém-atualizado.
     */
    Aluno atualizarAluno(Long id, AlunoUpdateForm formUpdate);

    /**
     * Deleta um Aluno específico.
     * @param id id do Aluno que será removido.
     */
    void deletarAluno(Long id);

    /**
     *
     * @param id id do aluno que será recuperada a lista de avaliações
     * @return uma lista com todas as avaliações do aluno de acordo com o Id
     */
    List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);


}