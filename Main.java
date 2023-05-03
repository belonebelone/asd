package com;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String s = "abcaba";
        char[] alfabeto ={'a','b'};
        double start = System.nanoTime();
        double resolution = PeriodoFrazionario.getResolution();
        double Tmin = resolution*0.000000001 * ((1/0.001) + 1);
        int iterations=0;
        while(iterations<50){
            PeriodoFrazionario.periodSmart(PeriodoFrazionario.stringGenerator(alfabeto, iterations));
            iterations++;
        }
        double time = System.nanoTime()-start;
        double tmins = time/Tmin;

        //System.out.printf("%f",System.nanoTime()-start);
        System.out.printf("\n%f",tmins);
        System.out.printf("\n%f",time);
    }

    /**
     *
     * (parte intera inferiore) [A*B^i]
     * A=1000 B=1.064785978
     * così n varia tra 1000 e 500 000.
     *
     * risoluzione 300 nano seconds
     * tmin = 0.3 x10^-6 s
     *
     */

}

