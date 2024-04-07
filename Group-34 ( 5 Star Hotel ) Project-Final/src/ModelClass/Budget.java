/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

/**
 *
 * @author gouto
 */
public class Budget {
    
    private double totalBudget;
    private double expenses;
    private double revenue;
    private int year;

    public Budget(double totalBudget, double expenses, double revenue, int year) {
        this.totalBudget = totalBudget;
        this.expenses = expenses;
        this.revenue = revenue;
        this.year = year;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

  
    
}
