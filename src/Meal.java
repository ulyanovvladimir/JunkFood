/**
 *
 * Блюдо из меню
 */
public class Meal {
    private final String title;
    private Float price;

    public Meal(String t, Float p) {
        this.title = t;
        this.price = p;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String t) {
        System.out.println("You want alter "+this.title+" to "+t+".\nBut you can't alter meal title!\n");
    }

    public Float getPrice(){
        return this.price;
    }
    public void setPrice(Float p) {
        System.out.println("You want alter "+this.price+" to "+p+".\nBut you can't alter meal price!\n");
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
