package test;

public class sttest {

    public static void main(String[] args) {
        String[] s = {"ytdfegt","dgh","udf","ouhoj"};
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }
        String str = sb.toString();
        String[] st = {"dgh","udf"};
        StringBuffer sb1 = new StringBuffer();
        for(int i = 0; i < st.length; i++) {
            sb1.append(st[i]);
        }
        String s2 = sb1.toString();
        System.out.println(str.contains(s2));
    }
}