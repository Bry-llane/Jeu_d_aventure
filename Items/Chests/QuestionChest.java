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
public class QuestionChest extends Chest{
    private static final int DEFAULT_CODE = 0000;
    private final String DEFAULT_QUESTION = "....";
    
    private boolean locked;
    private int answer;
    private String question;
    
    public QuestionChest () {
        this.answer = DEFAULT_CODE;
        this.locked = true;
        this.question = DEFAULT_QUESTION;
    }
    
    public QuestionChest (int code, String question) {
        this.answer = code;
        this.locked = true;
        this.question = question;
    }
    
    public void changeCode (int newCode) {
        this.answer = newCode;
    }
    
    public void setQuestion (String p) {
        this.question = p;
    }
    
    public String getQuestion () {
        return this.question;
    }
    
    public void unlock (int codeEnter) {
        if (this.answer == codeEnter) {
            this.locked = false;
        } else {
            this.locked = true;
        }
    }
    
    public boolean isLocked () {
        if (this.locked == true) {
            return true;
        } else {
            return false;
        }
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
