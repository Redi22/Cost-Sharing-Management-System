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

/**
 * FXML Controller class
 *
 * @author kk
 */
public class StudentViewsController implements Initializable {
    @FXML
    private TextField id;
    @FXML
    private TableColumn<TableModel , String> fullname;
    @FXML
    private TableColumn<TableModel , String> gender;
    @FXML
    private TableColumn<TableModel , String> nationality;
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
    private TableColumn<?, ?> zone;

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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id_view.setCellValueFactory(new PropertyValueFactory<>("id"));
        fullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        nationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));  
        dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        region.setCellValueFactory(new PropertyValueFactory<>("region"));
        town.setCellValueFactory(new PropertyValueFactory<>("town"));
        woreda.setCellValueFactory(new PropertyValueFactory<>("woreda"));
        zone.setCellValueFactory(new PropertyValueFactory<>("zone"));
        kebele.setCellValueFactory(new PropertyValueFactory<>("kebele"));
        hno.setCellValueFactory(new PropertyValueFactory<>("hno"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone")); 
        
        try {
            String fullname;
            Connection con = createCon();
            Statement s = con.createStatement();
            
            ResultSet rs  = s.executeQuery("SELECT * FROM student");
            
            while ( rs.next()){
                fullname = rs.getString("fname") + rs.getString("mname") + rs.getString("lname");
                listView.add(new TableModel( rs.getInt("id") , rs.getDate("dob").toLocalDate(),
                        fullname , rs.getString("gender") , rs.getString("nationality")
                         , rs.getString("region") 
                        , rs.getString("zone") , rs.getString("woreda") ,  rs.getString("town") ,
                        rs.getString("kebele") , rs.getString("hno") , 
                        rs.getString("pno")));
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentViewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        studentTable.setItems(listView);
        
        // TODO
    }    

    @FXML
    private void deleteStu(ActionEvent event) {
        
    }

    @FXML
    private void updateStu(ActionEvent event) {
        CostSharing.stu_id =Long.parseLong(studentTable.getSelectionModel().getSelectedCells().get(0).toString().split(",")[0].substring(1));
        SceneChanger sc = new SceneChanger();
        sc.changeScene("StudentPage.fxml");
    }
    @FXML
    private void registerStu(ActionEvent event) {
        SceneChanger sc = new SceneChanger();
        sc.changeScene("StudentPage.fxml");
    }
    
}
