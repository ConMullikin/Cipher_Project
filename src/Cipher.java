import java.util.Scanner;

public abstract class Cipher {
    public abstract char encrypt(char c);

    public String encrypt(String s) {
        Scanner scn = new Scanner(s);
        StringBuilder cipher = new StringBuilder();
        scn.useDelimiter(".");

        while (scn.hasNext()) {
            cipher.append(encrypt(scn.next()));
        }
        return cipher.toString();
    }

    public abstract char decrypt(char c);

    public String decrpyt(String s) {
        Scanner scn = new Scanner(s);
        StringBuilder cipher = new StringBuilder();
        scn.useDelimiter(".");

        while (scn.hasNext()) {
            cipher.append(decrpyt(scn.next()));
        }
        return cipher.toString();
    }

    public abstract Cipher newCopy();
}
