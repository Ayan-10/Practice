package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class gameOfDeath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String st[] = reader.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int k = Integer.parseInt(st[1]);
            System.out.println("The chosen place is " + josephus(n, k));
//            ArrayList<Integer> list = new ArrayList<>();
//
//            // Storing value from 1 to n
//            for (int i = 1; i <= n; i++) {
//                list.add(i);
//            }
//
//            // Calling function with starting position at
//            // 0-index and k-1 so that kth person will be killed
//            // Storing the safe position
//            int safePosition = josephus(list, 0, k - 1);
//
//            // Printing the result
//            System.out.println("The safe position : "
//                    + safePosition);

        }
    }
    public static int josephus(ArrayList<Integer> list,
                               int start, int k)
    {
        for(int a : list){
            System.out.print((int)a+" ");
        }
        System.out.println(start+"<start k>"+k);
        // If size of list is one
        // then return its value
        if (list.size() == 1) {
            System.out.println("here we go");
            return list.get(0);
        }

        // Counting kth person and
        // check so that it don't go out of bound
        start = (start + k) % list.size();

        // Removing the kth person
        list.remove(start);

        // Calling recursive function again until only one
        // person left Start is now the position of previous
        // person who is killed Ex. if person at 1-index
        // killed then person at 2-index shifted to 1-index
        // and counting start from here
        return josephus(list, start, k);
    }
static int josephus(int n, int k)
{
    if (n == 1) {
        System.out.println("here we go");
        return 1;
    }
    else
    /* The position returned by josephus(n - 1, k)
    is adjusted because the recursive call
    josephus(n - 1, k) considers the original
    position k%n + 1 as position 1 */
        return (josephus(n - 1, k) + k-1) % n + 1;
}

}