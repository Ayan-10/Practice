package test;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class pq_test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a= new int[n];
        for (int i=0; i<n; i++){
                a[i]= sc.nextInt();
        }
        ArrayList<Integer> ar = new ArrayList<>();

        PriorityQueue<solution> q = new PriorityQueue<>();
        q.add(new solution(a[0],0));
        q.add(new solution(a[1],1));
        q.add(new solution(a[2],2));
        q.add(new solution(a[3],3));
        q.add(new solution(a[4],4));
        while(!q.isEmpty()){
            System.out.println(q.peek().fs);
            System.out.println(q.remove().fs);
        }

    }
}
class solution implements Comparable<solution>{
    int fs,sc;
    public solution(int ft, int sd){
        this.fs=ft;
        this.sc=sd;
    }

    @Override
    public int compareTo(solution o) {
        if(fs < o.fs){
            return -1;
        }else if(fs > o.fs){
            return 1;
        }
        return 0;
    }
}