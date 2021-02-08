package practice;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class mergeKsort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    a[i][j]= sc.nextInt();
                }
            }
            ArrayList<Integer> ar = mergeKArrays(a,n);
            for (int i=0; i<n*n; i++){
                System.out.print(ar.get(i)+" ");
            }
            System.out.println();
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] a, int k)
    {
        ArrayList<Integer> ar = new ArrayList<>();

        PriorityQueue<solution> q = new PriorityQueue<>();
        int i=0;
        for(int j=0; j<k; j++){
            q.add(new solution(a[j][i],j,i));
        }
        while(q.size()<((k*k)+1) && !q.isEmpty()){
            int x,y;
            x=q.peek().pos1;
            y=q.peek().pos2;
            ar.add(q.remove().val);
            if((x>=0 && x<k)&&(y>=0 && y<k-1)) {
                q.add(new solution(a[x][y + 1], x, y + 1));
            }

        }

        return ar;
    }
}
class solution implements Comparable<solution>{
    int val,pos1,pos2;
    public solution(int ft, int sd,int sc){
        this.val=ft;
        this.pos1=sd;
        this.pos2=sc;
    }

    @Override
    public int compareTo(solution o) {
        if(val < o.val){
            return -1;
        }else if(val > o.val){
            return 1;
        }
        return 0;
    }
}