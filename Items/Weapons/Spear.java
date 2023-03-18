/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items.Weapons;

import Items.Weapon;

/**
 *
 * @author midek
 */
public class Spear extends Weapon{
    public final static int DEFAULT_ATT = 40;
    public final static int DEFAULT_DURRA = 25;
    public final static int DEFAULT_VOLUME = 8;
    public final static String DEFAULT_NAME = "Spear";
    public static int DEFAULT_PRICE = 15;
    
    public Spear(){
        super.setDurra(DEFAULT_DURRA);
        super.setAtt(DEFAULT_ATT);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(DEFAULT_NAME);
    }
    
    public Spear(String name){
        super.setDurra(DEFAULT_DURRA);
        super.setAtt(DEFAULT_ATT);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    public Spear(String name, int att){
        super.setDurra(DEFAULT_DURRA);
        super.setAtt(att);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    @Override
    public int getDefaultPrice(){
        return DEFAULT_PRICE;
    }
    
}
