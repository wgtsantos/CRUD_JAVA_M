/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.Conexao;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author Instrutor
 */
public class ProdutoDao {
    
    public void salvar(Produto produto){
        
        String sql = "INSERT INTO produto(nome, valor, marca) VALUES (?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            
            // Criar conexao com banco de dados
            conn = Conexao.createConnectionToMysql();
            
            // Criar uma confirmação para executar uma query(consulta) no banco
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            // Adicionar os valores na query criada na variavel slq
            pstm.setString(1, produto.getNome());
            pstm.setDouble(2, produto.getValor());
            pstm.setString(3, produto.getMarca());
            
            // Executar a query
            pstm.execute();
            
            System.out.println("Produto cadastrado com sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao tentar cadastrar produto na base de dados!!");
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (pstm != null) { 
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
                
            } catch (Exception e) {
                
                e.printStackTrace();
            }
            
        }
        
    }
    
    public List<Produto> listarProdutos() {
        
        String sql = "SELECT * FROM produto";
        
        List<Produto> produtos = new ArrayList<Produto>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            // Classe que vai recuperar os dados do banco.
            rset = pstm.executeQuery();
           
            while (rset.next()) {
                
             Produto produto = new Produto();   
             //Buscar todos os dados da tabela Produto
             produto.setId(rset.getInt("idproduto"));
             produto.setNome(rset.getString("nome"));
             produto.setValor(rset.getDouble("valor"));
             produto.setMarca(rset.getString("marca"));
             
             produtos.add(produto);   
            }
            
            System.out.println("Produtos listados com sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao tentar listar os produtos!!");
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (rset != null) { rset.close(); }
                if (conn != null) { conn.close(); }
                if (pstm != null) { pstm.close(); }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return produtos;
    }
    
    public List<Produto> listarProdutoporCod(int id) {
        
        String sql = "SELECT * FROM produto WHERE idproduto = ?";
        
        List<Produto> produtos = new ArrayList<Produto>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setInt(1, id);
            pstm.execute();
            
            // Classe que vai recuperar os dados do banco.
            rset = pstm.executeQuery();
           
            while (rset.next()) {
                
             Produto produto = new Produto();   
             //Buscar todos os dados da tabela Produto
             produto.setId(rset.getInt("idproduto"));
             produto.setNome(rset.getString("nome"));
             produto.setValor(rset.getDouble("valor"));
             produto.setMarca(rset.getString("marca"));
             
             produtos.add(produto);   
            }
            
            System.out.println("Produtos listado com sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao tentar lista os produto!!");
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (rset != null) { rset.close(); }
                if (conn != null) { conn.close(); }
                if (pstm != null) { pstm.close(); }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return produtos;
    }
    
    public void alterar(Produto produto) {
        
        String sql = "UPDATE produto SET nome = ?, valor = ?, marca = ? WHERE idproduto = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            // Adicionando valores a serem atualizados 
            pstm.setString(1, produto.getNome());
            pstm.setDouble(2, produto.getValor());
            pstm.setString(3, produto.getMarca());
            
            // Qual id do resgistro deseja atualizar
            pstm.setInt(4, produto.getId());
            
            // Executar a query
            pstm.execute();
            
            System.out.println("Produto atualizado com sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao atualizar o produto!!");
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (conn != null) { conn.close(); }
                if (pstm != null) { pstm.close(); }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 
    }
    
    public void excluir(int id) {
        
        String sql = "DELETE FROM produto WHERE idproduto = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setInt(1, id);
            pstm.execute();
            
            System.out.println("Produto excluído com sucesso!!");            
            
        } catch (Exception e) {
            
            System.out.println("Não foi possível excluir o produto.");
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (conn != null) { conn.close(); }
                if (pstm != null) { pstm.close(); }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
}
