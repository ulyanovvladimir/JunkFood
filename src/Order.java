import java.util.ArrayList;
import java.util.List;

public class Order {
    public static List<Meal> NewOrder;
    public Order(){
        NewOrder = new ArrayList<>();
    }

    public void addMeal(Meal meal, int number){
        if (Menu.containsMeal(meal)){
            if (meal != null) {
                for (int i = 0; i < number; i++) {
                    NewOrder.add(meal);
                }
            }
        }
        else throw new IllegalArgumentException();

    }

    public Float totalSum(){
        Float total = 0.0F;
        for(Meal m : NewOrder){
            total = total + m.getPrice();
        }
        return total;
    }
}