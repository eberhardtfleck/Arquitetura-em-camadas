package infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.Produto;
import application.ports.output.ProdutoRepositorioInterface;

/*
 * ============================================================
 * ADAPTADOR DE SAÍDA (HEXAGONAL)
 * ============================================================
 *
 * RESPONSABILIDADE:
 *   Implementa a porta de saída ProdutoRepositorioInterface,
 *   simulando persistência em memória com HashMap.
 *
 * OBSERVAÇÃO:
 *   Agora esta classe NÃO é mais dependida diretamente pelo core.
 *   Ela é apenas um adaptador.
 */
public class ProdutoRepositorio implements ProdutoRepositorioInterface {

    private HashMap<String, Produto> banco = new HashMap<>();

    @Override
    public void salvar(Produto produto) {
        banco.put(produto.getId(), produto);
    }

    @Override
    public Produto buscarPorId(String id) {
        return banco.get(id);
    }

    @Override
    public void excluirPorId(String id) {
        banco.remove(id);
    }

    @Override
    public List<Produto> listarTodos() {
        return new ArrayList<>(banco.values());
    }
}