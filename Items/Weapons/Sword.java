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
public class Sword extends Weapon{
    public final static int DEFAULT_ATT = 30;
    public final static int DEFAULT_DURRA = 25;
    public final static int DEFAULT_VOLUME = 6;
    public static int DEFAULT_PRICE = 15;    
    public final static String DEFAULT_NAME = "Sword";
    
    public Sword(){
        super.setDurra(DEFAULT_DURRA);
        super.setAtt(DEFAULT_ATT);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(DEFAULT_NAME);
    }
    
    public Sword(String name){
        super.setDurra(DEFAULT_DURRA);
        super.setAtt(DEFAULT_ATT);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    public Sword(String name, int att){
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
