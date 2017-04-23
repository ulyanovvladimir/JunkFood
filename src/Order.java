import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Заказ
 */
public class Order {

    // private List<Meal> order;
    // private List<Integer> amount;
    //fix
    private Map<Meal,Integer> order;

//fix
    public Order() {
        //  order = new ArrayList<>();
        //amount = new ArrayList<>();
        order = new HashMap<>();

    }

    /**
     * Добавляет одно блюдо в заказ.
     *
     * @param meal блюдо из меню
     */
    public void addMeal(Meal meal) {
        if (Menu.contains(meal)) {
            if (meal != null)
              /*  if (!order.contains(meal)) {
                    order.add(meal);
                    amount.add(1);
                } else amount.set(order.indexOf(meal), amount.get(order.indexOf(meal)) + 1);
        }*/
                //fix
                if (!order.containsKey(meal)) order.put(meal, 1);
                else order.put(meal, order.get(meal) + 1);
        }
        else throw new IllegalArgumentException();
    }

    public void addMeal(Meal meal, int number) {
        if (Menu.contains(meal)) {
            if (meal != null)
             /*   if (!order.contains(meal)) {
                    order.add(meal);
                    amount.add(number);
                } else amount.set(order.indexOf(meal), amount.get(order.indexOf(meal)) + number);*/
                //fix
                if (!order.containsKey(meal)) order.put(meal, number);
                else order.put(meal, order.get(meal) + number);
        }
        else throw new IllegalArgumentException();
    }
    /**
     * Возвращает сумму заказа, суммирующая цены каждого блюда,
     * умноженные на количество каждого блюда в заказе.
     *
     * @return сумму заказа в у.е., число с плавающей точкой
     */

    public Float totalSum() {
        Float sum=0f;
        //  for (int i=0; i<order.size();i++)
        //      sum=sum+order.get(i).getPrice()*amount.get(i);
        //fix
        for (Map.Entry<Meal, Integer> d: order.entrySet()) sum = sum+d.getKey().getPrice()*d.getValue();
        return sum;
    }

}
