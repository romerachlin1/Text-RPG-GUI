public class Player {
        private int hp;
        private String name;
        private Weapon weapon;



        public Player(String name){
            this.name = name;
            this.hp = 35;
            this.weapon = Weapon.bareFists;
        }

        public String toString() {
            return "Your name is " + name + ", your current hp is " + hp + " and your current weapon is " + weapon;
        }

        public String getName() {
            return name;
        }

        public int getHp() {
            return hp;
        }

        public Weapon getWeapon() {
            return weapon;
        }

        public void setHp(int hp) {
            this.hp = hp;

        }

        public void setName(String name) {
            this.name = name;
        }

        public void setWeapon(Weapon weapon) {
            this.weapon = weapon;
        }

}
