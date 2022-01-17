package Controll;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Controll_InicialPage {

    private Scene scene;
    private Stage palco;
    private Parent root;

    @FXML
    private Button Iniciar_jogo_Button;

    @FXML
    private Button como_Jogar_Button;

    @FXML
    private Button sobreNos_Button;

    public void irPara_Iniciar_Jogo(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/Main_Game.fxml"));
        palco = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }

    public void ir_Sobre_Nos(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Sobre_Nos.fxml"));
        palco = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }

    public void Para_Como_Jogar(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Como_Jogar.fxml"));
        palco = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }

}
