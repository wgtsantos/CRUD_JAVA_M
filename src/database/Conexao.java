/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Instrutor
 */
public class Conexao {
    
    // Nome do usuário do mysql
    private static final String USERNAME = "root";
    // Senha do banco de dados
    private static final String PASSWORD = "";
    // Caminho do banco de dados, porta(3306) nome do base de dados
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_crud";
    
    public static Connection createConnectionToMysql() throws Exception {
        
        // Faz com que a classe seja carregada na JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Cria conexao com o banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    
        return connection;
    }
    
    public static void main(String[] args) throws Exception {
        
        // Criar ou recuperar uma conexao com o banco
        Connection con = createConnectionToMysql();
        
        // Teste de conexaõ com o banco de dados
        if (con != null) {
            
            System.out.println("Conexao estabelecida com sucesso!!");
            con.close();
        }
        
    }
    
}
