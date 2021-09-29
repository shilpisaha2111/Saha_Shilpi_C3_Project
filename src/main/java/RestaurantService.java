import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    //compares the restaurant name passed in the parameter , if it finds , it returns the restaurant object
    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        for(Restaurant restaurant: restaurants) {
            String name = restaurant.getName();
            if (name.equals(restaurantName))
                return restaurant;
        }
           throw new restaurantNotFoundException(restaurantName);
        }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

}
