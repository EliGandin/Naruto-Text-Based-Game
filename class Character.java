class Character {
    private String _name;
    private String _aff;
    private double _chakra;
    private double _hp;
    private double _phSTR;
    private double _def;
    private double _spd;
    public Jutsu[] _jutsuList;
    private NinjaTool[] _ninjaTool;
    private boolean _inspect;

    // Constractors

    public Character(String name, String aff, double chakra, double hp, double phSTR, double def, double spd) {
        _name = name;
        _aff = aff;
        _jutsuList = new Jutsu[10];
        _ninjaTool = new NinjaTool[10];
        _chakra = chakra;
        _hp = hp;
        _phSTR = phSTR;
        _def = def;
        _spd = spd;
        _inspect = false;
    }

    // Getters

    public String getName() {
        return _name;
    }

    public String getAff() {
        return _aff;
    }

    public double getChakra() {
        return _chakra;
    }

    public double getHP() {
        return _hp;
    }

    public double getPhSTR() {
        return _phSTR;
    }

    public double getDEF() {
        return _def;
    }

    public double getSPD() {
        return _spd;
    }

    public Jutsu[] getJutsuList() {
        return _jutsuList;
    }

    public boolean getInspect() {
        return _inspect;
    }

    // Setters

    public void setChakra(double delta) {
        this._chakra = this._chakra + delta;
    }

    public void setHp(double delta) {
        this._hp = this._hp + delta;
    }

    public void setPhSTR(double delta) {
        this._phSTR = this._phSTR + delta;
    }

    public void setDEF(double delta) {
        this._def = this._def + delta;
    }

    public void setSPD(double delta) {
        this._spd = this._spd + delta;
    }

    public void setInspect(boolean b) {
        _inspect = b;
    }
    // Printers

    public void printName() {
        System.out.println(_name);
    }

    public void printJutsuList() {
        if (numOfJutsus() == 0)
            System.out.println("Empty Jutsu List");
        if (numOfJutsus() == 1)
            System.out.println("1. " + _jutsuList[0].getJutsu());
        else {
            String s = "1. " + _jutsuList[0].getJutsu();
            for (int i = 1; _jutsuList[i] != null && i < 10; i++) {
                s += ", " + (i + 1) + ". " + this._jutsuList[i].getJutsu();
            }
            System.out.println(s);
        }
    }

    private int numOfJutsus() {
        int num = 0;
        for (int i = 0; i < 10; i++) {
            if (this._jutsuList != null)
                num++;
            else {
                break;
            }
        }
        return num;
    }

    public void printNInjaTool() {
        if (numOfNinjaTools() == 0)
            System.out.println("Empty NinjaTools List");
        if (numOfJutsus() == 1)
            System.out.println("1. " + _ninjaTool[0].getNinjaTool());
        else {
            String s = "1. " + _ninjaTool[0].getNinjaTool();
            for (int i = 1; _ninjaTool[i] != null && i < 10; i++) {
                s += ", " + (i + 1) + ". " + this._ninjaTool[i].getNinjaTool();
            }
            System.out.println(s);
        }
    }

    private int numOfNinjaTools() {
        int num = 0;
        for (int i = 0; i < 10; i++) {
            if (this._ninjaTool != null)
                num++;
            else {
                break;
            }
        }
        return num;
    }

    // Loot

    public void addJutsu(Jutsu j) {
        for (int i = 0; i < 10; i++) {
            if (this._jutsuList[i] == null) {
                this._jutsuList[i] = j;
                break;
            }
        }
    }

    public void addNinjaTool(NinjaTool n) {
        for (int i = 0; i < 10; i++) {
            if (this._ninjaTool[i] == null) {
                this._ninjaTool[i] = n;
                break;
            }
        }
    }

    // Uses

    public void useJutsu(int i) {
        if (getChakra() > _jutsuList[i].getChakraPrice()) {
            setChakra(-_jutsuList[i].getChakraPrice());
            _jutsuList[i].printJutsu();
        } else {
            System.out.println("I don't have enough chakra for this jutsu");
        }
    }

    public void useJutsu(Character c, int i) {
        if (getChakra() > _jutsuList[i].getChakraPrice()) {
            setChakra(-_jutsuList[i].getChakraPrice());
            _jutsuList[i].printJutsu();
            c.setHp(-_jutsuList[i].getDamage());
        } 
        else {
            System.out.println("I don't have enough chakra for this jutsu");
        }
    }

    public void useNinjaTool(int i) {
        if (_ninjaTool[i].getAmount() > 0)
            _ninjaTool[i].setAmount(-1);
        else {
            System.out.println("I don't have any " + _jutsuList[i].getName() + "left");
        }
    }

    public void useNinjaTool(Character c, int i) {
        if (_ninjaTool[i].getAmount() > 0){
            _ninjaTool[i].setAmount(-1);
            c.setHp(-_ninjaTool[i].getDamage());
        }
        else {
            System.out.println("I don't have any " + _jutsuList[i].getName() + "left");
        }
    }

    public static void main(String[] args) {
        Jutsu fireball = new Jutsu("Ninjutsu", "Fireball Jutsu", "Fire Style", 20, "medium", 35);
        Jutsu chidori = new Jutsu("Ninjutsu", "Chidori", "Lightning Style", 35, "short", 55);
        Character sasuke = new Character("Sasuke Uchiha", "Konoha", 100, 100, 100, 100, 5);
        sasuke.addJutsu(fireball);
        sasuke.addJutsu(chidori);
        sasuke.printJutsuList();
        // sasuke.useJutsu(0);
        // System.out.println(sasuke.getChakra());

        NinjaTool kunai = new NinjaTool("physical", "Kunai", "medium", 10 ,10);
        NinjaTool Shuriken = new NinjaTool("Physical", "Shuriken", "medium", 10, 10);
        sasuke.addNinjaTool(kunai);
        sasuke.addNinjaTool(Shuriken);
        sasuke.printNInjaTool();
    }
}