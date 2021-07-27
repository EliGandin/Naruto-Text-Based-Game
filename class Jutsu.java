class Jutsu{
    private String _type;
    private String _name;
    private String _nature;
    private double _chakraPrice;
    private String _range;
    private double _damage;
    
//Constructors
    public Jutsu(String type, String name, String nature, double chakraPrice,String range, double damage){
        _type = type;
        _name = name;
        _nature = nature;
        _chakraPrice = chakraPrice;
        _range = range;
        _damage = damage;
    }

    public Jutsu(Jutsu other){
        this._type = other._type;
        this._name = other._name;
        this._nature = other._nature;
        this._chakraPrice = other._chakraPrice;
        this._range = other._range;
        this._damage = other._damage;
    }

// Getters

    public String getType(){
        return _type;
    }

    public String getName(){
        return _name;
    }

    public String getNature(){
        return _nature;
    }

 
    public double getChakraPrice(){
        return _chakraPrice;
    }

    public String getRange(){
        return _range;
    }

    public double getDamage(){
        return _damage;
    }

    public String getJutsu(){
        if (getNature().equals("null"))
            return getName();
         else{
          return (getNature() + ": " + getName());
        }   
    }   

    //Setters

    public void setChakraPrice(double delta){
        this._chakraPrice = this._chakraPrice + delta;
    }

    public void setRange(String s){
        this._range = s;
    }

    public void setDamage(double delta){
        this._damage = this._damage + delta;
    }

// Etc.

    public void printJutsu(){
        if (getNature().equals("null"))
            System.out.println(getName());
        else{
            System.out.println(getNature() + ": " + getName());
        }
    }


    public static void main(String []args){
        Jutsu fireball = new Jutsu("Ninjutsu", "Fireball", "Fire Style", 20, "medium", 35);
        fireball.setDamage(15);
        //Jutsu rasengan = new Jutsu("Ninjutsu", "Rasengan", "null", 35, "short", 100);
        fireball.printJutsu();
        System.out.println(fireball.getDamage());
       // PrintJutsu(rasengan);


    
    }
}