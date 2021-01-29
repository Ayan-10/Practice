package mymethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DetectCycle {
    final static int WHITE = 0, GRAY = 1, BLACK = 2;
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