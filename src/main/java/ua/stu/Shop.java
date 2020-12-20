package ua.stu;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Shop {


    private List<Pokupka> notFreePokupkas = new ArrayList<>();

    public List<Pokupka> getNotFreePokupkas() {
        return notFreePokupkas;
    }

    public void addNotFreePokupka(Pokupka pokupka) {
        notFreePokupkas.add(pokupka);
    }

    public void deleteNotFreePokupka(Pokupka pokupka) {
        notFreePokupkas.remove(pokupka);
    }

    private boolean isKassaFree = true;

    public synchronized boolean isKassaFree() {
        return isKassaFree;
    }

    public void setKassaFree(boolean kassaFree) {
        isKassaFree = kassaFree;
    }
}
