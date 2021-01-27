package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class allPalindromPart {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String s = reader.readLine();
            ArrayList<ArrayList<String>> a = getGrey(s);
            for (ArrayList<String> strings : a) {
                for (String string : strings) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }
        }
    }

     static ArrayList<ArrayList<String>> getGrey(String s) {
        ArrayList<ArrayList<String>> a = new ArrayList<>();
        allpart(s,"",a);
        return a;
    }

     static void allpart(String s, String s1, ArrayList<ArrayList<String>> a) {
        if(s.length()==0){
            a.add(new ArrayList<>(Collections.singleton(s1)));
        }
        for(int i=0; i<s.length(); i++){
            String prf = s.substring(0,i+1);
            String res = s.substring(i+1);
            if(isPal(prf)){
                allpart(res,s1+prf+" ", a);
            }
        }
    }

    private static boolean isPal(String prf) {
        int start = 0;
        int i = prf.length()-1;
        while (start < i)
        {
            if (prf.charAt(start++) != prf.charAt(i--))
                return false;
        }
        return true;
    }

}
