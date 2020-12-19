package ua.stu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Human {
    private static final Point BREAD_POINT = new Point(370, 190);
    private static final Point VEGETABLES_POINT = new Point(665, 190);
    private static final Point DRINKS_POINT = new Point(665,500);
    private static final Point MEAT_POINT = new Point(370, 500);
    private static final List<Point> pokupkasList = new ArrayList<>();
    private JLabel jLabel;

    static {
        pokupkasList.add(BREAD_POINT);
        pokupkasList.add(VEGETABLES_POINT);
        pokupkasList.add(DRINKS_POINT);
        pokupkasList.add(MEAT_POINT);
    }


    private List<Pokupka> pokupkas = new ArrayList<>();
    private Shop shop;

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Pokupka> getPokupkas() {
        return pokupkas;
    }

    public void generatePokupkasList() {

        int randomCountOfPokupkas = ThreadLocalRandom.current().nextInt(1, 3);
        for (int i = 0; i < randomCountOfPokupkas; i++) {
            Pokupka pokupka = new Pokupka(pokupkasList.get(i));
            pokupkas.add(pokupka);
        }
    }

    public void goForPokupki() {
        pokupkas.forEach(pokupka -> {
            moveHumanForPokupka(pokupka);
        });
        goTOKassa();
    }

    private void goTOKassa() {
        try {
            BufferedImage image = ImageIO.read(getClass().getClassLoader().getResource("chelovekWithCard.png"));
            jLabel.setIcon(new ImageIcon(image));
            jLabel.repaint();
        } catch (Exception e){
            e.printStackTrace();
        }
        int x = jLabel.getX();
        int y = jLabel.getY();

        while (jLabel.getX() <= 800 ){
            try {
                jLabel.setLocation(x, jLabel.getY());
                Thread.sleep(100);
                x += 10;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        while (jLabel.getY() <= 375 ){
            try {
                jLabel.setLocation(jLabel.getX(), y);
                Thread.sleep(100);
                y += 10;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        jLabel.setIcon(null);
        jLabel.repaint();
    }

    private void moveHumanForPokupka(Pokupka pokupka) {
        //makeMoveForPokupka
        if (shop.getNotFreePokupkas().contains(pokupka)) {
            waitUntilOtdelenieIsFree();
            moveHumanForPokupka(pokupka);
        } else {
            shop.addNotFreePokupka(pokupka);
            move(pokupka);
            shop.deleteNotFreePokupka(pokupka);
        }
    }

    private void move(Pokupka pokupka) {
        //point where we need to move human;
        Point point = pokupka.getCoordinate();
        //TODO: change position of current human to pokupka coordinates

        if(jLabel.getX() < point.getX()){
            int x = jLabel.getX();
            while (jLabel.getX() <= point.getX()){
                try {
                    jLabel.setLocation(x, jLabel.getY());
                    Thread.sleep(100);
                    x += 10;
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        } else if(jLabel.getX() > point.getX()){
            int x = jLabel.getX();
            while (jLabel.getX() >= point.getX()){
                try {
                    jLabel.setLocation(x, jLabel.getY());
                    Thread.sleep(100);
                    x -= 10;
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        if (jLabel.getY() < point.getY()){
            int y = jLabel.getY();
            while (jLabel.getY() <= point.getY()){
                try {
                    jLabel.setLocation(jLabel.getX(), y);
                    Thread.sleep(100);
                    y += 10;
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        } else if(jLabel.getY() > point.getY()){
            int y = jLabel.getY();
            while (jLabel.getY() >= point.getY()){
                try {
                    jLabel.setLocation(jLabel.getX(), y);
                    Thread.sleep(100);
                    y -= 10;
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        /*jLabel.setLocation((int) point.getX() / 4,(int) point.getY() / 4);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jLabel.setLocation((int) point.getX() / 3,(int) point.getY() / 3);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jLabel.setLocation((int) point.getX() / 2,(int) point.getY() / 2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        jLabel.setLocation((int) point.getX(), (int) point.getY());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitUntilOtdelenieIsFree() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
