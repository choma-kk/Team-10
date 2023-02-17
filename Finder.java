import java.util.List;
import java.util.TreeSet;

public class Finder {
    private Customer customer;
    private final TreeSet<Driver> driversTreeSet = new TreeSet<>((d1, d2) ->
            d1.coordinate.calculateDistanceTo(customer.coordinate()) - d2.coordinate.calculateDistanceTo(customer.coordinate()));

    public Finder(Customer customer, List<Driver> drivers) {
        this.customer = customer;
        driversTreeSet.addAll(drivers);
    }

    public Driver getClosestFitting() {
        for (Driver driver : driversTreeSet) {
            if (driver.matchesConditions(customer)) {
                return driver;
            }
        }
        return null;
    }
}
