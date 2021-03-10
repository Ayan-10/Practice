package fau;


import java.util.*;
import java.io.*;
import java.math.*;

public class fau {

    class stud{
        String name;
        int marks;
    }
    int n;
//
//    public static void main(String[] args) {
////
//////        int a=1;
//////        int b=2;
//////        System.out.print((int)Math.ceil(a/(float)b));
//////         String s ="antontrygub";
//////       ArrayList<Character> a;
//////        a = new ArrayList<>();
//////        for(int i=0; i<s.length(); i++){
//////           if(!a.contains(s.charAt(i))){
//////
//////               a.add( s.charAt(i));
//////           } fau fau
//////       }
//////       //a.forEach(System.out :: print);
//////        a.stream().forEach((s1) -> System.out.print(s1 + " "));
////
//////        char[] tmpa = s.toCharArray();
//////        Arrays.sort(tmpa);
//////        String tmp = new String(tmpa);
//////                System.out.println(tmp);
//////        int i =1000000000;
//////        System.out.println(i/2);
////
////        int i=5/6;
////        System.out.println(i);
//
//    }

    static final int MAXN = 100001;

    // stores smallest prime factor for every number
    static int spf[] = new int[MAXN];

    // Calculating SPF (Smallest Prime Factor) for every
    // number till MAXN.
    // Time Complexity : O(nloglogn)
    static void sieve()
    {
        spf[1] = 1;
        for (int i=2; i<MAXN; i++)

            // marking smallest prime factor for every
            // number to be itself.
            spf[i] = i;

        // separately marking spf for every even
        // number as 2
        for (int i=4; i<MAXN; i+=2)
            spf[i] = 2;

        for (int i=3; i*i<MAXN; i++)
        {
            // checking if i is prime
            if (spf[i] == i)
            {
                // marking SPF for all numbers divisible by i
                for (int j=i*i; j<MAXN; j+=i)

                    // marking spf[j] if it is not
                    // previously marked
                    if (spf[j]==j)
                        spf[j] = i;
            }
        }
    }

    // A O(log n) function returning primefactorization
    // by dividing by smallest prime factor at every step
    static Vector<Integer> getFactorization(int x)
    {
        Vector<Integer> ret = new Vector<>();
        while (x != 1)
        {
            ret.add(spf[x]);
            x = x / spf[x];
        }
        return ret;
    }

    // Driver method
    public static void main(String args[])
    {
        // precalculating Smallest Prime Factor
        sieve();
        int x = 360;
        System.out.print("prime factorization for " + x + " : ");

        // calling getFactorization function
        Vector <Integer> p = getFactorization(x);

        for (int i=0; i<p.size(); i++)
            System.out.print(p.get(i) + " ");
        System.out.println();
    }
}

