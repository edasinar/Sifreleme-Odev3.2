import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {
        String metin = "What is Lorem Ipsum? " + "Lorem Ipsum is simply dummy text of the printing and " +
                "typesetting industry. Lorem Ipsum has been the industry's " +
                "standard dummy text ever since the 1500s, when an unknown " +
                "printer took a galley of type and scrambled it to make a " +
                "type specimen book. It has survived not only five centuries, " +
                "but also the leap into electronic typesetting, " +
                "remaining essentially unchanged. "  +
                "It was popularised in the 1960s with the release of Letraset " +
                "sheets containing Lorem Ipsum passages, and more recently " +
                "with desktop publishing software like Aldus PageMaker " + "including versions of Lorem Ipsum.";

        System.out.println(metin.length());
        System.out.println("1) "+getHashMD5(metin));
        for(int i = 0; i < metin.length(); i++){
            StringBuilder metinBuild = new StringBuilder(metin);
            metinBuild.setCharAt(i, 'g');
            System.out.println((i+2)+") "+getHashMD5(metinBuild.toString()));
        }

    }

    public static String getHashMD5(String password){
        byte [] hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            hash = md.digest(password.getBytes());
        }

        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        StringBuilder strBuilder = new StringBuilder();

        for(byte b:hash) {
            strBuilder.append(String.format("%02x", b));
        }

        String strHash = strBuilder.toString();

        return strHash;
    }

}
