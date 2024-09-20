package Sums;

public class StringNumbers {
    public static void main(String[] args) {
        String str="occurrence";
        String name="";
        char[] ch=str.toCharArray();
char[] ch1=new char[ch.length];
        for(int i=0;i<ch.length;i++) {
            int count=1;

            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i]==ch[j]){
                    count++;
                    ch[j]='\n';

                }
            }
            if(ch[i]!='\n') {
//                System.out.print(ch[i]);
//                System.out.print(count);
                ch1[i]=ch[i];
            }

        }
for(int i=0;i<ch1.length;i++){
    System.out.print(ch1[i]);
}
    }
}
