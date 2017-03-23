/**
 *
 * Блюдо из меню
 */
public class Meal {
    private String name;
    private double price;
    //todo Добавьте необходимые конструктуры и/или методы, чтобы можно было создать блюдо с указанием его наименования
    //todo Подумайте, что лучше подходит. Считается, что у блюда название не изменяется ;)
    public Meal create(String s, double price){
        throw new UnsupportedOperationException();
    }
    /**
     *
     * @return наименование блюда
     */
    public String getTitle(){
        //todo
        throw new UnsupportedOperationException();
    }

    /**
     * Вовзвращает цену с плавающей точкой.
     * @return Цена, число с плавающей точкой в у.е.
     */
    public double getPrice(){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Meal){
            Meal m = (Meal) obj;
            return m.getTitle().equals(this.getTitle());
        } else return false;
    }
}
