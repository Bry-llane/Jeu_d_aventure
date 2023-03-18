/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items.Heals;

import Items.Heal;

/**
 *
 * @author midek
 */
public class LittleHeal extends Heal {
    public final static int DEFAULT_PVGIVE = 50;
    public final static int DEFAULT_VOLUME = 1;
    public final static String DEFAULT_NAME = "LittleHeal";
    public static int DEFAULT_PRICE = 10; 
    
    public LittleHeal(){
        super.setPvGive(DEFAULT_PVGIVE);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(DEFAULT_NAME);
    }
    
    public LittleHeal(String name){
        super.setPvGive(DEFAULT_PVGIVE);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    @Override
    public int getDefaultPrice(){
        return DEFAULT_PRICE;
    }
    
    @Override
    public String toString(){
        return this.getName() + " occupe " + this.getVolume() + " place, redonne " + this.getPvGive() + " Pv et est une " + DEFAULT_NAME;
    }

}
