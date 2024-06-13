package com.example.a3novo;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;

public class HistoricoController {

    @FXML
    private ListView<String> historicoListView;

    // Método para adicionar uma medição ao histórico
    public void adicionarMedicaoAoHistorico(String medicao) {
        historicoListView.getItems().add(medicao);
    }

    // Método para inicializar o controlador (opcional)
    @FXML
    private void initialize() {
        // Inicialização opcional, se necessário
    }



}
