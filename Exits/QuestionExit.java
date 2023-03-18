/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exits;

import Exits.Exit;

/**
 *
 * @author midek
 */
public class QuestionExit extends Exit{
    private static final int DEFAULT_CODE = 0000;
    private final String DEFAULT_QUESTION = "....";
    
    private boolean locked;
    private String question;
    
    private int answer;
    
    public QuestionExit () {
        this.answer = DEFAULT_CODE;
        this.locked = true;
        this.question = DEFAULT_QUESTION;
    }
    
    public QuestionExit (int code, String question, String where) {
        this.answer = code;
        this.locked = true;
        this.question =  question;
        super.setWhereName(where);
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
    
    public boolean unlock (int codeEnter) {
        if (this.answer == codeEnter) {
            this.locked = false;
            return true;
        } else {
            this.locked = true;
            return false;
        }
        
    }
    
    public boolean isLocked () {
        if (this.locked == true) {
            return true;
        } else {
            return false;
        }
    }
}
