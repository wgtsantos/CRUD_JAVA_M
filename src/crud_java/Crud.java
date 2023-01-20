/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud_java;

import dao.ProdutoDao;
import java.util.Scanner;
import model.Produto;

/**
 *
 * @author Instrutor
 */
public class Crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Scanner inn = new Scanner(System.in);
        
        ProdutoDao produtodao = new ProdutoDao();
        Produto produto = new Produto();
        
        System.out.println("Escolha uma opção: ");
        System.out.println("1- Cadastrar Produto ");
        System.out.println("2- Listar Produtos ");
        System.out.println("3- Pesquisar por Código ");
        System.out.println("4- Atualizar Produto ");
        System.out.println("5- Deletar produto ");
        
        int opt = in.nextInt();
        
        switch (opt) {
            case 1:
                System.out.println("Digite o nome do produto: ");
                String nome = inn.nextLine();
                produto.setNome(nome);
                System.out.println("Digite o valor do produto: ");
                Double valor = in.nextDouble();
                produto.setValor(valor);
                System.out.println("Digite o marca do produto: ");
                String marca = in.next();
                produto.setMarca(marca);
                
                produtodao.salvar(produto);
                
                break;
                
            case 2:
                int cont = 1;
                System.out.println("");
                System.out.println("Produtos cadastrados no banco: ");
                
                for (Produto c : produtodao.listarProdutos()) {
                    System.out.println("Produto00" + cont + "----------------");
                    System.out.println("ID: " + c.getId());
                    System.out.println("Nome: " + c.getNome());
                    System.out.println("Valor: " + c.getValor());
                    System.out.println("Marca: " + c.getMarca());
                    System.out.println("-----------------------------------");
                    System.out.println("");
                    
                    cont++;
                }
                
                break;
                
            case 3:
               System.out.println("Pesquisar Produto por Código -------------------------");
                System.out.println("");
                System.out.println("Informe o ID do produto: ");
                int cod = in.nextInt();
                
                for (Produto c : produtodao.listarProdutoporCod(cod)) {
                    System.out.println("----------------");
                    System.out.println("ID: " + c.getId());
                    System.out.println("Nome: " + c.getNome());
                    System.out.println("Valor: " + c.getValor());
                    System.out.println("Marca: " + c.getMarca());
                    System.out.println("-----------------------------------");
                    System.out.println("");
                    
                }
               break;
           
            case 4:
               System.out.println("");
               System.out.println("Alterar Produto -------------------------");
               System.out.println("Informe o código do produto: ");
               int id = in.nextInt();
               produto.setId(id);
               
               System.out.println("");
               System.out.println("Alterar dados do produto ID " + id + " --------");
               
               System.out.println("Digite o nome do produto: ");
               nome = inn.nextLine();
               produto.setNome(nome);
               System.out.println("Digite o valor do produto: ");
               valor = in.nextDouble();
               produto.setValor(valor);
               System.out.println("Digite o marca do produto: ");
               marca = in.next();
               produto.setMarca(marca);
               
               produtodao.alterar(produto);
               break;
            
            case 5:
               System.out.println("");
               System.out.println("Informe o Cod do Produto que deseja excluir.");
               cod = in.nextInt();
               System.out.println("Deseja realmente excluir este produto do id " + cod + "?");
               System.out.println("1-SIM");
               System.out.println("2-NÃO");
               int opcao = in.nextInt();
               
                switch (opcao) {
                    case 1:
                        produtodao.excluir(cod);
                        break;
                    case 2:
                        System.out.println("Operação cancelada!");
                        break;
                    default:
                        System.out.println("Opção inválida!!");
                        throw new AssertionError();
                }
               break;
                
            default:
               System.out.println("Opção Inválida");
               break;  
        }
         
    }
    
}
