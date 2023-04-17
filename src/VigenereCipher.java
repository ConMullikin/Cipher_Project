import java.util.ArrayList;

/**
 * Class for Vigenere Ciphers, which use Caesar ciphers for encryption/decryption
 * @author Connor Mullikin and Matthew Hase
 */
public class VigenereCipher extends Cipher {
	/**
	 * Contains all the object's Caesar ciphers
	 */
	private ArrayList<CaesarCipher> subCiphers;

	/**
	 * Stores integers used to determine which index values are next in line for encryption/decryption
	 */
	private int nextIndexForEncrypt;
	private int nextIndexForDecrypt;

	/**
	 * Constructor that uses an iterable list of shiftAmounts to initialize the object's list of CaesarCiphers
	 * @param shiftAmounts
	 */
	public VigenereCipher(Iterable<Integer> shiftAmounts){
		nextIndexForEncrypt = 0;
		nextIndexForDecrypt = 0;
		
		subCiphers = new ArrayList<>();
		for(Integer amt : shiftAmounts){
			subCiphers.add(new CaesarCipher(amt));
		}
	}

	/**
	 * Constructor that copies the ciphers and values stored in another existing VigenereCipher object
	 * @param other
	 */
	public VigenereCipher(VigenereCipher other){
		this.nextIndexForEncrypt = other.nextIndexForEncrypt;
		this.nextIndexForDecrypt = other.nextIndexForDecrypt;

		this.subCiphers = new ArrayList<>();
		for (CaesarCipher otherCipher : other.subCiphers) {
			this.subCiphers.add(new CaesarCipher(otherCipher));
		}
	}

	/**
	 * Encrypts a character using the ciphers in the object's ArrayList
	 * @param c
	 * @return
	 */
	@Override
	public char encrypt(char c) {
		char res = subCiphers.get(nextIndexForEncrypt).encrypt(c);
		nextIndexForEncrypt = (nextIndexForEncrypt + 1) % subCiphers.size();
		return res;
	}

	/**
	 * Decrypts a character using the ciphers in the object's ArrayList
	 * @param c
	 * @return
	 */
	@Override
	public char decrypt(char c) {
		char res = subCiphers.get(nextIndexForDecrypt).decrypt(c);
		nextIndexForDecrypt = (nextIndexForDecrypt + 1) % subCiphers.size();
		return res;
	}

	/**
	 * Deep copy constructor of the class
	 * @return
	 */
	@Override
	public Cipher newCopy() {
		return new VigenereCipher(this);
	}

}
