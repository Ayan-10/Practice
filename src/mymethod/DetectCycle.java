package mymethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DetectCycle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = reader.readLine().trim().split("\\s+");
            int E = Integer.parseInt(st[0]);
            int V = Integer.parseInt(st[1]);
            for (int i = 0; i < V + 1; i++) {
                list.add(i, new ArrayList<>());
            }
            int p = 0;
            for (int i = 0; i <E; i++) {
                String s[] = reader.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }
            if(isCyclic(V,list)){
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
        }
    }

    private static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> list) {
    boolean b[] = new boolean[v];
    boolean f = false;
    for (int i=0; i<v; i++){
        b[i]=true;
        for (int j=0; j<list.get(i).size(); j++){
            ArrayList<Integer> a = list.get(i);
            f=cyclictill(list, b , a.get(j));
            if(f){
                return true;
            }
        }
        b[i]=false;
    }
    return false;
    }

    private static boolean cyclictill(ArrayList<ArrayList<Integer>> list, boolean[] b, int i) {
    if(b[i]==true){
        return true;
    }
    b[i]=true;
    boolean f = false;
    for (int j=0; j<list.get(i).size(); j++){
        ArrayList<Integer> a = list.get(i);
        f = cyclictill(list,b,a.get(j));
        if(f){
            return true;
        }
    }
    return false;
    }
}