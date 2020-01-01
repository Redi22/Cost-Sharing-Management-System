/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costsharing;

import static costsharing.DbConnection.createCon;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kk
 */
public class SettingsController implements Initializable {
    @FXML
    private TextField newPass;
    @FXML
    private TextField confPass;
    @FXML
    private TextField username;
    @FXML
    private TextField currrPass;
    @FXML
    private Button changePass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changePassword(ActionEvent event) {
        try {
            Connection con = createCon();
            Statement s = con.createStatement();
            ResultSet res = s.executeQuery("select * from admin where id = " + CostSharing.loggedUserId);
            while(res.next()){
                if(res.getString("password").equals(currrPass.getText()) == true){
                    if(newPass.getText().equals(confPass.getText()) == true){
                        
                        con.createStatement().executeUpdate("UPDATE admin set password = '" + newPass.getText() + "' ");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void registeStu(ActionEvent event) {
        SceneChanger sc = new SceneChanger();
        sc.changeScene("StudentPage.fxml");
    }
    @FXML
    private void studentMenu(ActionEvent event) {
        SceneChanger sc = new SceneChanger();
        sc.changeScene("StudentViews.fxml");
    }
    @FXML
    private void servicesMenu(ActionEvent event) {
        SceneChanger sc = new SceneChanger();
        sc.changeScene("Settings.fxml");
    }
    @FXML
    private void adminMenu(ActionEvent event) {
        SceneChanger sc = new SceneChanger();
        sc.changeScene("AdminCreatePage.fxml");
    }
    @FXML
    private void paymentMenu(ActionEvent event) {
        SceneChanger sc = new SceneChanger();
        sc.changeScene("Payment.fxml");
    }
    
}
