// LeetCode #166 Fraction to Recurring Decimal
//Time: O(n), Space: O(n)
/*
Given two integers representing the numerator and denominator of a fraction, return the fraction
in string format. If the fractional part is repeating, enclose the repeating part in parentheses.
For example,
Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
    	StringBuilder result = new StringBuilder();
    	if (numerator == 0) {
    		return "0";
    	}
    	// sign
    	result.append((numerator > 0 ^ denominator > 0) ? "-" : "");   
    		// in case of overflow
    	long num = Math.abs((long)numerator);
    	long den = Math.abs((long)denominator);  
    	// integral part
    	long integ = num / den;
    	long remainder = num % den;
    	result.append(integ);
    	if (remainder == 0) {
    		return result.toString();
    	}
    	// fractional part
    	result.append(".");
    	HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    	   // use result's length to get current index
    	map.put(remainder, result.length()); 
    	while (remainder != 0) {
    		result.append(remainder * 10 / den);
    		remainder = remainder * 10 % den;
    		if (map.containsKey(remainder)) {
    			result.insert(map.get(remainder), "(");
    			result.append(")");
    			break;
    		}
    		map.put(remainder, result.length());
    	}
    	return result.toString();
    }
}


/* 
Notes:
1. Rational and Irrational Numbers
Rational numbers can be expressed as fraction, while irrational numbers cannot. Rational
numbers do not terminate but repeat, while irrational numbers do not terminate or repeat.

2. Division Rule
For rational numbers, whenever a same remainder comes up, we know there is a repeating 
fractional part. For example: 1/7 = 0.(142857)
    1/7 = 0...1
    1*10/7 = 1...3
    3*10/7 = 4...2
    2*10/7 = 2...6
    6*10/7 = 8...4
    4*10/7 = 5...5
    5*10/7 = 7...1
    1*10/7 = 1...3
    3*10/7 = 4...2

3. XOR 
A   B   Output
T   F      T
T   T      F
F   F      F
F   T      T

4. Simple If Sentence
condition ? do : else

5. Overflow Cases
Use long to store integer to avoiding possible overflow

6. HashMap
HashMap<keyType, valueType> Name = new HashMap<keyType, valueType>();
map.put(key, value);
map.get(key);
map.containsKey(key);
*/

