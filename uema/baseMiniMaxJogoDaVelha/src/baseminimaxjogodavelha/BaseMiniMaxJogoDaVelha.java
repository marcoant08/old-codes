/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseminimaxjogodavelha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author MarcoAntônio
 */
public class BaseMiniMaxJogoDaVelha extends Application{

    /**
     * @param args the command line arguments
     */
     @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Jogo da Velha com Minimax");
        stage.setScene(scene);
        stage.show();
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
