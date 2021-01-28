package mymethod;

import java.io.*;
import java.util.*;

public class Toposort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- >0){
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = reader.readLine().trim().split("\\s+");
            int E = Integer.parseInt(st[0]);
            int V = Integer.parseInt(st[1]);
            for (int i=0; i<V+1; i++){
                list.add(i,new ArrayList<Integer>());
            }
            String s[] = reader.readLine().trim().split("\\s+");
            int p =0;
            for (int i=1; i<=E; i++){
                int u = Integer.parseInt(s[p++]);
                int v = Integer.parseInt(s[p++]);
                list.get(u).add(v);
            }
            int[] res = toposort(list,V);
            if(check(list,V,res)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    private static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] m = new int[V];
        for (int i=0; i<V; i++){
          m[res[i]]=i;
        }
        for (int i=0; i<V; i++){
            for(int v: list.get(i)){
                if(m[i]>m[v]) return false;
            }
        }
        return true;
    }

    private static int[] toposort(ArrayList<ArrayList<Integer>> list, int V) {

        int res[] = new int[V];
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(list,i, visited, stack);
            int i=0;
        while (!stack.empty()){
            res[i]= stack.pop();
            i++;
        }
        return res;
    }

    private static void topologicalSortUtil(ArrayList<ArrayList<Integer>> list, int v, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent
        // to thisvertex
        Iterator<Integer> it = list.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(list,i, visited, stack);
        }

        // Push current vertex to stack
        // which stores result
        stack.push(v);
    }
}
