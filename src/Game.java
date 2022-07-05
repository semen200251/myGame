import java.util.Random;
import java.util.Scanner;

public class Game {


    static Hero hero;
    static Seller seller;

    public static void main(String[] args) {
        createGame();
        int action=analiseText();
        while(action!=3){
            if(action==1){
                Fight fight=new Fight();
                fight.start();
                try {
                    fight.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(hero.hp<=0){
                    break;
                }
                Random random=new Random();
                if(random.nextInt()%3==0){
                    seller.createItem();
                    System.out.println("Seller found something for you");
                }
            }else if(action==2){
                seller.sale(hero);
            }else{
                System.out.println("You wrote wrong action. Try one more time");
            }
            System.out.println("Your hero has");
            System.out.println("hp:"+hero.hp);
            System.out.println("agility:"+hero.agility);
            System.out.println("power:"+hero.power);
            System.out.println("gold:"+hero.gold);
            System.out.println("exp:"+hero.exp);
            action=analiseText();
        }


    }

    static void createGame(){
        System.out.println("What's your name?");
        Scanner scanner=new Scanner(System.in);
        hero=new Hero(scanner.nextLine());

        seller=new Seller();
        for(int i=0;i<5;i++){
            seller.createItem();
        }
    }

    static int analiseText(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("What do you want to do? Say number of action");
        System.out.println("1. Fight");
        System.out.println("2. Sale");
        System.out.println("3. Exit");
        return scanner.nextInt();
    }
}
