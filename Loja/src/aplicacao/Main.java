package aplicacao;

import java.util.Locale;
import java.util.Scanner;
import entidades.Produto;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Insira os dados do produto: ");

        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();

        System.out.println("Digite o Preço do produto: ");
        double preco = sc.nextDouble();

        System.out.println("Digite o quantidade do produto: ");
        int quantidade = sc.nextInt();

        Produto produto  = new Produto(nome, preco, quantidade);

        produto.setNome("Computador");

        System.out.println("Dados do Produto: " + produto);

        System.out.println("Novo nome do produto: " + produto.getNome());

        System.out.println("Numero de produtos pra serem adiocionados ao estoque: ");
        int adicionado = sc.nextInt();

        produto.adicionarProduto(adicionado);
        System.out.println("Dados atualizados: \n" + produto);

        System.out.println("Numero de produtos pra serem removidos do estoque: ");
        int removido = sc.nextInt();

        produto.removerProduto(removido);
        System.out.println("Dados atualizados: \n" + produto);

        sc.close();
        }
    }