import java.util.ArrayList;
import java.util.List;


/**
 * Заказ
 */
public class Order {

    private List<Meal> order;
    private List<Integer> amount;


    public Order() {
       order = new ArrayList<>();
       amount = new ArrayList<>();
    }

    /**
     * Добавляет одно блюдо в заказ.
     *
     * @param meal блюдо из меню
     */
    public void addMeal(Meal meal) {
        if (Menu.list().contains(meal)) {
            if (meal != null)
                if (!order.contains(meal)) {
                    order.add(meal);
                    amount.add(1);
                } else amount.set(order.indexOf(meal), amount.get(order.indexOf(meal)) + 1);
        }
        else throw new IllegalArgumentException();
    }

    public void addMeal(Meal meal, int number) {
        if (Menu.list().contains(meal)) {
            if (meal != null)
                if (!order.contains(meal)) {
                    order.add(meal);
                    amount.add(number);
                } else amount.set(order.indexOf(meal), amount.get(order.indexOf(meal)) + number);
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
            for (int i=0; i<order.size();i++)
                sum=sum+order.get(i).getPrice()*amount.get(i);
            return sum;
        }

}
