package ModelClass;

public class SalesPerformance {
    private String month;
    private int salesAmount;

    public SalesPerformance(String month, int salesAmount) {
        this.month = month;
        this.salesAmount = salesAmount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(int salesAmount) {
        this.salesAmount = salesAmount;
    }

    @Override
    public String toString() {
        return "SalesPerformance{" +
                "month='" + month + '\'' +
                ", salesAmount=" + salesAmount +
                '}';
    }
}
