package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class prerequisiteTasks {
    final static int WHITE = 0, GRAY = 1, BLACK = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String st[] = reader.readLine().trim().split("\\s+");
            int V = Integer.parseInt(st[0]);
            int E = Integer.parseInt(st[1]);
            int[][] pre = new int[V][2];
            int p=0;
            for (int i = 0; i < E; i++) {
                for (int j=0; j<2; j++){
                    String s[] = reader.readLine().trim().split("\\s+");
                    pre[i][j]=Integer.parseInt(s[p]);
                }
            }

            if(isPossible(V,pre)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPossible(int v, int[][] pre) {
        ArrayList<ArrayList<Integer>> list = make(v,pre);
        return (!isCyclic(v,list));

    }

    private static ArrayList<ArrayList<Integer>> make(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<>());
        }
        for (int i = 0; i < pre.length; i++) {
            int u = pre[i][1];
            int v = pre[i][0];
            list.get(u).add(v);
        }
        return list;
    }
    private static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> list) {
        int[] color = new int[v];
        for (int i = 0; i < v; i++)
        {
            color[i] = WHITE;
        }
        for (int i = 0; i < v; i++)
        {
            if (color[i] == WHITE)
            {
                if(cyclictill(list, i, color))
                    return true;
            }
        }
        return false;
    }

    private static boolean cyclictill(ArrayList<ArrayList<Integer>> list, int i, int[] color) {
        color[i] = GRAY;
        for (Integer in : list.get(i) )
        {
            if (color[in] == GRAY)
                return true;

            if (color[in] == WHITE && cyclictill(list, in, color))
                return true;
        }

        color[i] = BLACK;
        return false;
    }
}