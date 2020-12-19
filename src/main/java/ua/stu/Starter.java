package ua.stu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Starter {

    public static void main(String[] args) {

        Starter starter = new Starter();
        Shop shop = new Shop();

        while (true) {
            List<Human> humanList = starter.generateHumans(shop);

            humanList.forEach(human -> {
                Thread thread = new Thread(() -> {
                    human.goForPokupki();
                });
                thread.start();
            });

            try {
                //TIME TO SLEEP BEFORE NEW PEOPLE WILL BE GENERATED.
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Human> generateHumans(Shop shop) {
        int randomCountOfHumans = ThreadLocalRandom.current().nextInt(1, 20);

        List<Human> humanList = new ArrayList<>();

        for (int i = 0; i < randomCountOfHumans; i++) {
            Human human = new Human();
            human.setShop(shop);
            human.generatePokupkasList();
            humanList.add(human);
        }
        return humanList;
    }
}
