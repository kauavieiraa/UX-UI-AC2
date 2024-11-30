package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Representa um sistema de Login de usuários com autenticação no banco de dados
 * 
 * <p>A classe conecta-se a um banco de dados MySQL e verifica se o usuário e 
 * senha existem no banco.</p>
 * 
 * @author Kauã Vieira Mendonça Santos
 * @version 1.0
 */

public class User {
    /**
     * Determina uma conexão com o banco de dados MySQL
     * 
     * <p> A conexão é estabelecida com base na URL passada.
     * 
     * @return Um objeto representando a conexão do banco de dados ou retorna
     * null caso a conxeão falhou
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            //O método carrega o driver e cria uma nova instância 
            Class.forName("com.mysql.DriverManager").newInstance();
            
            //Configuração da URL de conexão
            String url = "jdbc:mysql://localhost:3306/Recreio_Da_Esperanca?serverTimezone=UTC";
            
            //Estabele a conexão com o banco de dados 
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            //Exceção capturada
        }
        return conn;
    }

    /**
     * Com o nome do usuário autenticado pelo banco de dados, o atributo é 
     * preenchido após a autenticação realizada com sucesso.
     */
    public String nome = "";
    /**
     * Resultado da verificação das credenciais
     * 
     */
    public boolean result = false;
    
    /**
     * Verifica se o login e o usuário que o usuário passou estão cadastrados no banco de dados.
     * 
     * @param login O login do usuário a ser autencidado
     * @param senha A senha correspondente ao login já escrito anteriormente
     * @return Define o result =  true caso as credenciais citados sejam válidos
     * ou result = false caso não sejam válidos.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();

        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try {
            //Elaboração da consulta SQL e sua execução no banco de dados.
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            //Se confirmar o resultado no banco de dados, irá definir os valores dos atributos
            
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            //Exceção capturada
        }
        return result;
    }
}
// fim da classe