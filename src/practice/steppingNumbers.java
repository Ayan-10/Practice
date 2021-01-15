package practice;

import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class steppingNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] st = reader.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);
            System.out.println(stepnum(n,m));
        }
    }

    private static int stepnum(int n, int m) {
        int ans = 0;
        for (int i = 0 ; i <= 9 ; i++) {
            ans+=dfs(n, m, i, 0);
        }

        return ans;
    }

    private static int dfs(int n, int m, int i, int ans) {

        if(i>=n && i<=m){
            ans++;
        }
        if(i==0 || i>m){
            return ans;
        }
        int ld = i%10;
        int ia= i*10+(ld - 1);
        int ib= i*10+(ld + 1);
        if(ld==0){
            ans+=dfs(n,m,ib,0);
        }else if(ld==9){
            ans+=dfs(n,m,ia,0);
        }else{
            ans+=dfs(n,m,ia,0);;
            ans+=dfs(n,m,ib,0);
        }
        return ans;
    }

}
