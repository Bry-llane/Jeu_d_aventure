/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

import Exits.Exit;
import Exits.KeyExit;
import Exits.QuestionExit;
import Items.Heal;
import Items.Item;
import Items.Key;
import Items.Keys.ExitKey;
import Items.Weapon;
import Pnj.Dealer;
import Pnj.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author matte
 */
public class ScanUser {
    
    private String[] simpleCommand = new String[] {"look", "help", "quit", "inventory"};
    private String[] complexCommand = new String[] {"talk", "take", "attack", "use", "buy", "open", "go"};
    
    private String command;
    private String complexSecondWord; // For complexCommande this is the second parameter ("ex: talk user, -> return "user")
    
    private boolean loopY = true;
    
    private Place lvl;
    
    private String whereGo = null;
    
    public ScanUser(Place lvl) {
        this.lvl = lvl;
        System.out.println("Bienvenue a l'" + this.lvl.getName());
    }
    
    public boolean isSimple(String cmd) {
        for(int i = 0; i < simpleCommand.length; i++) {
            if(cmd.equals(simpleCommand[i])) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isComplex(String cmd) {
        String[] word = cmd.split(" ");
        if(word.length == 2) {
            for(int i = 0; i < this.complexCommand.length;i++) {
                if(this.complexCommand[i].equals(word[0])) {
                    this.complexSecondWord = word[1];
                    return true;
                }
            }
        }
        return false;
    }
    
    private String[] commandArg(String str) {
        String str_split[] = str.split(" ");
        return str_split;
    }
    
    public boolean loopYet () {
        return this.loopY;
    }
    
    public void readUser() {
        System.out.print("\n> (HELP pour avoir de l'aide) : ");
        Scanner scan = new Scanner(System.in);
        String phrase = scan.nextLine().toLowerCase();
        
        if(this.isSimple(phrase)) {
            if(phrase.equals("look")) {
                this.lookCommand();
            } else if(phrase.equals("help")) {
                this.listCommand();
            } else if(phrase.equals("quit")) {
                System.out.println("Fin de la partie !");
                this.loopY = false;
            } else if (phrase.equals("inventory")) {
                this.inventoryCommand();
            }
        } else if(this.isComplex(phrase)) {
            String cmdArg[] = this.commandArg(phrase);
            
            if(cmdArg[0].equals("talk")) {
                this.talkCommand(cmdArg[1]);
            } else if(cmdArg[0].equals("take")) {
                this.takeCommand(cmdArg[1]);
            } else if(cmdArg[0].equals("attack")) {
                this.attackCommand(cmdArg[1]);
            } else if(cmdArg[0].equals("use")) {
                this.useCommand(cmdArg[1]);
            } else if(cmdArg[0].equals("buy")) {
                this.buyCommand(cmdArg[1]);
            } else if(cmdArg[0].equals("open")) {
                this.openCommand(cmdArg[1]);
            } else if(cmdArg[0].equals("go")) {
                this.goCommand(cmdArg[1]);
            }
            
        } else {
            System.out.println("Cette commande n'existe pas");
        }
        //PHRASE COMPLEXE AUSSI FAIRE LOOK [ARG]
        //VOIR POUR USE
    }
    public String getWhereGo() {
        return this.whereGo;
    }
    private void goCommand(String arg) {
        Map<String, Exit> sorties = this.lvl.getSorties();
        for(Map.Entry<String, Exit> entry : sorties.entrySet()) {
            if(entry.getValue().getWhereName().equals(arg)) {
                if(entry.getValue() instanceof KeyExit) {
                    KeyExit ke = (KeyExit) entry.getValue();
                    if(ke.isLocked()) {
                        System.out.println("Cette porte est verrouillee");
                        return;
                    }
                } else if(entry.getValue() instanceof QuestionExit) {
                    QuestionExit qe = (QuestionExit) entry.getValue();
                    if(qe.isLocked()) {
                        System.out.println("Cette porte est verrouillee");
                        return;
                    }
                }
                this.whereGo = arg;
                this.loopY = false;
                return;
            }
        }
        System.out.println("Vous ne pouvez pas passer par ici");
    }
    private void openCommand(String arg) {
        Map<String, Exit> sorties = this.lvl.getSorties();
        boolean isDoor = false;
        for(Map.Entry<String, Exit> entry : sorties.entrySet()) {
            if(entry.getValue().getWhereName().toLowerCase().equals(arg)) {
                isDoor = true;
                if(entry.getValue() instanceof QuestionExit) {
                    System.out.println("Cette porte se deverrouille avec une bonne reponse");
                    if(this.lvl.getHero().getMoney() < 10) {
                        System.out.println("Il faut au moins 10 pieces pour tente sa chanche");
                        return;
                    }
                    QuestionExit qe = (QuestionExit) entry.getValue();
                    System.out.println(qe.getQuestion());
                    Scanner scanner = new Scanner(System.in);
                    if(qe.unlock(scanner.nextInt())) {
                        System.out.println("Porte deverrouillee");
                        System.out.println("Utilisez GO " + arg + " pour y acceder");
                    } else  {
                        System.out.println("Mauvaise reponse - 10 pieces");
                        this.lvl.getHero().setMoney(this.lvl.getHero().getMoney() - 10);
                    }
                } else if (entry.getValue() instanceof KeyExit) {
                    boolean open = false;
                    KeyExit ke = (KeyExit) entry.getValue();
                    System.out.println();
                    for(int i = 0; i < this.lvl.getHero().getItems().size(); i++) {
                        ArrayList<Item> items = this.lvl.getHero().getItems();
                        if(items.get(i) instanceof ExitKey) {
                            ExitKey k = (ExitKey) items.get(i);
                            System.out.println("Nb de cle : " + k.getNbKey());
                            if(k.getNbKey() > 0) {
                                k.setNbKey(k.getNbKey() - 1);
                                ke.unlock();
                                System.out.println("Porte deverrouillee");
                                System.out.println("Utilisez GO " + arg + " pour y acceder");
                                return;
                            }
                        }
                    }
                    System.out.println("Vous n'avez pas de cle pour deverrouiller cette porte");
                } else if (entry.getValue() instanceof Exit) {
                    System.out.println("Porte deja deverrouillee");
                } else {
                    System.out.println("Porte inconnu");
                }
            }
        }
        if(!isDoor) System.out.println(ColorConsole.RED_BOLD + "Cette porte n'existe pas" + ColorConsole.WHITE_BOLD);
    }
    
    private void buyCommand(String arg) {
        ArrayList<Pnj.Character> pnj = this.lvl.getPnj();
        for(int i = 0; i < pnj.size(); i++) {
            if(pnj.get(i) instanceof Dealer) {
                Dealer d = (Dealer) pnj.get(i);
                ArrayList<Item> list =  d.getItems();
                for(int j = 0; j < list.size(); j++) {
                    System.out.println(list.get(j).getName().toLowerCase());
                    if(list.get(j).getName().toLowerCase().equals(arg)) {
                        if(this.lvl.getHero().getMoney() - list.get(j).getDefaultPrice() > 0) {
                            this.lvl.getHero().addItem(list.get(j));
                            this.lvl.getHero().setMoney(this.lvl.getHero().getMoney() - list.get(j).getDefaultPrice());
                        } else {
                            System.out.println(ColorConsole.RED_BOLD + "Vous n'avez pas assez de piece" + ColorConsole.WHITE_BOLD);
                        }
                    }
                }
            }
        }
        
    }
    
    private void useCommand(String arg) {
        ArrayList<Item> items = this.lvl.getHero().getItems();
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().toLowerCase().equals(arg)) {
                if(items.get(i) instanceof Weapon)
                    this.lvl.getHero().equipItem((Weapon) items.get(i));
                else if(items.get(i) instanceof Items.Heal) {
                    Heal heal = (Heal) items.get(i);
                    int newPv = heal.getPvGive() + this.lvl.getHero().getPv();
                    this.lvl.getHero().setPv(newPv);
                    this.lvl.getHero().removeItem(i);
                } else {
                    System.out.println("Vous ne pouvez pas utiliser cet objet.");
                }
                // A voir pour repair, chest and ammunition
            }
        }
    }
    private void attackCommand(String arg) {
        ArrayList<Pnj.Character> pnj = this.lvl.getPnj();
        boolean isOpponent = false;
        int i;
        for(i = 0; i < pnj.size(); i++) {
            Pnj.Character p = pnj.get(i);
            if(p.getName().toLowerCase().equals(arg)) {
                isOpponent = true;
                if(p.canAndBeAttack()) {
                    if(p.getPv() > 0) {
                        System.out.println("Vous attaquez " + p.getName());
                        this.lvl.getHero().attack(p);

                        if(p.getPv() > 0) {
                            System.out.println(p.getName() + " vous attaque en retour ");
                            p.attack(this.lvl.getHero());
                            if(this.lvl.getHero().getPv() == 0) {
                                System.out.println("Vous etes mort !\nFin de la partie !");
                                this.loopY = false;
                            }
                            System.out.println("Il reste " + String.valueOf(pnj.get(i).getPv()) + "PV a " + pnj.get(i).getName());
                        } else {
                            System.out.println("Vous avez tue " + p.getName());
                        }
                    } else {
                        System.out.println(p.getName() + " est deja mort !");
                    }
                    System.out.println("Il vous reste " + String.valueOf(this.lvl.getHero().getPv()) + "PV");

                } else {
                    System.out.println(p.getName() + " n'est pas attaquable");
                }
            }
        }
        if(isOpponent == false) System.out.println("Personnage introuvable");
    }
    
