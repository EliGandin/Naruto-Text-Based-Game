class NinjaTool{
    private String _type;
    private String _name;
    private String _range;
    private double _damage;
    private int _amount;

//Constructors

    public NinjaTool(String type, String name, String range, double damage, int amount){
        _type = type;
        _name = name;
        _range = range;
        _damage = damage;
        _amount = amount;
    }

    public NinjaTool(NinjaTool other){
        this._type = other._type;
        this._name = other._name;
        this._range = other._range;
        this._damage = other._damage;
        this._amount = other._amount;
    }

// Getters

public String getType(){
    return _type;
}

public String getName(){
    return _name;
}

public String getRange(){
    return _range;
}

public double getDamage(){
    return _damage;
}

public int getAmount(){
    return _amount;
}

public String getNinjaTool(){
    return (_name + " x" + _amount);
}

//Setters

public void setRange(String s){
    this._range = s;
}

public void setDamage(double delta){
    this._damage = this._damage + delta;
}

public void setAmount(int delta){
    this._amount = this._amount + delta;
}

// Printers

public void printNInjaTool(){
    System.out.println(_name + " x" + _amount);
}


public static void main(String[] args) {
    NinjaTool kunai = new NinjaTool("physical", "Kunai", "medium", 10 ,10);
    kunai.setAmount(5);
    kunai.printNInjaTool();

    NinjaTool waterScroll = new NinjaTool("Sealing Scroll", "Water Scroll", "short", 0, 2);
    waterScroll.printNInjaTool();
    
    System.out.println(kunai.getNinjaTool());
}
}