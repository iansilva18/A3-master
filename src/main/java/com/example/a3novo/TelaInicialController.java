package com.example.a3novo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


import java.io.IOException;

public class TelaInicialController {

    @FXML
    private void irParaCadastroPaciente() throws IOException {
        HelloApplication.changeScene("Cadastro.fxml");
    }

    @FXML
    private void irParaCadastroMedico() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadastroMedico.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        HelloApplication.changeScene("CadastroMedico.fxml");

    }
    }

