public class Weapon {
    private String type;
    private int damage;

    public Weapon(String type, int damage){
        this.type = type;
        this.damage = damage;
    }

    public String toString() {
        return type + " that does " + damage + " damage.";
    }

    public int getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setType(String type) {
        this.type = type;
    }

    static Weapon bareFists = new Weapon("Bare Fists", 2);
    static Weapon knife = new Weapon("Knife", 3);
    static Weapon sword = new Weapon("Sword", 4);
}
