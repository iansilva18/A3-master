package com.example.a3novo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    // URL do banco de dados, incluindo o nome do banco
    private static final String URL = "jdbc:mysql://localhost:3306/clinica_medica"; // substitua "clinica_medica" pelo nome do seu banco de dados
    // Nome de usuário do banco de dados
    private static final String USER = "root"; // substitua "seu_usuario" pelo seu usuário do MySQL
    // Senha do banco de dados
    private static final String PASSWORD = "q1w2e3"; // substitua "sua_senha" pela sua senha do MySQL

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
