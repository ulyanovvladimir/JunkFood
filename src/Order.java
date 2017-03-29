import java.util.*;

/**
 * Заказ
 */
public class Order {
    private Map<Meal,Integer> ord;

    public Order() {
        ord = new HashMap<>();
    }

    public void addMeal(Meal meal){
        if (Menu.contains(meal)) {
            if (meal != null) {
                if (!ord.containsKey(meal)) ord.put(meal,1);
                else ord.put(meal,ord.get(meal)+1);
            }
        } else throw new IllegalArgumentException();
    }

    public void addMeal(Meal m, int c) {
        if (Menu.contains(m)) {
            if (m != null) {
                if (!ord.containsKey(m)) ord.put(m,c);
                else ord.put(m,ord.get(m)+c);
            }
        } else throw new IllegalArgumentException();
    }

    public Float totalSum(){
        Float sum = 0F;
        for (Map.Entry<Meal, Integer> e: ord.entrySet()) sum += e.getKey().getPrice()*e.getValue();
        return sum;
    }
}
