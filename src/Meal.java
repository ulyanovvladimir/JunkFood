/**
 *
 * Блюдо из меню
 */
public class Meal {
    private String title;
    private Float price;
    public Meal(String title, Float price){
        this.title = title;
        this.price = price;
    }  /**
     *
     * @return наименование блюда
     */
    public String getTitle(){
        return this.title;
//        throw new UnsupportedOperationException();
    }
    /**
     * Вовзвращает цену с плавающей точкой.
     * @return Цена, число с плавающей точкой в у.е.
     */
    public Float getPrice(){
        return this.price;
        //  throw new UnsupportedOperationException();
    }

    public void setPrice(Float Price){
        this.price = Price;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Meal){
            Meal m = (Meal) obj;
            return m.getTitle().equals(this.getTitle());
        } else return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Meal){
            Meal m = (Meal) obj;
            return m.getTitle().equals(this.getTitle());
        } else return false;
    }
}
