package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ransomeNode {
    static void checkMagazine(String[] magazine, String[] note) {
       HashMap<String,Integer> h = new HashMap<>();
        boolean f = true;
        for (String c : magazine) {
            if (h.containsKey(c)) {
                h.put(c, h.get(c) + 1);
            }
            else {
                h.put(c, 1);
            }
        }

        for (String s : note) {
            if (h.containsKey(s)) {
                h.put(s,h.get(s)-1);
                if(h.get(s)==0){
                    h.remove(s);
                }
            }else {
                f=false;
            }
        }
        if(!f){
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
