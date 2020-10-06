import java.util.Scanner;

public class Stringtest {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        String str=new String();
        String str2="hello world";
        String str3="hello world";
        String str4="this is me!";

        // "1234".hashcode() ==1509442
        String pass=inp.next();
        if(pass.hashCode()==1509442){
            System.out.println("logged in!");
        }

        System.out.println(str2.indexOf("l"));
        System.out.println(str2.replace("l","X"));
        System.out.println(str2.replaceFirst("l","X"));
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());

        System.out.println(str3.concat(" ".concat(str4)));
        System.out.println(str3+" "+str4);
        System.out.println(1+2+str3+" "+str4+3+5);
        System.out.println(str2.hashCode());
        System.out.println(str2.contains("world"));
        String joinedStr=String.join(",",str2,str3,str4);
        System.out.println(joinedStr);

        StringBuffer strbuff=new StringBuffer("hello world");
        System.out.println(strbuff);
        System.out.println(strbuff.reverse());
        strbuff.replace(3,5,"");
        strbuff.delete(3,5);
    }
}
