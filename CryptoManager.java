public class CryptoManager {
	
	private static final char LOWER_BOUND = ' '; //Sets Lower Bound equal to space, which has an ASCII value of 32
	private static final char UPPER_BOUND = '_'; //Sets Upper Bound equal to underscore, which has an ASCII value of 95
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1; //Sets Range equal to the upper bound - lower bound plus 1, which equals to 64

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) { //Tests whether the string is in the bounds of the ASCII values
		boolean inBounds = true; //Declares a boolean called inBounds
		for (int i = 0; i < plainText.length() && inBounds; i++) //For-Loop that runs as long as the i value is less than the string and inBounds is true
		{
			if (plainText.charAt(i) >= LOWER_BOUND && plainText.charAt(i) <= UPPER_BOUND) //If the ASCII value of each character is lower than the upper bound and is lower than the upper bound, return true, else return false.
			{
				inBounds = true;
			}
			else
			{
				inBounds = false;
			}
		}
		return inBounds; 
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String caesarEncryptedText = ""; //Sets an empty string for the encrypted Caesar text
		char k; //Creates a char variable called k, to hold the letters to add to the encrypted text.
		for(int i = 0; caesarEncryptedText.length() < plainText.length(); i++) //For loop that runs as long as the encrypted string is less than the user-inputted String
		{
			k = encrypter(plainText.charAt(i), key, true); //Passes the value for each index-char, with the user inputted key, to the encrypter method.
			caesarEncryptedText += k; // The empty string is now filling up with the values inputted into the char variable
		}
		return caesarEncryptedText; //Returns full encrypted text
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String bellasoEncryptedText = ""; //Sets an empty string for the encrypted Bellaso text
		int j; //Declare a value known as j to use in nested for-loop
		for (int i = 0; bellasoEncryptedText.length() < plainText.length();) //For loop that runs as long as the encrypted Bellaso Text is shorter than user-inputed string
		{
			for(j = 0; j < bellasoStr.length() && bellasoEncryptedText.length() < plainText.length(); j++, i++) //For loop that runs as long as the user-inputted key value is less than j and the Encrypted bellaso text is shorter than user input, increase j and i by 1
			{
				char c = encrypter(plainText.charAt(i), bellasoStr.charAt(j), true); //Pass the i value for the user string, the j value for the user key string
				bellasoEncryptedText += c; //Each char is now added to the bellaso encrypted Text to fill it 
			}
			j = 0; //Reset j to 0 in order to account for the bellasoStr to fill in for all of the user-inputted String
		}
		return bellasoEncryptedText; //Returns full encrypted Bellaso text
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String caesarDecryptedText = ""; //Give empty string for decrypted Text
		for(int i = 0; caesarDecryptedText.length() < encryptedText.length(); i++) //For-Loop that works as long as decrypted text is less than the encrypted text, and increments i by 1
		{
			char c = encrypter(encryptedText.charAt(i), key, false); //Passes variables to encrypter method, i corresponding to the char-array value and key the user inputted integer
			caesarDecryptedText += c; //Char variables added to decrypted text
		}	
		return caesarDecryptedText; //Returns the full decrypted Caesar text
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String bellasoDecryptedText = ""; //Gives empty string for Bellaso decrypted Text
		for(int i = 0; bellasoDecryptedText.length() < encryptedText.length();) //For-Loop that works as long as the decrypted bellaso string is less than that of the encrypted text
		{
			for(int k = 0; k < bellasoStr.length() && bellasoDecryptedText.length() < encryptedText.length(); k++, i++) //For loop that runs as long as the user-inputted key value is less than j and the Encrypted bellaso text is shorter than user input, increase j and i by 1
			{
				char c = encrypter(encryptedText.charAt(i), bellasoStr.charAt(k), false); //Pass the i value for the user string, the j value for the user key string
				bellasoDecryptedText += c; //Adds characters to the decrypted Bellaso String
			}
		}
		return bellasoDecryptedText; //Returns full Decrypted Bellaso Text
	}
	
	private static char encrypter(char c, int key, boolean Encrypt)
	{
		int charInt = (int)c; //Fetches the actual ASCII value of the char, becomes a integer
		if (Encrypt) //If Encrypt is true, AKA the value needs to be encrypted
		{
			charInt += key; //Adds the int key value to the charInt value to get new char value
			while(charInt > UPPER_BOUND) //FOR BELLASO CIPHER, while loop for when the charInt value is higher than the upper Bound
				charInt -= RANGE; //Subtract the range from the charInt value, to get a new char Value within the bounds
		}
		else //If the text needs to be decrypted
		{
			charInt -= key; //Subtracts the key value from the charInt value to get new char value
			while(charInt < LOWER_BOUND) //FOR BELLASO CIPHER, while loop for when the charInt value is higher than the lower Bound
				charInt += RANGE; //Add the range from the charInt value, to get a new char Value within the bounds
		}
		return (char)charInt; //Returns full decrypted char value.
	}
}
