/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.time.LocalDate;

/**
 *
 * @author gouto
 */
public class Project {
   public String name ;
   public LocalDate dateline;
   public  String detail ;

    public Project(String name, LocalDate dateline, String detail) {
        this.name = name;
        this.dateline = dateline;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateline() {
        return dateline;
    }

    public void setDateline(LocalDate dateline) {
        this.dateline = dateline;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
   
   
   
    
}
