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
public class Gun extends Weapon{
    public final static int DEFAULT_ATT = 20;
    public final static int DEFAULT_DURRA = 100;
    public final static int DEFAULT_VOLUME = 5;
    public final static int DEFAULT_BULLET_STOCK = 5;
    public final static int DEFAULT_BULLET_STOCKMAX = 5;
    public final static String DEFAULT_NAME = "Gun";
    public static int DEFAULT_PRICE = 10;
    
    private int bulletStock;
    private final int BULLETSTOCKMAX;
    
    public Gun(){
        this.bulletStock = DEFAULT_BULLET_STOCK;
        this.BULLETSTOCKMAX = DEFAULT_BULLET_STOCKMAX;
        super.setDurra(DEFAULT_DURRA);
        super.setAtt(DEFAULT_ATT);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(DEFAULT_NAME);
    }
    
    public Gun(String name){
        this.bulletStock = DEFAULT_BULLET_STOCK;
        this.BULLETSTOCKMAX = DEFAULT_BULLET_STOCKMAX;
        super.setDurra(DEFAULT_DURRA);
        super.setAtt(DEFAULT_ATT);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    public Gun(String name, int att){
        this.bulletStock = DEFAULT_BULLET_STOCK;
        this.BULLETSTOCKMAX = DEFAULT_BULLET_STOCKMAX;
        super.setDurra(DEFAULT_DURRA);
        super.setAtt(att);
        super.setVolume(DEFAULT_VOLUME);
        super.setName(name);
    }
    
    public int getBulletStock() {
        return this.bulletStock;
    }
    
    public int getBulletStockMax() {
        return this.BULLETSTOCKMAX;
    }
    
    public void setBulletStock(int bullets) {
        this.bulletStock = bullets;
    }
    
    public void useBulletStock() {
        this.bulletStock--;
    }
    
    @Override
    public int getDefaultPrice(){
        return DEFAULT_PRICE;
    }
    
}
