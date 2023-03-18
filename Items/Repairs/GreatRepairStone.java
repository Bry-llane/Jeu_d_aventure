/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items.Repairs;

import Items.Repair;

/**
 *
 * @author midek
 */
public class GreatRepairStone extends Repair {
    public final static int DEFAULT_DURRAGIVE = 60;
    public final static int DEFAULT_VOLUME = 2;
    public final static String DEFAULT_NAME = "GreatRepairStone";
    public static int DEFAULT_PRICE = 10;
    
    
    public GreatRepairStone(){
        super.setDurraGive(DEFAULT_DURRAGIVE);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(DEFAULT_NAME);
    }
    
    public GreatRepairStone(String name){
        super.setDurraGive(DEFAULT_DURRAGIVE);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    @Override
    public int getDefaultPrice(){
        return DEFAULT_PRICE;
    }
    
    @Override
    public String toString(){
        return this.getName() + " occupe " + this.getVolume() + " place, redonne " + this.getDurraGive() + " de durrabilite et est une " + DEFAULT_NAME;
    }
}
