package Controll;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controll_Sobre_Nos {

    private Scene scene;
    private Stage palco;
    private Parent root;

    @FXML
    private Button Voltar_Button;

    public void voltar(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/Inicial_Page.fxml"));
        palco = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }// fim do metodo

}// fim da classe
