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
public class PaymentController implements Initializable {
    @FXML
    private TextField nonAccNo;
    @FXML
    private TextField nonDept;
    @FXML
    private TextField nonYear;
    @FXML
    private TextField nonSemester;
    @FXML
    private TextField nonCafeId;
    @FXML
    private TextField nonLname;
    @FXML
    private TextField nonFname;
    @FXML
    private Button makeNon;
    @FXML
    private TextField payReciNum;
    @FXML
    private TextField payDept;
    @FXML
    private TextField payId;
    @FXML
    private TextField payLname;
    @FXML
    private TextField payFname;
    @FXML
    private Button delete1;
    @FXML
    private TextField payAmount;
    @FXML
    private Button adminView;
    @FXML
    private Button startSeme;
 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void makeNonCafe(ActionEvent event) {
        try {
            Connection con = createCon();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from student where STUID = " + nonCafeId.getText());
            while(r.next()){
            con.createStatement().executeUpdate("insert into noncafe (fname , lname, year , semester , dept , stuId , accno) values ( '" + nonFname.getText() + "' , '" + nonLname.getText() + "' , " + nonYear.getText() + " , " + nonSemester.getText() + " , '" + nonDept.getText() + "' , " + r.getInt("stuid") + " , " + nonAccNo.getText() + ")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void makePayment(ActionEvent event) {
        
         try {
            Connection con = createCon();
            Statement s = con.createStatement();
            int debit  = 0;
            ResultSet r = s.executeQuery("select * from student where STUID = " + payId.getText());
            while(r.next()){
            con.createStatement().executeUpdate("insert into payment (fname , lname , dept , recinum , amount , stuId) values ( '" + payFname.getText() + "' , '" + payLname.getText() + "' , '" + payDept.getText() + "', " + payReciNum.getText() + " , " + payAmount.getText() + " , " + r.getInt("stuid") + " ) " );
            ResultSet rs = con.createStatement().executeQuery("select * from student where stuid = " + payId.getText());
            while(rs.next()){
                debit = rs.getInt("debit");
                debit -= Integer.parseInt(payAmount.getText());
                con.createStatement().executeUpdate("update student set debit = " + debit +" where STUID = " + payId.getText());
            
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @FXML
    private void semesStart(ActionEvent event) {
        
        try {
            Connection con = createCon();
            Statement s = con.createStatement();
           
            ResultSet rs = con.createStatement().executeQuery("select * from student" );
            while(rs.next()){
                
                ResultSet rse = con.createStatement().executeQuery("select * from signin");
                while(rse.next()){
                    if(rs.getInt("CurrSemester") <= rse.getInt("semesterlimit")){
                int fee =  rse.getInt("foodfee") +  rse.getInt("boardingfee");
                con.createStatement().executeUpdate("update student set debit = " + fee );
                int curr = rs.getInt("currsemester") + 1;
                con.createStatement().executeUpdate("update student set currsemester = " + curr + " where stuid = " + rs.getInt("stuid"));
                    }
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void studenMenu(ActionEvent event) {
         SceneChanger sc = new SceneChanger();
        sc.changeScene("StudentViews.fxml");
    }

    @FXML
    private void serviceMenu(ActionEvent event) {
         SceneChanger sc = new SceneChanger();
        sc.changeScene("Settings.fxml");
    }

    @FXML
    private void adminMenu(ActionEvent event) {
         SceneChanger sc = new SceneChanger();
        sc.changeScene("AdminCreatePage.fxml");
    }

   

   
}
