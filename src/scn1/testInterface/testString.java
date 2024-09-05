package scn1.testInterface;

public class testString {
    public static void main(String[] args) {
        testString test = new testString();
        System.out.println(test.replaceUnderLineAndUpperCase("CODE_GENERATOR"));
    }
    private String replaceUnderLineAndUpperCase(String str) {
        StringBuilder sb = new StringBuilder();
        boolean flagNextCharToUpperCase = false;//用于判断字符是否需要进行大小写转换
        for(int i=0;i<str.length();i++){
            char cur = str.charAt(i);
            if(cur == '_'){
                flagNextCharToUpperCase = true;
            }
            else {
                if(flagNextCharToUpperCase){
                    sb.append(Character.toUpperCase(str.charAt(i)));
                    flagNextCharToUpperCase = false;
                }
                else {
                    if(i == 0){
                        sb.append(Character.toUpperCase(str.charAt(i)));
                    }
                    else{
                        sb.append(Character.toLowerCase(str.charAt(i)));
                    }
                }
            }
        }
        return sb.toString();
    }
}
