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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author kk
 */
public class HomeController implements Initializable {
    @FXML
    private Button student_menu;
    @FXML
    private Button services_menu;
    @FXML
    private Button admin_menu;
    @FXML
    private Button payment_menu;
    @FXML
    private AnchorPane dash;
    @FXML
    private Label student_list;
    @FXML
    private AnchorPane dash1;
    @FXML
    private Label student_list1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            Connection con = createCon();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from student where currsemester < 8");
            while(rs.next()){
                    student_list.setText("" + rs.getRow());
             
            }
            ResultSet r = con.createStatement().executeQuery("select * from student where currsemester > 8");
            while(r.next()){
                    student_list1.setText("" + rs.getRow());
             
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
