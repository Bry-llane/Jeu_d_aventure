/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

/**
 *
 * @author midek
 */
public abstract class Heal extends Item {
    public final static int DEFAULT_PVGIVE = 10;
    public final static int DEFAULT_VOLUME = 1;
    public final static String DEFAULT_NAME = "Heal";
    
    private int PVGIVE;
    
    public Heal(){
        this.PVGIVE = DEFAULT_PVGIVE;
        super.setVolume(DEFAULT_VOLUME);
        super.setName(DEFAULT_NAME);
    }
    
    public Heal(String name){
        this.PVGIVE = DEFAULT_PVGIVE;
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    public int getPvGive() {
        return this.PVGIVE;
    }
    
    public void setPvGive(int newPvGive) {
        this.PVGIVE = newPvGive;
    }
    
    @Override
    public String toString(){
        return super.getName() + " occupe " + this.getVolume() + " place, redonne " + this.getPvGive() + " Pv et est une " + DEFAULT_NAME;
    }
    
}
