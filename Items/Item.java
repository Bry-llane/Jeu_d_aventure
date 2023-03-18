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
public abstract class Item {
    public final static String DEFAULT_NAME = "Item";
    public final static int DEFAULT_VOLUME = 1;
    public final static int DEFAULT_PRICE = 10;
    
    private String name;
    private int volume;
    
    public Item (){
        this.name = DEFAULT_NAME;
        this.volume = DEFAULT_VOLUME;
    }
    
    public Item (String name, int volume){
        this.name = name;
        this.volume = volume;
    }
    
    public int getVolume(){
        return this.volume;
    }
    
    public void setVolume(int newVolume){
        this.volume = newVolume;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getDefaultPrice(){
        return DEFAULT_PRICE;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    @Override
    public String toString(){
        return this.name + " | Place occupee : " + this.volume + " | Nom de base : " + DEFAULT_NAME;
    }
}
