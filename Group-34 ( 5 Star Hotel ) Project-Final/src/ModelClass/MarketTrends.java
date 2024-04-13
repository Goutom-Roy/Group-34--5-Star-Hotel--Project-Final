
package ModelClass;

public class MarketTrends {
    private String trendName;
    private String trendDescription;

    public MarketTrends(String trendName, String trendDescription) {
        this.trendName = trendName;
        this.trendDescription = trendDescription;
    }

    public String getTrendName() {
        return trendName;
    }

    public void setTrendName(String trendName) {
        this.trendName = trendName;
    }

    public String getTrendDescription() {
        return trendDescription;
    }

    public void setTrendDescription(String trendDescription) {
        this.trendDescription = trendDescription;
    }
    
   
    
}
