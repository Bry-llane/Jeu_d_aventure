/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pnj;

import Interfaces.Talker;
import Items.Item;
import java.util.ArrayList;
import projet.ColorConsole;

/**
 *
 * @author matte
 */
public class Dealer extends Character implements Talker {
    public static final String ANSI_BLUE = "\u001B[34m";

    public static int DEFAULT_PRICE_BULLET = 1;

    private final String DEFAULT_PHRASE = "Utilisez BUY <Item> pour acheter";
    
    private ArrayList<Item> toSell;
        
    public Dealer() {
        super.setName("Dealer");
        this.toSell = new ArrayList<>();
        super.setPhrase(DEFAULT_PHRASE);
    }
    
    public Dealer(String phrase) {
        super.setName("Dealer");
        this.toSell = new ArrayList<>();
        super.setPhrase(phrase);
    }
    
    public void addItem(Item i) {
        this.toSell.add(i);
    }
    
    public ArrayList<Item> getItems() {
        return this.toSell;
    }
    
    public void removeItem(int index) {
        this.toSell.remove(index);
    }
    
    @Override
    public String getPhrase () {
        this.sell();
        return this.DEFAULT_PHRASE;
    }
    
    public void sell() {
        int i = 0; 
        for (Item objet : this.toSell){
            System.out.println(" > " + objet.getName() + " -> pour " +objet.getDefaultPrice() + " piece");
        }
    }
    
    @Override
    public boolean canAndBeAttack() {
        return false;
    }
    
    @Override
    public void talk(String phrase) {
        this.sell();
    }
    
    public void defaulttalk() {
        System.out.println(super.getPhrase());
    }

    public Item get(int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
