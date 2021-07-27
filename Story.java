
public class Story {
    public static void main(String[] args) {
        // Naruto setup
        Jutsu shadowClone = new Jutsu("Ninjutsu", "Shadow Clone Jutsu", "null", 15, "short+", 25);
        Jutsu rasengan = new Jutsu("NinJutsu", "Rasengan", "null", 25, "short", 55);
        Character narutoUzumaki = new Character("Naruto Uzumaki", "Village Hidden In The Leaves", 200, 200, 5, 6, 3);
        narutoUzumaki.addJutsu(shadowClone);
        narutoUzumaki.addJutsu(rasengan);
        
    }
}