package com.company;

public class Protocol {
    public String input(String input){
        String output = "No se que responder bro";
        if(input.equals(""))
            return "";
        if(input.equals("ola"))
            return "Ola ke ace";
        if(input.equals("x"))
            return "chua brodi";
        return output;
    }
}
