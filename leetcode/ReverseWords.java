package leetcode;

//151. Reverse Words in a String



public class ReverseWords {

    public static String reverseWords(String s) {
    s= s.trim();
    StringBuilder str = new StringBuilder();

    String[] strArr = s.split(" ");

    for(int i=strArr.length-1;i>=0;i--){

        if(!strArr[i].equals(" ") && !strArr[i].isBlank() && !strArr[i].isEmpty()){
            System.out.println("element "+strArr[i].length()+"-");

            if(i==0){
                str.append(strArr[i].trim());
            }else{
                str.append(strArr[i].trim()+" ");
            }
        }
    }
    return str.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        reverseWords(s);
    }
}
