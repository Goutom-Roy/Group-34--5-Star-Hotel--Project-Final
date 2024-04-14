/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Analysis {
    private LocalDate date;
    private double totalSales;
    private String salesCatagory;
    private double avdTransaction;
    private float rating;

    public Analysis(LocalDate date, double totalSales, String salesCatagory, double avdTransaction, float rating) {
        this.date = date;
        this.totalSales = totalSales;
        this.salesCatagory = salesCatagory;
        this.avdTransaction = avdTransaction;
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public String getSalesCatagory() {
        return salesCatagory;
    }

    public void setSalesCatagory(String salesCatagory) {
        this.salesCatagory = salesCatagory;
    }

    public double getAvdTransaction() {
        return avdTransaction;
    }

    public void setAvdTransaction(double avdTransaction) {
        this.avdTransaction = avdTransaction;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Analysis{" + "date=" + date + ", totalSales=" + totalSales + ", salesCatagory=" + salesCatagory + ", avdTransaction=" + avdTransaction + ", rating=" + rating + '}';
    }
    

   

  
    
    
}
