package ModelClass;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ManageDiscount {
    private final StringProperty name;
    private final DoubleProperty amount;
    private final StringProperty status;

    public ManageDiscount(String name, double amount, String status) {
        this.name = new SimpleStringProperty(name);
        this.amount = new SimpleDoubleProperty(amount);
        this.status = new SimpleStringProperty(status);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getAmount() {
        return amount.get();
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    @Override
    public String toString() {
        return "ManageDiscount{" +
                "name=" + name.get() +
                ", amount=" + amount.get() +
                ", status=" + status.get() +
                '}';
    }
}
