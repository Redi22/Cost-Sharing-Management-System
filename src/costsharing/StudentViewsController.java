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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author kk
 */
public class StudentViewsController implements Initializable {
    @FXML
    private TableColumn<TableModel , String> fullname;
    @FXML
    private TableColumn<TableModel , String> gender;
    @FXML
    private TableColumn<TableModel , String> dob;
    @FXML
    private TableColumn<TableModel , String> region;
    @FXML
    private TableColumn<TableModel , String> town;
    @FXML
    private TableColumn<TableModel , String> woreda;
    @FXML
    private TableColumn<TableModel , String> kebele;
    @FXML
    private TableColumn<TableModel , String> hno;
    @FXML
    private TableColumn<TableModel , String> phone;
    @FXML
    private TableColumn<TableModel , String> id_view;
    @FXML
    private TableColumn<TableModel , String> zone;

    /**
     * Initializes the controller class.
     */
    ObservableList<TableModel> listView = FXCollections.observableArrayList();
    @FXML
    private TableView<TableModel> studentTable;
    @FXML
    private Button delete;
    @FXML
    private Button updateRedirect;
    @FXML
    private Button registerRedirect;
    @FXML
    private TextField searchId;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh_table();
        
        // TODO
    }    
private void init(){
    id_view.setCellValueFactory(new PropertyValueFactory<>("id"));
        fullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        region.setCellValueFactory(new PropertyValueFactory<>("region"));
        town.setCellValueFactory(new PropertyValueFactory<>("town"));
        woreda.setCellValueFactory(new PropertyValueFactory<>("woreda"));
        zone.setCellValueFactory(new PropertyValueFactory<>("zone"));
        kebele.setCellValueFactory(new PropertyValueFactory<>("kebele"));
        hno.setCellValueFactory(new PropertyValueFactory<>("hno"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone")); 
        
}
    @FXML
    private void deleteStu(ActionEvent event) {
         try {
            Connection con = createCon();
            Statement s = con.createStatement();
            int selId = studentTable.getSelectionModel().getSelectedItems().get(0).getId();
            con.createStatement().executeUpdate("delete from adopter where stuid = " + selId);
            con.createStatement().executeUpdate("delete from noncafe where stuid = " + selId);
            con.createStatement().executeUpdate("delete from payment where stuid = " + selId);
            con.createStatement().executeUpdate("delete from withdraw where stuid = " + selId);
            con.createStatement().executeUpdate("delete from transfered where studid = " + selId);
            
            s.executeUpdate("delete FROM student where stuid = " + selId);
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentViewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        refresh_table();
    }

    @FXML
    private void updateStu(ActionEvent event) {
        TableModel tablemodel =  studentTable.getSelectionModel().getSelectedItems().get(0);
        CostSharing.stu_id = tablemodel.getId();
        CostSharing.update = true;
        System.out.println(CostSharing.stu_id);
        SceneChanger sc = new SceneChanger();
        sc.changeScene("StudentPage.fxml");
    }
    @FXML
    private void registerStu(ActionEvent event) {
        SceneChanger sc = new SceneChanger();
        sc.changeScene("StudentPage.fxml");
    }
 

    @FXML
    private void search(ActionEvent event) {
            init();
        try {
            String fullname;
            Connection con = createCon();
            Statement s = con.createStatement();
            
            ResultSet rs  = s.executeQuery("SELECT * FROM student where fname = '" + searchId.getText() + "' ");
            listView.clear();
            while ( rs.next()){
                fullname = rs.getString("fname") + rs.getString("mname") + rs.getString("lname");
                listView.add(new TableModel( rs.getInt("stuid") , rs.getDate("dob").toLocalDate(),
                        fullname , rs.getString("gender") 
                         , rs.getString("region") 
                        , rs.getString("zone") , rs.getString("woreda") ,  rs.getString("town") ,
                        rs.getString("kebele") , rs.getString("hno") , 
                        rs.getString("pno")));
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentViewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void refresh(ActionEvent event) {
        refresh_table();
    }
public void refresh_table(){
    init();
        try {
            String fullname;
            Connection con = createCon();
            Statement s = con.createStatement();
            
            ResultSet rs  = s.executeQuery("SELECT * FROM student");
            listView.clear();

            while ( rs.next()){
                fullname = rs.getString("fname") + rs.getString("mname") + rs.getString("lname");
                listView.add(new TableModel( rs.getInt("stuid") , rs.getDate("dob").toLocalDate(),
                        fullname , rs.getString("gender") 
                         , rs.getString("region") 
                        , rs.getString("zone") , rs.getString("woreda") ,  rs.getString("town") ,
                        rs.getString("kebele") , rs.getString("hno") , 
                        rs.getString("pno")));
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentViewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        studentTable.setItems(listView);
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
