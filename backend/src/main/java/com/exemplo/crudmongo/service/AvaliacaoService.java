package com.exemplo.crudmongo.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.exemplo.crudmongo.Model.Avaliacao;
import com.exemplo.crudmongo.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
    private final AvaliacaoRepository repository; // Repositório para acesso ao banco de dados
    
    /**
     * Injeta o repositório PessoaRepository via construtor.
     */
    public AvaliacaoService(AvaliacaoRepository repository) {
        this.repository = repository;
    }


    /**
     * Retorna todas as avaliações cadastradas no banco de dados.
     * @return Lista de avaliações
     */
    public List<Avaliacao> listarTodas() {
        return repository.findAll();
    }

    /**
     * Salva uma nova avaliação no banco de dados.
     * @param avaliacao Objeto Avaliacao a ser salvo
     * @return Avaliacao salva
     */
    public Avaliacao salvar(Avaliacao avaliacao) {
        return repository.save(avaliacao);
    }

    /**
     * Atualiza uma avaliação existente pelo ID.
     * @param id Identificador da avaliação a ser atualizada
     * @param novaAvaliacao Dados atualizados da avaliação
     * @return Avaliacao atualizada
     */
    public Avaliacao atualizar( Long id,  Avaliacao novaAvaliacao) {
        return repository.findById(id).map(a -> {
            a.setPessoaId(novaAvaliacao.getPessoaId());
            a.setDisciplinaId(novaAvaliacao.getDisciplinaId());
            a.setNota(novaAvaliacao.getNota());
            a.setData(novaAvaliacao.getData());
            a.setAtivo(novaAvaliacao.isAtivo());
            return repository.save(a);
        }).orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
    }

    /**
     * Exclui uma avaliação pelo ID.
     * @param id Identificador da avaliação a ser excluída
     */
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}