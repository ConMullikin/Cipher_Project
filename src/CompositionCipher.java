import java.util.ArrayList;

/**
 * Class for Composition ciphers, which use Caesar and Vigenere Ciphers for encryption/decryption
 * @author Connor Mullikin and Matthew Hase
 */
public class CompositionCipher extends Cipher {
    /**
     * Contains all the object's Caesar and Vigenere Ciphers
     */
    ArrayList<Cipher> ciphers;

    /**
     * Constructor that initializes an empty list of ciphers
     */
    public CompositionCipher() {
        ciphers = new ArrayList<>();
    }

    /**
     * Constructor that copies the ciphers of another existing CompositionCipher object
     * @param other
     */
    public CompositionCipher(CompositionCipher other) {
        this.ciphers = new ArrayList<>();

        for (Cipher iterateCiphers : other.ciphers) {
            this.ciphers.add(iterateCiphers.newCopy());
        }
    }

    /**
     * Encrypts a character using the ciphers in the object's ArrayList
     * @param c
     * @return
     */
    public char encrypt(char c) {
        for (Cipher cipher : ciphers) {
            c = cipher.encrypt(c);
        }
        return c;
    }

    /**
     * Decrypts a character using the ciphers in the object's ArrayList
     * @param c
     * @return
     */
    public char decrypt(char c) {
        for(int i = ciphers.size() - 1; i >= 0; i--) {
            c = ciphers.get(i).decrypt(c);
        }
        return c;
    }

    /**
     * Deep copy constructor of the class
     * @return
     */
    public Cipher newCopy() { return new CompositionCipher(this); }

    /**
     * Adds a new Caesar or Vigenere cipher to the end of the object's ArrayList of ciphers
     * @param theCipher
     */
    public void add(Cipher theCipher) {
        Cipher cipher = theCipher;
        ciphers.add(cipher);
    }
}
