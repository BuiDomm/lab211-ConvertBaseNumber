/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Element {
       private String input; 

    public Element() {
    }

    public Element(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Element{");
        sb.append("input=").append(input);
        sb.append('}');
        return sb.toString();
    }
        
       
       
       
    
}
