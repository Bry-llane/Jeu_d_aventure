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
public class Exit {
    public static final String DEFAULT_PLACE = "nul part";
    private String whereName;
    
    public Exit() {
        this.whereName = DEFAULT_PLACE;
    }
    
    public Exit(String nom) {
        this.whereName = nom;
    }
    
    public void setWhereName(String where) {
        this.whereName = where;
    }
    
    public String getWhereName() {
        return this.whereName;
    }
    
    @Override
    public String toString (){
        return "Cette porte amene a : " + this.getWhereName() + " ";
    }
}
