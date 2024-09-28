package aplicacao;

import java.util.Locale;
import java.util.Scanner;
import entidades.Produto;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        Produto produto = new Produto();

        System.out.println("Insira os dados do produto: ");

        System.out.println("Digite o nome do produto: ");
        produto.nome = sc.nextLine();

        System.out.println("Digite o Preço do produto: ");
        produto.preco = sc.nextDouble();

        System.out.println("Digite o quantidade do produto: ");
        produto.quantidade = sc.nextInt();

        System.out.println("Dados do Produto: " + produto);

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