

package ModelClass;

public class HelpCenter {
    private String helpCategory;
    private String helpName;
    private String helpDetails;

    public HelpCenter(String helpCategory, String helpName, String helpDetails) {
        this.helpCategory = helpCategory;
        this.helpName = helpName;
        this.helpDetails = helpDetails;
    }

    public String getHelpCategory() {
        return helpCategory;
    }

    public void setHelpCategory(String helpCategory) {
        this.helpCategory = helpCategory;
    }

    public String getHelpName() {
        return helpName;
    }

    public void setHelpName(String helpName) {
        this.helpName = helpName;
    }

    public String getHelpDetails() {
        return helpDetails;
    }

    public void setHelpDetails(String helpDetails) {
        this.helpDetails = helpDetails;
    }

    @Override
    public String toString() {
        return "HelpCenter{" +
                "helpCategory='" + helpCategory + '\'' +
                ", helpName='" + helpName + '\'' +
                ", helpDetails='" + helpDetails + '\'' +
                '}';
    }
}
