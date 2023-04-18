public abstract class Cipher {

    /**
     * This abstract method is implemented by all child classes of the Cipher class, with each class possessing their
     * own method definition (i.e. CaesarCipher's encrypt() method body varies from VigenereCipher's and
     * CompositionCipher's.) The general purpose of this method is to take a (presumably alphabetic) character
     * from a message and "shift it" systematically a number of spaces to encrypt said message.
     * @param c refers to the character being encrypted
     * @return is the character after it has been encrypted through transformation of the system amounts
     */
    public abstract char encrypt(char c);

    /**
     * Similar to the method encrypt() for characters, except this method takes a String as an argument and iterates
     * through each character, applying the character encrypt() method to each alphabetic character and appending
     * each shifted letter to a StringBuilder.
     * @param s is the String whose alphabetic characters will be shifted and appended to the StringBuilder
     * @return is the appended StringBuilder's associated String calling its default toString() method
     */
    public String encrypt(String s) {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            cipher.append(encrypt(s.charAt(i)));
        }
        return cipher.toString();
    }

    /**
     * This abstract method is inherited by all child classes of Cipher, and hence each of the child classes
     * possesses its own unique method definition. The purpose of this method is to take a previously encrypted
     * alphabetic character and decrypt it back to its original letter, generally in the context of a message.
     * @param c refers to the encrypted character which needs to be decrypted to be identified
     * @return is the decrypted character endemic to the original message
     */
    public abstract char decrypt(char c);

    /**
     * This method is similar to the decrypt() method for characters, but instead iterates through each alphabetic
     * character in an entire String (which is intended to be an encrypted message) and employs the character decrypt()
     * method to obtain each original letter, which is appended to a StringBuilder to obtain the original message
     * @param s refers to the encrypted String message which must be decrypted
     * @return is the associated String to the StringBuilder, obtained by calling the toString() method
     */
    public String decrypt(String s) {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            cipher.append(decrypt(s.charAt(i)));
        }
        return cipher.toString();
    }

    /**
     * An abstract method whose purpose in each child class is to create a new Cipher copy of the given Object
     * type
     * @return is a general Cipher (which can be of any type of the inherited child classes)
     */
    public abstract Cipher newCopy();
}
