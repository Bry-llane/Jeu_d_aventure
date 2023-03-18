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
public abstract class Ammunition extends Item{
    public final static int DEFAULT_STOCK = 10;
    public final static int DEFAULT_VOLUME = 5;
    public final static String DEFAULT_NAME = "Ammunition";
    
    private int stock;
    
    public Ammunition(){
        this.stock = DEFAULT_STOCK;
        super.setVolume(DEFAULT_VOLUME * this.stock);
        super.setName(DEFAULT_NAME);
    }
    
    public Ammunition(int stock){
        this.stock = stock;
        super.setVolume(DEFAULT_VOLUME * this.stock);
    }
    
    public Ammunition(String name, int newStock){
        if(newStock >= 0) {
            this.stock = newStock;
            super.setVolume(DEFAULT_VOLUME * this.stock);
            super.setName(name);
        }
    }
    
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int newStock) {
        this.stock = newStock;
    }
    
    public void useAmmunition() {
        if (this.stock == 1) {
            this.stock = 0;
            this.setVolume(0);
        } else {
            this.stock = this.stock - 1;
            this.setVolume(this.stock * DEFAULT_VOLUME);
        }
    }
    
    public void addAmmunition() {
        this.stock = this.stock + 1;
        this.setVolume(this.stock * DEFAULT_VOLUME);
    }
    
    @Override
    public String toString(){
        return super.getName() + " occupe " + this.getVolume() + " place, est au nombre de " + this.getStock()+ " et est une " + DEFAULT_NAME;
    }
}
