/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costsharing;

import java.time.LocalDate;

/**
 *
 * @author kk
 */
public class TableModel {
    int id;
    LocalDate dob ;
    String  fullname , gender  , region , zone , woreda , town , kebele, hno , phone;

    public TableModel(int id, LocalDate dob, String fullname, String gender, String region, String zone, String woreda, String town, String kebele, String hno, String phone) {
        this.id = id;
        this.dob = dob;
        this.fullname = fullname;
        this.gender = gender;
        this.region = region;
        this.zone = zone;
        this.woreda = woreda;
        this.town = town;
        this.kebele = kebele;
        this.hno = hno;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getFullname() {
        return fullname;
    }

    public String getGender() {
        return gender;
    }

    

    public String getRegion() {
        return region;
    }

    public String getZone() {
        return zone;
    }

    public String getWoreda() {
        return woreda;
    }

    public String getTown() {
        return town;
    }

    public String getKebele() {
        return kebele;
    }

    public String getHno() {
        return hno;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setRegion(String region) {
        this.region = region;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setWoreda(String woreda) {
        this.woreda = woreda;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }

    public void setHno(String hno) {
        this.hno = hno;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   
    
     
}
