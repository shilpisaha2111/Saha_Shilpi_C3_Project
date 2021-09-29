import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    //All object and variable as added in this section to refactor the code
    Restaurant restaurant;
    LocalTime openingTime;
    LocalTime closingTime;
    int initialMenuSize;
    List<String> itemNameList = new ArrayList<>();


    //REFACTOR ALL THE REPEATED LINES OF CODE
    @BeforeEach
    void setUp() {
        openingTime = LocalTime.parse("10:30:00");
        closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
        initialMenuSize = restaurant.getMenu().size();


    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //changed the timing to test the open/close time a particular restaurant
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        openingTime = LocalTime.parse("10:30:00");
        closingTime = LocalTime.parse("22:00:00");
        restaurant = new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        assertTrue( restaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        openingTime = LocalTime.parse("10:30:00");
        closingTime = LocalTime.parse("12:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        assertFalse( restaurant.isRestaurantOpen());

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
         assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //test cases added to count the total order value
    @Test
    public void adding_all_items_bill_should_show_total_Order_Value(){

        itemNameList.add("Sizzling brownie");
        itemNameList.add("Sizzling");
        itemNameList.add("brownie1");

        restaurant.addToMenu("Sizzling brownie",319);
        restaurant.addToMenu("brownie",519);
        restaurant.addToMenu("Sizzling",219);
        restaurant.addToMenu("Sizzl",119);
        restaurant.addToMenu("brownie1",419);

        assertEquals(957,restaurant.totalOrderValue(itemNameList));
    }

    @Test
    public void adding_all_items_bill_should_not_match_total_Order_Value(){
        //adding values in menu item arraylist
        itemNameList.add("Sizzling brownie");
        itemNameList.add("Sizzling");
        itemNameList.add("brownie1");

        restaurant.addToMenu("Sizzling brownie",319);
        restaurant.addToMenu("brownie",519);
        restaurant.addToMenu("Sizzling",219);
        restaurant.addToMenu("Sizzl",119);
        restaurant.addToMenu("brownie1",419);

        assertNotEquals(800,restaurant.totalOrderValue(itemNameList));
    }


}