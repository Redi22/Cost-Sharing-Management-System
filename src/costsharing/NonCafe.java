/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costsharing;

/**
 *
 * @author kk
 */
public class NonCafe {
    int id;
    String fname, lname , dept;
    int year , semester , accNum;

    public NonCafe(int id, String fname, String lname, String dept, int year, int semester, int accNum) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.dept = dept;
        this.year = year;
        this.semester = semester;
        this.accNum = accNum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDept() {
        return dept;
    }

    public int getYear() {
        return year;
    }

    public int getSemester() {
        return semester;
    }

    public int getAccNum() {
        return accNum;
    }
    
}
