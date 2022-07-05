public class Hero extends Character{

    static int gold, exp;

    Hero(String name) {
        super(name, 15, 15);
        this.gold=90;
        this.exp=100;
    }

    void boostHero(int changingGold, int... boost){
        gold+=changingGold;
        if(boost!=null) {
            if (boost.length == 1) {
                exp += boost[0];
            } else if (boost.length == 2) {
                agility += boost[0];
                power += boost[1];
                hp=power*6;
            }
        }
    }



}
