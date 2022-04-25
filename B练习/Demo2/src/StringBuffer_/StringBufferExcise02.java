package StringBuffer_;

public class StringBufferExcise02 {
    public static void main(String[] args) {
        String price = "12345678.9";
        StringBuffer stringBuffer = new StringBuffer(price);
        for (int i = stringBuffer.lastIndexOf(".")-3; i>0; i -= 3){
            stringBuffer.insert(i,",");
        }
        System.out.println(stringBuffer);
    }
}

