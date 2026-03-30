package application.ports.output;

import java.util.List;
import domain.Produto;

public interface ProdutoRepositorioInterface {

    void salvar(Produto produto);

    Produto buscarPorId(String id);

    void excluirPorId(String id);

    List<Produto> listarTodos();
}