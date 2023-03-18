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
public abstract class Repair extends Item {
    public final static int DEFAULT_DURRAGIVE = 10;
    public final static int DEFAULT_VOLUME = 1;
    public final static String DEFAULT_NAME = "Repair";
    
    private int DURRAGIVE;
    
    public Repair(){
        this.DURRAGIVE = DEFAULT_DURRAGIVE;
        super.setVolume(DEFAULT_VOLUME);
        super.setName(DEFAULT_NAME);
    }
    
    public Repair(String name){
        this.DURRAGIVE = DEFAULT_DURRAGIVE;
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    public int getDurraGive() {
        return this.DURRAGIVE;
    }
    
    public void setDurraGive(int newDurraGive) {
        this.DURRAGIVE = newDurraGive;
    }
    
    @Override
    public String toString(){
        return super.getName() + " occupe " + this.getVolume() + " place, redonne " + this.getDurraGive() + " de durrabilite et est une " + DEFAULT_NAME;
    }
    
}
