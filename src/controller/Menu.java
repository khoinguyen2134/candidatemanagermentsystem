/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.I_Menu;
import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author ACER
 */
public class Menu extends ArrayList<String> implements I_Menu{

    @Override
    public void addItem(String str) {
        this.add(str);
    }

    @Override
    public int getChoice() {
        int result = 0;
        do {
            result = Utils.getInt("Input your choice: ", 1, this.size());
        } while (result < 1 || result > this.size());
        return result;
    }

    @Override
    public void showMenu() {
        if (!this.isEmpty()) {
            for (String menu : this) {
                Utils.display(menu);
            }
        }
    }

    @Override
    public boolean confirmYesNo(String welcome) {
        return Utils.confirmYesNo(welcome);
        
    }

    @Override
    public void checkTrueFalse(boolean check) {
        if (check) {
            Utils.display("Success!!!");
        } else {
            Utils.display("Fail!!!");
        }
        
        
    }

    
    
}
