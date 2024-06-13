package com.example.a3novo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CadastroMedicoController {

    @FXML
    private TextField nomeMedicoField;

    @FXML
    private TextField especialidadeField;

    @FXML
    private TextField crmField;

    @FXML
    private void voltar() {
        try {
            HelloApplication.changeScene("TelaInicial.fxml"); // Substitua "TelaAnterior.fxml" pelo nome do arquivo FXML da tela anterior
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Outros campos e métodos necessários para o cadastro de médico

    @FXML
    protected void salvarCadastroMedico() throws IOException {
        String nome = nomeMedicoField.getText();
        String especialidade = especialidadeField.getText();
        String crm = crmField.getText();

        // Salve os dados do médico conforme necessário

        // Exemplo: exibir os dados na saída
        System.out.println("Nome do Médico: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("CRM: " + crm);

        // Exibir uma mensagem de confirmação
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro de Médico");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro de médico salvo com sucesso!");
        alert.showAndWait();
        HelloApplication.changeScene("Historico.fxml");
    }

}
