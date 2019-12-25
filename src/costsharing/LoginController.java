/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costsharing;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static costsharing.DbConnection.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 *
 * @author kk
 */



public class LoginController implements Initializable {
    
    private Label label;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    
    public class UserAccount{
    String uName;
    String pass;
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con = createCon();
            Statement st = con.createStatement();
             //st.executeUpdate("CREATE SCHEMA IF NOT EXISTS db");
            
            st.executeUpdate("CREATE TABLE IF NOT EXISTS TEST(id INT AUTO_INCREMENT, username VARCHAR(20) NOT NULL , password VARCHAR(20) NOT NULL)");
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void login(ActionEvent event) {
        try {
            Connection con = createCon();
            Statement st = con.createStatement();
            UserAccount ua = new UserAccount();
            ua.uName = username.getText();
            ua.pass = password.getText();
        SceneChanger sc = new SceneChanger();
        sc.changeScene("Home.fxml");
        
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
