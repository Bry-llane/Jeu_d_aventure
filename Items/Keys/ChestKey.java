/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items.Keys;

import Items.Key;


/**
 *
 * @author midek
 */
public class ChestKey extends Key {
    public final static int DEFAULT_STOCK = 1;
    public final static int DEFAULT_VOLUME = 1;
    public final static String DEFAULT_NAME = "ChestKey";
    
    public ChestKey(){
        super.setNbKey(DEFAULT_STOCK);
        super.setVolume(DEFAULT_VOLUME * super.getNbKey());
        super.setName(DEFAULT_NAME);
    }
    
    public ChestKey(int newStock){
        super.setNbKey(newStock);
        super.setVolume(DEFAULT_VOLUME * super.getNbKey());
    }
    
    public ChestKey(int newStock, String name){
        super.setNbKey(newStock);
        super.setVolume(DEFAULT_VOLUME * super.getNbKey());
        super.setName(name);
    }
    
    @Override
    public String toString(){
        return super.getName() + " occupe " + this.getVolume() + " place, est au nombre de " + this.getNbKey()+ " et est une " + DEFAULT_NAME;
    }
}
