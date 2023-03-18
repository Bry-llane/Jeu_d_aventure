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
public abstract class Weapon extends Item {
    public final static int DEFAULT_ATT = 10;
    public final static int DEFAULT_DURRA = 10;
    public final static int DEFAULT_VOLUME = 5;
    public final static String DEFAULT_NAME = "Weapon";
    
    private int durra;
    private int ATT;
    
    public Weapon(){
        this.durra = DEFAULT_DURRA;
        this.ATT = DEFAULT_ATT;
        super.setVolume(DEFAULT_VOLUME);
        super.setName(DEFAULT_NAME);
    }
    
    public Weapon(String name){
        this.durra = DEFAULT_DURRA;
        this.ATT = DEFAULT_ATT;
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    public Weapon(String name, int att){
        this.durra = DEFAULT_DURRA;
        this.ATT = att;
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    public int getDurra() {
        return this.durra;
    }
    
    public int getAtt() {
        return this.ATT;
    }
    
    public void setDurra(int newDurra) {
        this.durra = newDurra;
    }
    
    public void decreaseDurra() {
        if (this.getDurra() > 0) {
            this.durra = this.durra - 1;
        }
    }
    
    public void setAtt(int newAtt) {
        this.ATT = newAtt;
    }
    
}
