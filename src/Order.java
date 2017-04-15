import java.util.HashMap;
import java.util.Map;

/**
 * Заказ
 */
public class Order {
    /**
     * Добавляет одно блюдо в заказ.
     *
     * todo Сначала написать тесты!
     *
     *
     * @param meal блюдо из меню
     */
    private Map<Meal,Integer> map;

    public Order() {
        map = new HashMap<>();
    };

    public void addMeal(Meal meal,int count){
        if (meal !=null){
            Menu menu = new Menu();
            if (menu.list().contains(meal)){
                if (map.containsKey(meal)) {
                    map.put(meal,count+map.get(meal));
                }else{
                    map.put(meal,count);
                }
            }else{
                throw new IllegalArgumentException();
            }
        }else{
            throw new IllegalArgumentException();
        }

    }

    //todo добавить возможность добавления нескольких порций  одного блюда, например, два чая.
    //todo чтобы можно было сделать, например, addMeal(teaMeal, 2)
    //todo TESTS!


    /**
     * Возвращает сумму заказа, суммирующая цены каждого блюда,
     * умноженные на количество каждого блюда в заказе.
     *
     * @return сумму заказа в у.е., число с плавающей точкой
     */
    public double totalSum(){
        double count=0;
        for (Meal meal: map.keySet()) {
        count+=meal.getPrice()*map.get(meal);
        }
        return count;
    }
}
