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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author kk
 */
public class NonCafeFormController implements Initializable {
    @FXML
    private TableColumn<NonCafe , String> id;
    @FXML
    private TableColumn<NonCafe , String> fname;
    @FXML
    private TableColumn<NonCafe , String> lname;
    @FXML
    private TableColumn<NonCafe , String> year;
    @FXML
    private TableColumn<NonCafe , String> semester;
    @FXML
    private TableColumn<NonCafe , String> dept;
    @FXML
    private TableColumn<NonCafe , String> accNum;
    @FXML
    private TableView<NonCafe> nonCafeTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void init(){
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        semester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        accNum.setCellValueFactory(new PropertyValueFactory<>("accNum"));
   
        
}
    ObservableList<NonCafe> listView = FXCollections.observableArrayList();
    private void refresh_table(){
        init();
         try {
            Connection con = createCon();
            Statement s = con.createStatement();
            
            ResultSet rs  = s.executeQuery("SELECT * FROM student");
            listView.clear();

            while ( rs.next()){
                listView.add(new NonCafe( rs.getInt("id") ,
                          rs.getString("fname") 
                         , rs.getString("lname") 
                        , rs.getString("dept") , rs.getInt("year") ,  rs.getInt("semester") ,
                        rs.getInt("accNo")));
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentViewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       nonCafeTable.setItems(listView);
    }

    @FXML
    private void studentMenu(ActionEvent event) {
        SceneChanger sc = new SceneChanger();
        sc.changeScene("Settings.fxml");
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