    private void takeCommand(String arg) {
        for(int i = 0; i < this.lvl.getItems().size(); i++){
            Item item = this.lvl.getItems().get(i);
            if(item.getName().toLowerCase().equals(arg)) {
                this.lvl.getHero().addItem(item);
                this.lvl.removeItem(i);
                System.out.println("Item ajoute !\n> INVENTORY pour voir mon inventaire");
                return;
            }
        }
        System.out.println(ColorConsole.RED_BOLD + "Cet item n'existe pas | > HELP pour avoir de l'aide" + ColorConsole.WHITE_BOLD);
    }
    
    private void talkCommand(String arg) {
        // verifier si le arg est bien le nom d'un personnage
        for(int i = 0; i < this.lvl.getPnj().size(); i++){
            String name = this.lvl.getPnj().get(i).getName();
            if(name.toLowerCase().equals(arg)) {
                System.out.println("   \"" + this.lvl.getPnj().get(i).getPhrase() + "\" -- " + name);
                return;
            }
        }
        System.out.println(ColorConsole.RED_BOLD + "Ce personnage n'existe pas | > HELP pour avoir de l'aide" + ColorConsole.WHITE_BOLD);
    }
    private void inventoryCommand() {
        Hero h = this.lvl.getHero();
        int length = h.getItems().size();
        System.out.println("Vous avez " + String.valueOf(this.lvl.getHero().getMoney()) + " pieces");
        System.out.println("Vous avez " + String.valueOf(this.lvl.getHero().getPv()) + "PV");
        System.out.println("Mon inventaire : " + length);
        for(int i = 0; i < length; i++) {
            System.out.println("  - " + h.getItems().get(i));
        }
    }
    private void lookCommand() {
        // retourne tous les perso + items + porte
        ArrayList<Item> item = this.lvl.getItems();
        ArrayList<Pnj.Character> c = this.lvl.getPnj();
        Map<String, Exit> sorties = this.lvl.getSorties();
        
        System.out.println("Liste des Items : " + item.size() + " | Utilisez TAKE <Item> pour recuperer l'item");
        for(int i = 0; i < item.size(); i++) {
            System.out.println("  - " + item.get(i).getName());
        }
        
        System.out.println("Liste des Personnages : " + c.size() + " | Utilisez TALK <Personnage> pour parler lui parler");
        for(int i = 0; i < c.size(); i++) {
            System.out.print("  - " + c.get(i).getName());
            if(c.get(i).getPv() > 0) System.out.print(" [ATTAQUABLE]\n");
            else System.out.print(" [NON ATTAQUABLE]\n");
        }
        
        System.out.println("Liste des Portes : " + sorties.size() + " | Utilisez OPEN <Porte> pour l'ouvrir");
        
        for(Map.Entry<String, Exit> entry : sorties.entrySet()) {
            System.out.println("  - " + entry.getValue().getWhereName());
        }
    }
    private void listCommand() {
        System.out.println("Liste des commandes\n"
                + " > LOOK\n"
                + " > HELP\n"
                + " > QUIT\n"
                + " > INVENTORY\n"
                + " > USE <Arme>\n"
                + " > BUY <Item>\n"
                + " > TAKE <Item>\n"
                + " > TALK <Personnage>\n"
                + " > ATTACK <Personnage>\n"
                + " > OPEN <Porte>\n"
                + " > GO <Place>\n");
    }
    
}