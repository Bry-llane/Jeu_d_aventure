/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exits;

/**
 *
 * @author midek
 */
public class KeyExit extends Exit{
    private boolean locked;
    
    public KeyExit () {
        this.locked = true;
    }
    
    public KeyExit (String where) {
        this.locked = true;
        super.setWhereName(where);
    }
    
    public boolean isLocked () {
        return this.locked == true;
    }
    
    public void unlock () {
        this.locked = false;
    }
    
}
