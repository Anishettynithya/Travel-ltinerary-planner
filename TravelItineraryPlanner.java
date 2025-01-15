
import java.util.*;

class ItineraryItem {
    private String location;
    private String date;
    private String activity;

    public ItineraryItem(String location, String date, String activity) {
        this.location = location;
        this.date = date;
        this.activity = activity;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Location: " + location + ", Activity: " + activity;
    }
}

class TravelItineraryPlanner {
    private List<ItineraryItem> itinerary;

    public TravelItineraryPlanner() {
        this.itinerary = new ArrayList<>();
    }

    public void addItem(String location, String date, String activity) {
        itinerary.add(new ItineraryItem(location, date, activity));
    }

    public void viewItinerary() {
        System.out.println("\nYour Travel Itinerary:");
        for (ItineraryItem item : itinerary) {
            System.out.println(item);
        }
    }

    public void removeItem(String location, String date) {
        Iterator<ItineraryItem> iterator = itinerary.iterator();
        while (iterator.hasNext()) {
            ItineraryItem item = iterator.next();
            if (item.getLocation().equals(location) && item.getDate().equals(date)) {
                iterator.remove();
                System.out.println("Removed: " + item);
                return;
            }
        }
        System.out.println("Item not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelItineraryPlanner planner = new TravelItineraryPlanner();

        while (true) {
            System.out.println("\nTravel Itinerary Planner");
            System.out.println("1. Add Item");
            System.out.println("2. View Itinerary");
            System.out.println("3. Remove Item");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter date (e.g., 2025-01-15): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter activity: ");
                    String activity = scanner.nextLine();
                    planner.addItem(location, date, activity);
                    break;
                case 2:
                    planner.viewItinerary();
                    break;
                case 3:
                    System.out.print("Enter location to remove: ");
                    String removeLocation = scanner.nextLine();
                    System.out.print("Enter date of the activity to remove: ");
                    String removeDate = scanner.nextLine();
                    planner.removeItem(removeLocation, removeDate);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
