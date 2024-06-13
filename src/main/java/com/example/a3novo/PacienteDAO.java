package com.example.a3novo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO {
    // Método para inserir um paciente no banco de dados
    public void inserirPaciente(Paciente paciente) throws SQLException {
        // SQL para inserir um paciente
        String sql = "INSERT INTO Paciente (nome, numero_emergencia, data_nascimento, idade, altura, peso) VALUES (?, ?, ?, ?, ?, ?)";

        // Tente obter uma conexão e executar a instrução SQL
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getNumeroEmergencia());
            stmt.setDate(3, java.sql.Date.valueOf(paciente.getDataNascimento()));
            stmt.setInt(4, paciente.getIdade());
            stmt.setDouble(5, paciente.getAltura());
            stmt.setDouble(6, paciente.getPeso());

            // Execute a atualização
            stmt.executeUpdate();
        }
    }
}
