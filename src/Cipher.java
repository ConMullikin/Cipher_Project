public abstract class Cipher {
    public abstract char encrypt(char c);

    public String encrypt(String s) {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            cipher.append(encrypt(s.charAt(i)));
        }
        return cipher.toString();
    }

    public abstract char decrypt(char c);

    public String decrypt(String s) {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            cipher.append(decrypt(s.charAt(i)));
        }
        return cipher.toString();
    }

    public abstract Cipher newCopy();
}
