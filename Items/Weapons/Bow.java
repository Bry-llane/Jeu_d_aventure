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
public class Bow extends Weapon{
    public final static int DEFAULT_ATT = 20;
    public final static int DEFAULT_DURRA = 100;
    public final static int DEFAULT_VOLUME = 5;
    public final static String DEFAULT_NAME = "Bow";
    public static int DEFAULT_PRICE = 10;
    
    public Bow(){
        super.setDurra(DEFAULT_DURRA);
        super.setAtt(DEFAULT_ATT);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(DEFAULT_NAME);
    }
    
    public Bow(String name){
        super.setDurra(DEFAULT_DURRA);
        super.setAtt(DEFAULT_ATT);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    public Bow(String name, int att){
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
