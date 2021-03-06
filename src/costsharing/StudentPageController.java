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
import javafx.scene.control.CheckBox;
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
    private TextField id;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton male;
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
    private TextField birthZone11;
    @FXML
    private TextField currentYearEntrance;
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
    @FXML
    private TextField phoneNum;
    @FXML
    private TextField adopLname;
    @FXML
    private TextField adopFname;
    @FXML
    private CheckBox with;
    @FXML
    private CheckBox tran;
    
    
 

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
            ResultSet rs = st.executeQuery("SELECT * FROM student WHERE stuid = " + CostSharing.stu_id );
            System.out.println(rs);
            while(rs.next()){
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
                
                ResultSet r = con.createStatement().executeQuery("select * from adopter where stuid = " + rs.getInt("stuid"));
                while(r.next()){
                adopFname.setText(r.getString("fname"));
                adopLname.setText(r.getString("lname"));
                birthZone11.setText(r.getString("region"));
                birthZone1.setText(r.getString("zone"));
                birthWoreda1.setText(r.getString("woreda"));
                phoneNum.setText(r.getString("pno"));
                birthTown1.setText(r.getString("town"));
                birthKebele1.setText(r.getString("kebele"));
                birthHno1.setText(r.getString("hno"));
                }
                
                ResultSet res = con.createStatement().executeQuery("select * from transfered where studid = " + rs.getInt("stuid"));
                while(res.next()){
                transUniver.setText(res.getString("univname"));
                college.setText(res.getString("college"));
                department.setText(res.getString("dept"));
                totalCost.setText("" + res.getInt("totcost"));
                transferSemester.setText("" +res.getInt("semester"));
                
                }
                
                ResultSet resu = con.createStatement().executeQuery("select * from withdraw where stuid = " + rs.getInt("stuid"));
                while(resu.next()){
                withdrawSemester.setText("" + resu.getInt("semester"));
                
                
                }
            }
            
            
           
            
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
            if(male.isSelected() == true){
                gender = "male";
            }
            LocalDate date = dob.getValue();
            st.executeUpdate("INSERT INTO Student (fname , mname , lname , gender  , dob , region , zone , woreda , town , kebele , hno , pno , pobox , intranceyear , currsemester) VALUES ('" + fname.getText() + "', '" + mname.getText()+ "', '" + lname.getText() + "', '" + gender + "', '" + date  + "', '" + regionBirth.getText() + "', '" + birthZone.getText() + "', '" + birthWoreda.getText() + "', '" + birthTown.getText() + "', '" + birthKebele.getText() + "', '" + birthHno.getText() + "', '" + PhoneNum.getText() + "', '" + pobox.getText() + "' ,  "+ currentYearEntrance.getText()+ ", 1)"); 
            
            ResultSet r = con.createStatement().executeQuery("select * from student where fname = '" + fname.getText() +"' and mname = '" + mname.getText() + "' and lname = '" + lname.getText() + "' and pno = '" + PhoneNum.getText() +"' ");
            while(r.next()){
            con.createStatement().executeUpdate("insert into adopter(fname , lname , region , zone ,woreda , kebele , town , hno , pno , STUID ) values ( '" + adopFname.getText() + "' , '" +  adopLname.getText() + "' , '" + birthZone11.getText() + "' , '" + birthZone1.getText() + "' , '" + birthWoreda1.getText() + "' , '" + birthKebele1.getText() + "' , '" + birthTown1.getText() + "' , '" + birthHno1.getText() + "' , '" + PhoneNum.getText() +  "', " + r.getInt("stuid") + ") ");
            
            if(with.isSelected() == true){
               con.createStatement().executeUpdate("insert into withdraw(semester , withdate  , stuId) values ( " + withdrawSemester.getText() + " , '" + withdrawDate.getValue() + "' , " + r.getInt("stuid") + ")");
            }
            if(tran.isSelected()){
            con.createStatement().executeUpdate("insert into transfered (univname , college , dept , dot , semester , totcost , studid) values ('" + transUniver.getText() + "' , '" + college.getText() + "' , '" +department.getText()   + "' , '" +transferDate.getValue() + "' , " +transferSemester.getText() + " , " +  totalCost.getText() +  ", " + r.getInt("stuid") + ")" );
                 }
            }
            
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
            long id_searched = CostSharing.stu_id;
            ResultSet rs = st.executeQuery("SELECT * FROM Student WHERE id =  " + id_searched);
            while (rs.next()){
               st2.executeUpdate("UPDATE Student SET fname = '" + fname.getText() +  "' ,  mname  = '"  + mname.getText() + "' ,  lname = '" + lname.getText() +  "' ,  region = '"  + regionBirth.getText() + "' , zone = '" + birthZone.getText() +  "' ,  town  = '"  + birthTown.getText() +  "' ,  kebele  = '"  + birthKebele.getText() + "' ,  hno  = '"  + birthHno.getText() + "' ,  pno  = '"  + PhoneNum.getText() + "' ,  pobox  = '"  +  pobox.getText() + "' WHERE id = " + id_searched + " ");
               con.createStatement().executeUpdate("update adopter set fname = '" + fname.getText() +  "' ,  mname  = '"  + mname.getText() + "' , region = '" + birthZone11.getText() + "' , zone = '" + birthZone1.getText() + "' , woreda = '" + birthWoreda1.getText() + "' kebele = '" + birthKebele1.getText() + "' , town = '" + birthTown1.getText() + "' , hno ='" + birthHno1.getText() + "' , pno= '" + phoneNum.getText() + "' where stuid = " +  id_searched + "");
               con.createStatement().executeUpdate("update withdraw set semester = " + withdrawSemester.getText() + " , withdate = '" + withdrawDate.getValue()+"' where stuid = " + id_searched);
               con.createStatement().executeUpdate("update transfered set univname ='" + transUniver.getText() + "' , college = '" + college.getText() + "' , dept ='" + department.getText() + "' , dot ='" + transferDate.getValue() + "' , semester = " + transferSemester.getText() + " , totcost =" + totalCost.getText() +" , where studid = " + id_searched );
                   
               
               
               
               
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

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

    @FXML
    private void female_checked(ActionEvent event) {
        male.setSelected(false);
    }

    @FXML
    private void male_checked(ActionEvent event) {
        female.setSelected(false);
    }
    
}
