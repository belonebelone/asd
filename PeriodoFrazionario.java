package com;
import java.lang.String;
import java.util.*;


public class PeriodoFrazionario {


/*
    public static int PeriodoThetan2(String s){
        int per = 0;
        int i;
        int j;

        for(int p=s.length();p>0;p--){
            i = 0;
            j = i+p;

            while(j<s.length() && s.charAt(i) == s.charAt(j)){
                i++;
                j = i + p;
            }

            if(j >= s.length()){
                per = p;
            }

        }

        return per;
    }
*/
    //-----------------theta n------------------------

    public static int periodoN(String s){
        int n = s.length();
        if(n==0) {
            return 0;
        }else{
            int[] r = new int[n + 1];
            int k;
            int j;
            int ind;

            r[1] = 0;

            for (int i = 2; i <= n; i++) {
                k = searchK(i, r);
                j = 1;

                while (j <= k && s.charAt(i - 1) != s.charAt(ind = searchJ(j, r, i))) {
                    j++;
                }

                if (j > k) {
                    r[i] = 0;
                } else {
                    ind = searchJ(j, r, i);
                    r[i] = ind + 1;
                }

            }

            return n - r[n];
        }
    }


    private static int searchK(int i,int[] r){
        int k = 1;
        int j = i-1;

        while (r[j] != 0){
            k++;
            j = r[j];
        }

        return k;
    }


    private static int searchJ(int j,int[] r,int i){
        int k = i-1;
        int z = 0;

        while( j > 0){
            z = r[k];
            j--;
            k = r[k];
        }

        return z;
    }



    public static int periodoFrazionarioThetaNQuad(String s){
        int per = s.length();
        for(int p=1;p<=s.length();p++){
            int k=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==s.charAt(i%p)){
                    k++;
                }
            }
            if(k==s.length() && p<per){
                per=p;
            }
        }
        return per;
}

//-----------------------------fine 12 --------------------------------
    public static double getResolution() {
        double start = System.nanoTime();
        double end;
        do {
            end = System.nanoTime();
        } while (start == end);
        return end - start;
    }






    public static int periodNaive(String s){
        int n= s.length();
        for(int p=1;p<n;p++){
            int k=0;
            int i=0;
            while(i<n-p && s.charAt(i)==s.charAt(i+p)){
                k++;
                i++;
            }
            if(k==n-p){
                return p;
            }
        }
        return n;
    }


    public static int periodSmart(String s){
        String v = " ";
        int n = s.length();
        int[] r = new int[n+1];

        s = v + s;

        r[1] = 0;

        for(int i=1; i<n;i++){

            int z = r[i];

            while(z>0 && s.charAt(i+1) != s.charAt(z+1)){
                z = r[z];
            }

            if(s.charAt(i+1) == s.charAt(z+1)){
                r[i+1] = z + 1;
            }else{
                r[i+1] = 0;
            }
        }

        return n - r[n];
    }



    public static String stringGenerator(char[] alfabeto, int i){ // 0<i<=99
        double a = 1000;
        double b = 1.064785978;
        int n = (int)Math.floor(a*Math.pow(b,i));
        String s="";
        for(int j=0;j<n;j++){
            if(Math.random()<0.5){
                s+=alfabeto[0];
            }else{
                s+=alfabeto[1];
            }
        }
        System.out.println("lunghezza stringa: "+n);
        return s;
    }

}














