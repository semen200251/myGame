import java.util.*;


public class Seller {

    List items=new ArrayList<Item>();
    int countBuffs=0;
    static class Item{
        int price;
        String name;
        int buffAgility;
        int buffPower;
        int necessaryExp;

        Item(int price, String name, int buffAgility, int buffPower, int necessaryExp){
            this.price=price;
            this.name=name;
            this.buffAgility=buffAgility;
            this.buffPower=buffPower;
            this.necessaryExp=necessaryExp;
        }
    }

    void sale(Hero hero){
        System.out.println("You can choose: ");
        for(int i=0;i<items.size();i++) {
            Item item= (Item) items.get(i);
            System.out.println(item.name+" is busted your Agility on "+item.buffAgility+" and Power on "+item.buffPower+". It will be cost "+item.price+" and need "+item.necessaryExp+ " exp!");
        }
        System.out.println("What do you want? Say the name");
        int result=choseItem(hero.gold,hero.exp);

        if(result!=-1){
            Item item= (Item) items.get(result);
            hero.boostHero(-item.price,item.buffAgility, item.buffPower);
        }

        System.out.println("Good luck");
    }

    int choseItem(int money, int exp){
        Scanner scanner=new Scanner(System.in);
        int indexOfItem=-1;
        boolean check=true;
        String choosedItem=scanner.nextLine();
        while (check){
            for(int i=0;i<items.size();i++){
                Item item= (Item) items.get(i);
                if(choosedItem.equals(item.name)){
                    if(money<item.price){
                        System.out.println("You don't have enough money for it");
                    }
                    else if(exp<item.necessaryExp){
                        System.out.println("You don't have enough exp for it");
                    }else {
                        check = false;
                        indexOfItem = i;
                    }
                    break;
                }
            }
            if(check){
                System.out.println("Try one more time:) And if you want to leave say leave");
                choosedItem=scanner.nextLine();
                if(choosedItem.equals("leave")){
                    check=false;
                }
            }
        }
        return indexOfItem;
    }

    void createItem(){
        Random random=new Random();
        items.add(new Item(random.nextInt(Game.hero.gold), "Buff number "+countBuffs, random.nextInt(Game.hero.agility/2),random.nextInt(Game.hero.power/2), random.nextInt(Game.hero.exp+20)));
        countBuffs++;
    }

}
