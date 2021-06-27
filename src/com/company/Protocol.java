package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Protocol {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";


    private Map<String, String> reponse;


    public Protocol() {
        reponse = new HashMap<String, String>();
        reponse.put("HOLA", CYAN + "Como estas?" + RESET);
        reponse.put("ESTOY MAL", PURPLE + "Oh, no esperaba esta respuesta." + RESET);
        reponse.put("ESTOY BIEN", YELLOW + "Me alegro!" + RESET);
        reponse.put("DIA", GREEN + LocalDate.now().toString() + RESET);
        reponse.put("HORA", GREEN + LocalTime.now().toString() + RESET);
        reponse.put("TRUCO", RED + "Quiero retruco" + RESET);
        reponse.put("ENVIDO", RED + "Flor por atrevido" + RESET);

    }

    public String input(String input) {

        if (reponse.containsKey(input.toUpperCase())) {

            return reponse.get(input) + "\n";

        } else if (input.equals("")) {
            return "";
        } else {
            if (Math.random()*6 < 3)
                return "German no fue tan inteligente como programar este escenario" + "\n";
            else
                return "Julian no fue tan inteligente como programar este escenario" + "\n";
        }
    }
}

