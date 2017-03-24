public class Meal {

    public  static String title;
    Float price;
    public  Meal(String title, Float price){
        this.title = title;
        this.price = price;
    }

    public String getTitle(){
        return this.title;

    }


    public Float getPrice(){
        return this.price;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Meal){
            Meal m = (Meal) obj;
            return m.getTitle().equals(this.getTitle());
        }else {return false;}
    }
}

