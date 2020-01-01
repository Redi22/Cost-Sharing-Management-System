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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
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
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con = createCon();
            Statement st = con.createStatement();
            st.executeUpdate("CREATE SCHEMA IF NOT EXISTS db");
            con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS admin(id INT AUTO_INCREMENT, username VARCHAR(30) NOT NULL , password VARCHAR(30) NOT NULL)");
            con.createStatement().executeUpdate("create table if not exists student ( stuid  int auto_increment , fname VARCHAR(30) NOT NULL , mname VARCHAR(30) NOT NULL , lname VARCHAR(30) NOT NULL , gender VARCHAR(30) NOT NULL , dob date NOT NULL, region VARCHAR(30) NOT NULL , zone VARCHAR(30) NOT NULL , woreda  VARCHAR(30) NOT NULL , town VARCHAR(30) NOT NULL , kebele  VARCHAR(30) NOT NULL , hno VARCHAR(30) NOT NULL ,pno VARCHAR(30) NOT NULL , pobox VARCHAR(30) NOT NULL , intranceyear int NOT NULL , debit int not null , currsemester int not null)");
            con.createStatement().executeUpdate("create table if not exists Adopter ( id int auto_increment , fname varchar(30) not null , lname varchar(30) not null , region varchar(30) not null , zone varchar(30) not null , woreda varchar(30) not null , kebele varchar(30) not null , town varchar(30) not null , hno varchar(30) not null  , pno varchar(30) not null , stuid int) ");
            con.createStatement().executeUpdate("alter table adopter add foreign key ( stuid ) references student ( stuid )");
            con.createStatement().executeUpdate("create table if not exists withdraw ( withid int auto_increment , semester int not null , withdate date not null, stuid int)");
            con.createStatement().executeUpdate("alter table withdraw add foreign key ( stuid ) references student ( stuid )");
            con.createStatement().executeUpdate("create table if not exists signin( id int auto_increment , univname varchar (100) not null , foodfee int not null, bordingfee int not null , semesterlimit int not null ) ");
            con.createStatement().executeUpdate("create table if not exists payment( id int auto_increment , fname varchar (30) not null , lname varchar (30) not null  , dept varchar (100) not null  , recinum int  not null , amount int not null , stuid int ) ");
            con.createStatement().executeUpdate("alter table payment add foreign key ( stuid ) references student ( stuid )");
            con.createStatement().executeUpdate("create table if not exists transfered (TRANID int auto_increment , UNIVNAME varchar(100) not null ,COLLEGE varchar(100) not null  ,DEPT varchar(100) not null , DOT date not null, SEMESTER int not null, TOTCOST int not null, STUDID int  )");
            con.createStatement().executeUpdate("alter table transfered add foreign key ( studid ) references student ( stuid )");
            con.createStatement().executeUpdate("create table if not exists noncafe (ID int auto_increment , FNAME varchar(30) not null  , LNAME varchar(30) not null  , year  int not null , semester int not null ,  dept varchar(100) not null , accno int not null , stuid int )");
            con.createStatement().executeUpdate("alter table noncafe add foreign key ( stuid ) references student ( stuid )");

        } catch (SQLException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

//    @FXML
//    private void login(ActionEvent event) {
////        try {
////            Connection con = createCon();
////            Statement st = con.createStatement();
////            ResultSet rs = st.executeQuery("select * from admin where username = '" + username.getText() + "' and password = '" + password.getText() + "'");
////            
////            while(rs.next()){
////                    System.out.println(rs.getString("username") + "   " + rs.getString("password"));
////                    CostSharing.loggedUserId = rs.getInt("id");
////                    SceneChanger sc = new SceneChanger();
////                    sc.changeScene("Home.fxml");
////                
////                    
////            }
////        
////        
////        } catch (SQLException ex) {
////            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
////        }
//    }

    @FXML
    private void login(MouseEvent event) {
        try {
            Connection con = createCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from admin where username = '" + username.getText() + "' and password = '" + password.getText() + "'");
            
            while(rs.next()){
                    System.out.println(rs.getString("username") + "   " + rs.getString("password"));
                    CostSharing.loggedUserId = rs.getInt("id");
                    SceneChanger sc = new SceneChanger();
                    sc.changeScene("Home.fxml");
                
                    
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
