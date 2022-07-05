import java.util.Random;

class Character {
    String name;
    int hp,agility,power;

    Character(String name,int agility,int power){
        this.name=name;
        this.hp=power*6;
        this.agility=agility;
        this.power=power;
    }

    int attack(){
        Random random=new Random();
        int digit=random.nextInt(100);
        if(agility>digit){
            System.out.println("It was critical damage");
            return agility*2;
        }else if(agility<digit-80){
            System.out.println("It was miss");
            return 0;
        }else{
            System.out.println("It was default damage");
            return agility;
        }
    }

    void defend(int damage){
        if(damage-agility/10<=0){
            return;
        }else {
            hp -= damage - agility / 10;
        }

    }

    boolean isAlive(){
        if(hp<=0){
            return false;
        }else{
            return true;
        }
    }

}
