import java.util.ArrayList;

public class CompositionCipher extends Cipher {
    ArrayList<Cipher> ciphers;

    public CompositionCipher() {
        ciphers = new ArrayList<>();
    }

    public CompositionCipher(CompositionCipher other) {
        ciphers = new ArrayList<>();
        for (Cipher otherCiphers : other.ciphers) {
            ciphers.add(otherCiphers);
        }
    }

    public char encrypt(char c) {
        for (Cipher cipher : ciphers) {
            c = cipher.encrypt(c);
        }
        return c;
    }

    public char decrypt(char c) {
        for(int i = ciphers.size() - 1; i >= 0; i--) {
            c = ciphers.get(i).decrypt(c);
        }
        return c;
    }

    public Cipher newCopy() { return new CompositionCipher(this); }

    public void add(Cipher theCipher) {
        Cipher cipher = theCipher;
        ciphers.add(cipher);
    }
}
