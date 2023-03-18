/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items.Ammunitions;


import Items.Ammunition;

/**
 *
 * @author midek
 */
public class Bullet extends Ammunition{
    public final static int DEFAULT_STOCK = 10;
    public final static int DEFAULT_VOLUME = 5;
    public final static String DEFAULT_NAME = "Bullet";
    public static int DEFAULT_PRICE = 1;
    
    
    public Bullet(){
        super.setStock(DEFAULT_STOCK);
        super.setVolume(DEFAULT_VOLUME * super.getStock());
        super.setName(DEFAULT_NAME);
    }
    
    public Bullet(int stock){
        super.setStock(stock);
        super.setVolume(DEFAULT_VOLUME * super.getStock());
    }
    
    public Bullet(String name, int newStock){
        super.setStock(DEFAULT_STOCK);
        super.setVolume(DEFAULT_VOLUME * this.getStock());
        super.setName(name);
    }
    
    @Override
    public int getDefaultPrice(){
        return DEFAULT_PRICE;
    }
    
    @Override
    public String toString(){
        return super.getName() + " occupe " + this.getVolume() + " place, est au nombre de " + this.getStock()+ " et est une " + DEFAULT_NAME;
    }
}
