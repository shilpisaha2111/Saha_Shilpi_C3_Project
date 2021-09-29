import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    // Restaurant is open or not is compared with the current time , if before or after it is open , else closed
    public boolean isRestaurantOpen() {
        if(openingTime.isBefore(this.getCurrentTime())  &&  closingTime.isAfter(this.getCurrentTime()))
        return true;
        else
            return false;
        }
   // method to find the current time - used to compare with the open and closed time
    public LocalTime getCurrentTime()
    {
        return  LocalTime.now();
    }

    //returns the list of menu added in the app
    public List<Item> getMenu() {
        return this.menu;
            }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

    // assignment part 3 - method to get price of each item from the Item class
    public int totalOrderValue(List<String> itemNameList){
        int orderTotal = 0;
        /*for(String itemName: itemNameList) {
            Item item_Name = findItemByName(itemName);
            orderTotal += item_Name.getPrice();
        }*/
        return orderTotal;
    }
}
