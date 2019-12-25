/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costsharing;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
