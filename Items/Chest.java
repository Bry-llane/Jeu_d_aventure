/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import Items.Item;
import java.util.ArrayList;

/**
 *
 * @author midek
 */
public class Chest {
    public final static int DEFAULT_MAX_VOLUME = 40;
    public final static String DEFAULT_NAME = "Chest";
    
    private boolean open;
    private int maxVolume;
    private int remainingVolume;
    private ArrayList <Item> contents;
    
    public Chest () {
        this.open = false;
        this.maxVolume = DEFAULT_MAX_VOLUME;
        this.remainingVolume = DEFAULT_MAX_VOLUME;
        this.contents = new ArrayList <>();
    }
    
    public boolean isOpen () {
        if (this.open == true) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isClose () {
        
        if (this.open == false) {
            return true;
        } else {
            return false;
        }
    }
    
    public void addItem(Item i) {
        if(this.isOpen()) {
            int newVolume = this.getRemainingVolume() + i.getVolume();
            if(newVolume > this.getMaxVolume()) {
                System.out.println("Pas assez d'espace pour ajouter cette article");
            } else {
                this.setRemainingVolume(newVolume);
                this.contents.add(i);
            }
        } else {
            System.out.println("Le coffre est fermé");
        }
    }
    
    public void removeItem(int index) {
        if(this.isOpen()) {
            if(index >= 0 && index < contents.size()) {
                this.setRemainingVolume(this.getRemainingVolume() - this.contents.get(index).getVolume());
                this.contents.remove(index);
            }
        } else {
            System.out.println("Le coffre est fermé");
        }
    }
    
    public void close() {
        this.open = false;
    }
    
    public void open() {
        this.open = false;
    }
    
    public int getMaxVolume() {
        return this.maxVolume;
    }
    
    public int getRemainingVolume() {
        return this.remainingVolume;
    }
    
    public void setRemainingVolume(int newV) {
        if(newV >= 0 && newV <= this.getMaxVolume()) this.remainingVolume = newV;
    }
    
    public void setMaxVolume(int newV) {
        if(newV >= 0) this.maxVolume = newV;
    }
    
    public void setContents(ArrayList<Item> newV) {
        this.contents = newV;
    }
    
    public ArrayList <Item> getContents() {
        return this.contents;
    }
    
    public void printContents() {
        if (this.isOpen() == true){
            for (Item items : this.contents) {
                System.out.println(items);
            }
        } else {
            System.out.println("Le coffre est ferme");
        }
    }
}
