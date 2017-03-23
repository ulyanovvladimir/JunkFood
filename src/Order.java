import java.util.ArrayList;
import java.util.List;

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
    private List<Meal> orderList;
    private List<Integer> count;
    private double totalcount = 0;

    public void addMeal(Meal meal,int count){
        if (this.orderList == null){
            this.orderList = new ArrayList<>();
            this.count = new ArrayList<>();
        }
        if (meal !=null){
            Menu menu = new Menu();
            menu.create();
            if (menu.list().contains(meal)){
                this.orderList.add(meal);
                this.count.add(count);
                this.totalcount = count*meal.getPrice();
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
        return this.totalcount;
    }
}
