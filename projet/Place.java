/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import Exits.Exit;
import Items.Item;
import Pnj.Character;
import Pnj.Hero;
import Pnj.Monsters.Boss;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author midek
 */
public class Place {
    public final static String DEFAULT_NAME = "nul part";
    
    private final String NAME;
    private Map<String, Exit> sorties;
    private ArrayList<Item> items;
    private ArrayList<Character> pnj;
    private Hero hero;
    
    public Place (){
        this.NAME = DEFAULT_NAME;
        this.sorties = new HashMap<>();
        this.items = new ArrayList<>();
        this.pnj = new ArrayList<>();
    }
    
    public Place (String nom){
        this.NAME = nom;
        this.sorties = new HashMap<>();
        this.items = new ArrayList<>();
        this.pnj = new ArrayList<>();
    }
    
    public void addHero(Hero h) {
        this.hero = h;
    }
    
    public Hero getHero() {
       return this.hero;
    }

    public Map getSorties() { 
        return this.sorties;
    }
    public void addItem(Item i){
        this.items.add(i);
    }
    public void addPnj(Character c){
        this.pnj.add(c);
    }
    public void addExit(Exit s){
        this.sorties.put(s.getWhereName(), s);
    }
    
    public ArrayList<Item> getItems () {
        return this.items;
    }
    public void removeItem(int index) {
        if(index >= 0 && index < this.getItems().size()) {
            this.items.remove(index);
        }
    }
    
    public String getName() {
        return this.NAME;
    }
    
    public ArrayList<Character> getPnj () {
        return this.pnj;
    }
    
    public boolean bossIsAlive(){
        for (Character pnj : this.pnj) {
            if (pnj instanceof Boss) {
                return true;
            }
        }
        return false;
    }
    
    public void getListeSorties() {
        Set<String> listSorties = this.sorties.keySet();
        int i = 0;
        for (String porte : listSorties) {
            Exit nomLieux = this.sorties.get(porte);
            String l = nomLieux.getWhereName();
            System.out.println("Porte: " + i + " donne acces a : " + l);
            i++;
        }
    }
}