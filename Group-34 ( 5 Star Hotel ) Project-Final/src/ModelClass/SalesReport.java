

package ModelClass;



public class SalesReport {
    private String reportName;
    private String reportDetails;

 
    public SalesReport(String reportName, String reportDetails) {
        this.reportName = reportName;
        this.reportDetails = reportDetails;
    }

  
    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }
    
    
    
}