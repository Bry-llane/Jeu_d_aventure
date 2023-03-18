/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import Items.Item;

/**
 *
 * @author midek
 */
public abstract class Key extends Item {
    public final static int DEFAULT_STOCK = 1;
    public final static int DEFAULT_VOLUME = 1;
    public final static String DEFAULT_NAME = "Key";
    
    private int number;
    
    public Key(){
        this.number = DEFAULT_STOCK;
        super.setVolume(DEFAULT_VOLUME * this.number);
    }
    
    public Key(int newStock){
        this.number = newStock;
        super.setVolume(DEFAULT_VOLUME * this.number);
    }
    
    public int getNbKey() {
        return this.number;
    }
    
    public void setNbKey(int newStock) {
        this.number = newStock;
    }
    
    public void useKey() {
        if (this.number == 1) {
            this.number = 0;
            this.setVolume(0);
        } else {
            this.number = this.number - 1;
            this.setVolume(this.number * DEFAULT_VOLUME);
        }
    }
    
    public void addKey() {
        this.number = this.number + 1;
        this.setVolume(this.number * DEFAULT_VOLUME);
    }
    
    @Override
    public String toString(){
        return super.getName() + " occupe " + this.getVolume() + " place, est au nombre de " + this.getNbKey()+ " et est une " + DEFAULT_NAME;
    }
}
