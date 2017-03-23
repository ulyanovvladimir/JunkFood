import java.util.*;

/**
 * Заказ
 */
public class Order {
    private List<Meal> order;
    private List<Integer> count;

    public Order() {
        order = new ArrayList<>();
        count = new ArrayList<>();
    }

    public void addMeal(Meal meal){
        if (Menu.contains(meal)) {
            if (meal != null) {
                if (!order.contains(meal)) {
                    order.add(meal);
                    count.add(1);
                } else count.set(order.indexOf(meal), count.get(order.indexOf(meal))+1);
            }
        } else throw new IllegalArgumentException();
    }

    public void addMeal(Meal m, int c) {
        if (Menu.contains(m)) {
            if (m != null) {
                if (!order.contains(m)) {
                    order.add(m);
                    count.add(c);
                } else count.set(order.indexOf(m), count.get(order.indexOf(m))+c);
            }
        } else throw new IllegalArgumentException();
    }

    public Float totalSum(){
        Float sum = 0F;
        for (int i=0; i<order.size(); i++) sum += order.get(i).getPrice()*count.get(i);
        return sum;
    }
}
