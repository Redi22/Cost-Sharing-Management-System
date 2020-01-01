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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author kk
 */
public class AdminCreatePageController implements Initializable {
    @FXML
    private TextField newUsername;
    @FXML
    private Button makeAdmin;
    @FXML
    private PasswordField Pass;
    @FXML
    private PasswordField newPass;
    @FXML
    private PasswordField confNewPass;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void makeAdmin(ActionEvent event) {
        try {
            Connection con = createCon();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from admin where id = " + CostSharing.loggedUserId);
            while(r.next()){
                if(r.getString("password").equals(Pass.getText()) == true){
                    if(newPass.getText().equals(confNewPass.getText())){
                        con.createStatement().executeUpdate("insert into admin(username, password ) values ( + '" + newUsername.getText() + "' , ' " + newPass.getText() + " ')");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminCreatePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
