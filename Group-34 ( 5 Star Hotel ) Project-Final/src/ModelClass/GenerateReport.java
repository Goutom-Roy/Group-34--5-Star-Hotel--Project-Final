package ModelClass;

public class GenerateReport {
    private String reportName;
    private String reportDetails;

    public GenerateReport(String reportName, String reportDetails) {
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

    @Override
    public String toString() {
        return "GenerateReport{" +
                "reportName='" + reportName + '\'' +
                ", reportDetails='" + reportDetails + '\'' +
                '}';
    }
}
