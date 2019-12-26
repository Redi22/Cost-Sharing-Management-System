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
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author kk
 */
public class StudentPageController implements Initializable {
    @FXML
    private TextField fname;
    @FXML
    private TextField mname;
    @FXML
    private TextField lname;
    @FXML
    private TextField id;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton male;
    @FXML
    private MenuButton nationality;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField regionBirth;
    @FXML
    private TextField birthZone;
    @FXML
    private TextField birthWoreda;
    @FXML
    private TextField birthTown;
    @FXML
    private TextField birthKebele;
    @FXML
    private TextField birthHno;
    @FXML
    private TextField PhoneNum;
    @FXML
    private TextField pobox;
    @FXML
    private Button register;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
   
    
    private AnchorPane formPane;
    @FXML
    private TextField birthZone1;
    @FXML
    private TextField birthWoreda1;
    @FXML
    private TextField birthTown1;
    @FXML
    private TextField birthKebele1;
    @FXML
    private TextField birthHno1;
    @FXML
    private TextField pobox1;
    @FXML
    private TextField birthZone11;
    @FXML
    private TextField currentUnivName;
    @FXML
    private TextField currentYearEntrance;
    @FXML
    private TextField currentYear;
    @FXML
    private TextField withdrawSemester;
    @FXML
    private DatePicker withdrawDate;
    @FXML
    private TextField transUniver;
    @FXML
    private DatePicker transferDate;
    @FXML
    private TextField college;
    @FXML
    private TextField department;
    @FXML
    private TextField totalCost;
    @FXML
    private TextField transferSemester;
    
    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Connection con = createCon();
        try {
            Statement st = con.createStatement();
             if(CostSharing.update == true){
            ResultSet rs = st.executeQuery("SELECT * FROM student WHERE id == " + CostSharing.stu_id );
            fname.setText(rs.getString("fname"));
            mname.setText(rs.getString("mname"));
            lname.setText(rs.getString("lname"));
            regionBirth.setText(rs.getString("region"));
            birthZone.setText(rs.getString("zone"));
            birthWoreda.setText(rs.getString("woreda"));
            birthTown.setText(rs.getString("town"));
            birthKebele.setText(rs.getString("kebele"));
            birthHno.setText(rs.getString("hno"));
            PhoneNum.setText(rs.getString("pno"));
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }    

    @FXML
    private void registerStu(ActionEvent event) {
        Connection con = createCon();
        try {
            Statement st = con.createStatement();
            String gender = "female";
            LocalDate date = dob.getValue();
            String nalty = "ethiopian";
            st.executeUpdate("INSERT INTO Student (fname , mname , lname , gender , nationality , dob , region , zone , woreda , town , kebele , hno , pno , pobox) VALUES ('" + fname.getText() + "', '" + mname.getText()+ "', '" + lname.getText() + "', '" + gender + "', '" + nalty + "', '" + date  + "', '" + regionBirth.getText() + "', '" + birthZone.getText() + "', '" + birthWoreda.getText() + "', '" + birthTown.getText() + "', '" + birthKebele.getText() + "', '" + birthHno.getText() + "', '" + PhoneNum.getText() + "', '" + pobox.getText() + "' )");                                                     
        } catch (SQLException ex) {
            Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void updateStu(ActionEvent event) {
        try {
            Connection con = createCon();
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            String id_searched = id.getText();
            ResultSet rs = st.executeQuery("SELECT * FROM Student WHERE id =  " + id_searched);
            while (rs.next()){
                st2.executeUpdate("UPDATE Student SET fname = '" + fname.getText() +  "' ,  mname  = '"  + mname.getText() + "' ,  lname = '" + lname.getText() +  "' ,  region = '"  + regionBirth.getText() + "' , zone = '" + birthZone.getText() +  "' ,  town  = '"  + birthTown.getText() +  "' ,  kebele  = '"  + birthKebele.getText() + "' ,  hno  = '"  + birthHno.getText() + "' ,  pno  = '"  + PhoneNum.getText() + "' ,  pobox  = '"  +  pobox.getText() + "' WHERE id = " + id_searched + " ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void deleteStu(ActionEvent event) {
         try {
            Connection con = createCon();
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            String id_searched = id.getText();
            ResultSet rs = st.executeQuery("SELECT * FROM Student WHERE id =  " + id_searched);
            while (rs.next()){
                st2.executeUpdate("DELETE FROM Student WHERE id =  " + id_searched);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
