public class GerenciadorEstoque implements GerenciadorEstoqueInterface {

    private ProdutoRepositorioInterface produtoRepositorio;
    private Estoque estoque;

    public GerenciadorEstoque(ProdutoRepositorioInterface produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
        this.estoque = new Estoque();
    }

    @Override
    public void cadastrarProduto(String id, String nome, double preco) {
        Produto produto = new Produto(id, nome, preco);
        produtoRepositorio.salvar(produto);
    }

    @Override
    public Produto consultarProduto(String id) {
        return produtoRepositorio.buscarPorId(id);
    }

    @Override
    public void excluirProduto(String id) {
        Produto produto = produtoRepositorio.buscarPorId(id);
        if (produto == null) {
            throw new IllegalArgumentException("Produto com ID '" + id + "' não encontrado.");
        }

        produtoRepositorio.excluirPorId(id);
    }

    @Override
    public double calcularPrecoMedio() {
        List<Produto> produtos = produtoRepositorio.listarTodos();
        return estoque.calcularPrecoMedio(produtos);
    }
}