/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costsharing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author kk
 */
public class SceneChanger {
    public void changeScene(String s){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
            try {
                Parent root = (Parent) loader.load();
                CostSharing.stage.setScene( new Scene(root));
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
