/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import Exits.KeyExit;
import Exits.Exit;
import Exits.QuestionExit;
import Items.Heals.GreatHeal;
import Items.Heals.LittleHeal;
import Items.Keys.ExitKey;
import Items.Repairs.LittleRepairStone;
import Items.Weapons.Gun;
import Items.Weapons.Spear;
import Items.Weapons.Sword;
import Pnj.Dealer;
import Pnj.Hero;
import Pnj.Monster;
import Pnj.Monsters.Gobelin;
import Pnj.OtherCharacter;
import java.util.Scanner;


/**
 *
 * @author midek
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        
        //creation du hero
	System.out.println("Bonjour, entrez le nom du joueur");
        String phrase = scan.nextLine();
        
        Hero hero = new Hero(phrase);
        
        //creation du world
        World world = new World(hero);
        world.level1();
    }
}
