package Controll;

//importacoes usadas em metodos
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//importacoes sobre FXML
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Controll_MainGame {

    @FXML
    private TextField Tam_TextField;

    @FXML
    private Button Animais_Button;

    @FXML
    private Button Cidade_Button;

    @FXML
    private Button ComeBack_Button;

    @FXML
    private Button Comida_Button;

    @FXML
    private Button Confirmar_Button;

    @FXML
    private TextField Tentativas_TextField;

    @FXML
    private TextField TryOut_TextField1;

    @FXML
    private Button Voltar_Button;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private ImageView corpo_Img;

    @FXML
    private ImageView perna_direita_img;

    @FXML
    private ImageView perna_esquerda_img;

    @FXML
    private ImageView braco_direito_Img;

    @FXML
    private ImageView braco_esquerdo_img;

    @FXML
    private ImageView cabeca_img;

    @FXML
    private Button Voltar_InicialPage;

    @FXML
    private AnchorPane anchorPane3;

    @FXML
    private Button TentarNovaemnte_Button;

    @FXML
    private TextField YouWin_TextField;

    @FXML
    private TextField GameOver_TextField;

    @FXML
    private TextField Palavra_TextField;

    @FXML
    private ArrayList<TextField> Char_TextField;

    private Scene scene;// usado na hora de trocar de tela
    private Stage palco;// usado na hora de trocar de tela
    private Parent root;// usado na hora de trocar de tela

    private int tentativas = 6;// usado para limitar a quantidade de vezes que o usuario erra palavras
    private String word;// palavra escolhida no random
    private int acertos = 0;

    private String[] cidades = new String[] { "praga", "montreal", "copenhague", "manchester", "madri", "lisboa",
            "itapetinga", "boston", "pequim", "budapeste", "roma", "istambul", "moscou", "recife", "matal" };
    // string de nomes de cidades

    private String[] animais = new String[] { "andorinha", "foca", "golfinho", "jaguar", "ovelha", "passaro",
            "vaca", "zebra", "cachorro", "hiena", "guaxinim", "lagarto", "sardinha", "urubu", "gato" };
    // string de nomes de animais

    private String[] comida = new String[] { "azeitona", "churrasco", "arroz", "mochi", "pamonha", "rapadura",
            "feijoada", "torta", "pitanga", "moqueca", "pudim", "tacos", "caldinho", "batata", "caipirinha" };
    // string de nomes de comida

    // inicializando o randorizador
    Random rand = new Random();

    @FXML
    public void animais_MainGame(ActionEvent event) {
        // trocar de tela
        anchorPane2.setVisible(true);
        anchorPane1.setVisible(false);
        anchorPane3.setVisible(false);

        // manter o boneco invisivel
        cabeca_img.setVisible(false);
        braco_direito_Img.setVisible(false);
        braco_esquerdo_img.setVisible(false);
        corpo_Img.setVisible(false);
        perna_direita_img.setVisible(false);
        perna_esquerda_img.setVisible(false);

        // escolher a palavra
        word = animais[rand.nextInt(animais.length)];
        getWord();

        // dar valor aos textfields que nao precisam de imput do user
        tentativas = 6;
        // caso a pessoa queria jogar de novo o numero de tentativas volta ao valor
        // inicial
        Tentativas_no_TextField();
        tamanho_Word();

        // esconder blocos nao usados
        esconder_quadrados();

        // limpar os elemntos dos blocos
        limpar_quadrados();
    }

    @FXML
    public void cidades_MainGame(ActionEvent event) {
        // trocar de tela
        anchorPane2.setVisible(true);
        anchorPane1.setVisible(false);
        anchorPane3.setVisible(false);

        // manter o boneco invisivel
        cabeca_img.setVisible(false);
        braco_direito_Img.setVisible(false);
        braco_esquerdo_img.setVisible(false);
        corpo_Img.setVisible(false);
        perna_direita_img.setVisible(false);
        perna_esquerda_img.setVisible(false);

        // escolher a palavra
        word = cidades[rand.nextInt(cidades.length)];
        getWord();

        // dar valor aos textfields que nao precisam de imput do user
        tentativas = 6;
        Tentativas_no_TextField();
        tamanho_Word();

        // esconder blocos nao usados
        esconder_quadrados();

        // limpar os elemntos dos blocos
        limpar_quadrados();
    }

    @FXML
    public void comida_MainGame(ActionEvent event) {
        // trocar de tela
        anchorPane2.setVisible(true);
        anchorPane1.setVisible(false);
        anchorPane3.setVisible(false);

        // manter o boneco invisivel
        cabeca_img.setVisible(false);
        braco_direito_Img.setVisible(false);
        braco_esquerdo_img.setVisible(false);
        corpo_Img.setVisible(false);
        perna_direita_img.setVisible(false);
        perna_esquerda_img.setVisible(false);

        // escolher a palavra
        word = comida[rand.nextInt(comida.length)];
        getWord();

        // dar valor aos textfields que nao precisam de imput do user
        tentativas = 6;
        Tentativas_no_TextField();
        tamanho_Word();

        // esconder blocos nao usados
        esconder_quadrados();

        // limpar os elemntos dos blocos
        limpar_quadrados();
    }

    @FXML
    public void comeBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/Inicial_Page.fxml"));
        palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }

    @FXML
    public void backInicialPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/Inicial_Page.fxml"));
        palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }

    public void TentarDenovo(ActionEvent event) {
        // troca de tela da forca para "Escolha sua Caracteristica"
        anchorPane2.setVisible(false);
        anchorPane1.setVisible(true);

        // permite que todos os TextField retorne para a visibilidade inicial
        aparecer_quadrados();
    }

    @FXML
    public void voltar(ActionEvent event) {
        // troca de tela da forca para "Escolha sua Caracteristica"
        anchorPane2.setVisible(false);
        anchorPane1.setVisible(true);

        // permite que todos os TextField retorne para a visibilidade inicial
        aparecer_quadrados();
    }

    public void getWord() {
        Palavra_TextField.setText(word);
        TryOut_TextField1.setText("");
    }

    public void Tentativas_no_TextField() {
        Tentativas_TextField.setText("" + tentativas);
    }

    public void tamanho_Word() {
        Tam_TextField.setText("" + word.length());
    }

    public void esconder_quadrados() {
        for (int i = word.length(); i < 12; i++) {
            Char_TextField.get(i).setVisible(false);
        }
    }

    public void aparecer_quadrados() {
        for (int i = 0; i < 12; i++) {
            Char_TextField.get(i).setVisible(true);
        }
    }

    public void limpar_quadrados() {
        for (int i = 0; i < 12; i++) {
            Char_TextField.get(i).setText(" ");
        }
    }

    // acoes que ocorrem no jogo

    public void imagem_Boneco() {
        switch (tentativas) {
            case 6: {
                cabeca_img.setVisible(true);
                break;
            } // fim do case 6
            case 5: {
                corpo_Img.setVisible(true);
                break;
            } // fim do case 5
            case 4: {
                braco_esquerdo_img.setVisible(true);
                break;
            } // fim do case 4
            case 3: {
                braco_direito_Img.setVisible(true);
                break;
            } // fim do case 3
            case 2: {
                perna_direita_img.setVisible(true);
                break;
            } // fim do case 2
            case 1: {
                perna_esquerda_img.setVisible(true);
                break;
            } // fim do case 1
        }
        tentativas--;
        Tentativas_no_TextField();
    }// fim do metodo imagem_Boneco

    /*
     * Metodo: setLetra
     * Funcao: relaciona a letra digitada pelo usuario com o TextField
     * correspondente
     * Parametros: Inteiro referente ao index em que a letra se encontra (index),
     * String correspondente a letra presente na palavra (letter)
     * Retorno: void
     */
    public void setLetra(int index, String letter) {// inicia o metodo
        Char_TextField.get(index).setText(letter);
    }// fim do metodo setLetra

    public void Confirmar() {
        String letter = TryOut_TextField1.getText();
        if (word.contains(letter)) {
            int index = 0;// posicao inicial de um array
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (String.valueOf(c).equals(letter)) {
                    acertos++;
                    setLetra(index, Character.toString(c));
                    TryOut_TextField1.setText("");
                } // fim do if
                index++;
            } // fim do for
        } // fim do if
        else {
            imagem_Boneco();
            if (tentativas == 0) {
                anchorPane3.setVisible(true);
            } // fim do if
        } // fim do else
        if (acertos == word.length() && tentativas != 0) {
            winOrLose();
        } // fim do if
    }// fim do metodo Confirmar

    public void winOrLose() {
        anchorPane3.setVisible(true);
        GameOver_TextField.setVisible(false);
    }// fim do metodo WinOrLose

}
