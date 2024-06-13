package com.example.a3novo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;


import java.io.IOException;

public class GlicemiaController {

    @FXML
    private TextField glicemiaField;
    @FXML
    private Button historicoButton;

    private Stage historicoStage;
    private HistoricoController historicoController;

    @FXML
    private void voltar() {
        try {
            HelloApplication.changeScene("Cadastro.fxml"); // Substitua "TelaAnterior.fxml" pelo nome do arquivo FXML da tela anterior
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        // Configura a janela do histórico ao inicializar o controlador

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/a3novo/Historico.fxml"));
            Parent root = loader.load();
            historicoController = loader.getController();

            historicoStage = new Stage();
            historicoStage.setScene(new Scene(root));
            historicoStage.initModality(Modality.APPLICATION_MODAL);
            historicoStage.setTitle("Histórico de Medições");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void salvarMedicao(ActionEvent event) {
        String glicemiaText = glicemiaField.getText();
        if (glicemiaText.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo vazio");
            alert.setContentText("Por favor, insira um valor de glicemia.");
            alert.showAndWait();
            return;
        }

        try {
            int glicemia = Integer.parseInt(glicemiaText);
            String resultado;

            if (glicemia < 70) {
                resultado = "Glicemia baixa: " + glicemia + " Sua glicemia está baixa. Considere fazer o seguinte:\\n\" +\n" +
                        "                        \"- Consuma 15-20 gramas de carboidratos de ação rápida (ex: suco de laranja, tabletes de glicose).\\n\" +\n" +
                        "                        \"- Meça sua glicemia novamente após 15 minutos.\\n\" +\n" +
                        "                        \"- Repita o consumo de carboidratos se necessário.\\n\" +\n" +
                        "                        \"- Consulte seu médico se sua glicemia não aumentar.";
            } else if (glicemia > 140) {
                resultado = "Glicemia alta: " + glicemia + " Sua glicemia está alta. Considere fazer o seguinte:\\n\" +\n" +
                        "                        \"- Tome insulina de ação rápida conforme prescrito pelo seu médico.\\n\" +\n" +
                        "                        \"- Faça exercícios físicos leves, como caminhar.\\n\" +\n" +
                        "                        \"- Beba bastante água.\\n\" +\n" +
                        "                        \"- Evite consumir alimentos ricos em carboidratos até sua glicemia baixar.";
            } else {
                resultado = "Glicemia normal: " + glicemia + " Sua glicemia está normal. Continue com sua dieta e rotina de cuidados conforme recomendado pelo seu médico.";
            }

            historicoController.adicionarMedicaoAoHistorico(resultado);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Resultado");
            alert.setHeaderText(null);
            alert.setContentText(resultado);
            alert.showAndWait();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Valor inválido");
            alert.setContentText("Por favor, insira um valor numérico válido.");
            alert.showAndWait();
        }
    }

    @FXML
    private void abrirHistorico(ActionEvent event) {
        historicoStage.show();

    }
}
