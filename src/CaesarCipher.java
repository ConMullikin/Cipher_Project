
public class CaesarCipher extends Cipher {
	/**
	 * Refers to the number of letters in the English alphabet
	 */
	private final static int NUM_LETTERS = 26;

	/**
	 * Refers to the number of spaces in the alphabet a letter should be shifted during encryption or decryption
	 */
	private final int shiftAmount;
	
	/**
	 * This is a Constructor for a CaesarCipher object
	 * @param amt - the distance to shift letters when encrypting
	 */
	public CaesarCipher(int amt){
		shiftAmount = amt;
	}

	/**
	 * A Copy Constructor for a CaesarCipher object, which makes a deep copy based on another CaesarCipher as an
	 * argument
	 * @param other refers to another CaesarCipher whose class variable values will be copied over to the new
	 *              CaesarCipher entity
	 */
	public CaesarCipher(CaesarCipher other){
		this.shiftAmount = other.shiftAmount;
	}

	/**
	 * This encrypt() method checks to see if a given character argument is alphabetic and if so, whether it is
	 * uppercase or not. It then shifts the letter the amount defined during the CaesarCipher declaration
	 * @param c refers to the character being encrypted. Non-alphabetic characters are simply returned
	 * @return the encrypted character after it has been shifted the proper amount
	 */
	@Override
	public char encrypt(char c) {
		if(Character.isAlphabetic(c)){
			final char base = (Character.isLowerCase(c) ? 'a' : 'A');		
			// c - base is the index in the alphabet: 'a' becomes 0, 'b' becomes 1, etc.
			return (char)(base + ((c - base + shiftAmount) % NUM_LETTERS));
		}
		else{
			return c;
		}
	}

	/**
	 * This decrypt() method checks to see if a character is alphabetic and if so, whether it is uppercase or not.
	 * It then shifts the letter the appropriate amount to obtain the original, unencrypted letter. Non-alphabetic
	 * characters are simply returned
	 * @param c refers to the encrypted character which needs to be decrypted to be identified
	 * @return the original, unencrypted letter endemic to the message
	 */
	@Override
	public char decrypt(char c) {
		if(Character.isAlphabetic(c)){
			final char base = (Character.isLowerCase(c) ? 'a' : 'A');			
			return (char)(base + ((c - base - shiftAmount + NUM_LETTERS) % NUM_LETTERS));
		}
		else{
			return c;
		}
	}

	/**
	 * This method returns a new deep copy of the current CaesarCipher
	 * @return a new copy of the current CaesarCipher
	 */
	// Returns a new object, a deep copy of the current object
	@Override
	public Cipher newCopy() {
		return new CaesarCipher(this);
	}

}
