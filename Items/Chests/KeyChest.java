/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items.Chests;

import Items.Chest;
import Items.Chest;

/**
 *
 * @author midek
 */
public class KeyChest extends Chest{
    private boolean locked;
    
    public KeyChest () {
        this.locked = true;
    }
    
    public boolean isLocked () {
        if (this.locked == true) {
            return true;
        } else {
            return false;
        }
    }
    
    public void unlock () {
        this.locked = false;
    }
    
    public void lock () {
        this.locked = true;
    }
    
    @Override
    public void open () {
        if (isLocked() == true) {
            super.close();
        } else {
            super.open();
        }
    }  
}
