import java.util.Random;

public class Fight extends Thread{

    int digit=0;


    @Override
    public void run() {
        Random random=new Random();
        Monster monster=new Monster("monster", random.nextInt(Game.hero.agility),random.nextInt(Game.hero.power));
        System.out.println("Info about your enemy: ");
        System.out.println("hp:"+monster.hp);
        System.out.println("agility:"+monster.agility);
        System.out.println("power:"+monster.power);
        //Console console=new Console();
        //console.start();
        try{
            Fight.sleep(3500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        while(true){
            System.out.println("Hero is attacking!");
            monster.defend(Game.hero.attack());
            if(!monster.isAlive()){
                System.out.println("Monster is dead!");
                System.out.println("You get "+monster.power*2+" gold\n");
                Game.hero.boostHero(monster.power*2, 10);
                Game.hero.hp=Game.hero.power*6;
               // console.interrupt();
                break;
            }
            System.out.println("Monster has "+monster.hp+" hp\n");
            try{
                Fight.sleep(2500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Monster is attacking!");
            Game.hero.defend(monster.attack());
            if(!Game.hero.isAlive()){
                System.out.println("Hero is dead!");
                //console.interrupt();
                break;
            }
            System.out.println("Hero has "+Game.hero.hp+" hp\n");
            try{
                sleep(2500);
                //if(digit!=0){
                    //Game.hero.agility+=digit;
                    //System.out.println("Agility: "+Game.hero.agility);
                    //console.stop();
                //}
                //sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //class Console extends Thread{
        //Scanner scanner=new Scanner(System.in);
       // @Override
        //public void run() {
            //while (!Thread.interrupted()) {
                //digit = scanner.nextInt();
           //}
        //}
   // }

}
