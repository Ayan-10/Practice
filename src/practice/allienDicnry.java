package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class allienDicnry {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- >0){

            String[] st = reader.readLine().trim().split("\\s+");
            int E = Integer.parseInt(st[0]);
            int V = Integer.parseInt(st[1]);

            String[] str = reader.readLine().trim().split("\\s+");


            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i=0; i<V+1; i++){
                list.add(i, new ArrayList<>());
            }
            for (int i=1; i<=E; i++){
                String[] s = reader.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

        }
    }
}
