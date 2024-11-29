package entidades;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto() {
    }

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double valorTotalEmEstoque() {
        return preco * quantidade;
    }
    public void adicionarProduto(int quantidade){
        this.quantidade += quantidade;
    }
    public void removerProduto(int quantidade){
        this.quantidade -= quantidade;
    }
    public String toString(){
        return nome + ", $" + String.format("%.2f", preco) + ", " + quantidade + " unidades" + ", Total: $ " + String.format("%.2f", valorTotalEmEstoque());
    }

}
