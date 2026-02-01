package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}
	
		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}
	
		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}
	
		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	
		
		if (this.number.isEmpty()) { // replace empty strings with a single zero
			this.number = "0";
		}
  		
	}
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}

	//Code for the Design section starts here ---

	/**
	*Binary or function
	*/
	public static Binary OR(Binary x, Binary y){
		//padding the binary numbers with zero if there is a length difference
		String bin1 = x.getValue();
		String bin2 = y.getValue();
		int xLength = bin1.length();
		int yLength = bin2.length();
		int maxLength = Math.max(xLength, yLength);
		// Pad the shorter binary string with leading zeros
		while (bin1.length() < maxLength) {
			bin1 = "0" + bin1;
		}
		while (bin2.length() < maxLength) {
			bin2 = "0" + bin2;
		}
		String result = "";
		for (int i = 0; i < maxLength; i++) {
			if (bin1.charAt(i) == '1' || bin2.charAt(i) == '1') {
				result += "1";
			} else {
				result += "0";
			}
		}
		return new Binary(result);
	}

	/**
	 * Binary AND function
	 */
	public static Binary AND(Binary x, Binary y){
		//padding the binary numbers with zero if there is a length difference
		String bin1 = x.getValue();
		String bin2 = y.getValue();
		int xLength = bin1.length();
		int yLength = bin2.length();
		int maxLength = Math.max(xLength, yLength);
		// Pad the shorter binary string with leading zeros
		while (bin1.length() < maxLength) {
			bin1 = "0" + bin1;
		}
		while (bin2.length() < maxLength) {
			bin2 = "0" + bin2;
		}
		String result = "";
		for (int i = 0; i < maxLength; i++) {
			if (bin1.charAt(i) == '1' && bin2.charAt(i) == '1') {
				result += "1";
			} else {
				result += "0";
			}
		}
		return new Binary(result);
	}
	/**
	 * Binary Multiply function
	 */
	public static Binary Multiply(Binary x, Binary y) {
    	String binX = x.getValue();
    	String binY = y.getValue();

    	Binary result = new Binary("0");

    	// Process bits from right to left (LSB to MSB)
    	int shift = 0;
    	for (int i = binY.length() - 1; i >= 0; i--) {
    	    if (binY.charAt(i) == '1') {
    	        // Append 'shift' number of zeros to x
    	        String shifted = binX + "0".repeat(shift);
    	        result = Binary.add(result, new Binary(shifted));
    	    }
    	    shift++;
    	}

    	return result;
	}

}	