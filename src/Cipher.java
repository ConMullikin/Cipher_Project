import java.util.Scanner;

public abstract class Cipher {

    /**
     * This abstract method is implemented by all child classes of the Cipher class, with each class possessing their
     * own method definition (i.e. CaesarCipher's encrypt() method body varies from VigenereCipher's and
     * CompositionCipher's.) The general purpose of this method is to take a (presumably alphabetic) character
     * from a message and "shift it" systematically to encrypt said message.
     * @param c refers to the character being encrypted
     * @return is the character after it has been encrypted through transformation of the system amounts
     */
    public abstract char encrypt(char c);

    /**
     * Similar to the encrypt() method for characters, except this method is used to apply
     * @param s
     * @return
     */
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

    public String decrypt(String s) {
        Scanner scn = new Scanner(s);
        StringBuilder cipher = new StringBuilder();
        scn.useDelimiter(".");

        while (scn.hasNext()) {
            cipher.append(decrypt(scn.next()));
        }
        return cipher.toString();
    }

    public abstract Cipher newCopy();
}
