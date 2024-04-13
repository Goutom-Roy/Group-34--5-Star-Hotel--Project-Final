
package ModelClass;

import java.time.LocalDate;


public class Analyze{


public class RevenueData {
    private LocalDate startDate;
    private LocalDate endDate;
    private String category;
    private double revenue;

    public RevenueData(LocalDate startDate, LocalDate endDate, String category, double revenue) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.revenue = revenue;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    

}


}