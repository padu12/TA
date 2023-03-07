import java.math.BigInteger;
import java.time.LocalTime;
import java.time.Duration;
 
public class Test {
	
	  private static long calculateWithFor(int n) {
	        long first = 0;
	        long second = 1;
	        long result = n;
	        for (int i = 1; i < n; i++) {
	            result = first + second;
	            first = second;
	            second = result;
	        }
	        return result;
	    }
	  
	  private static long recursive(int n) {
	        if (n <= 1) {
	            return n;
	        }
	        return recursive(n - 2) + recursive(n - 1);
	    }
	  
	    private static double Bine(double n) {
	    	double k=(1+Math.sqrt(5))/2;
	    	double first = Math.pow(k,n);
	    	double z=(1-Math.sqrt(5))/2;
	    	double second =  Math.pow(z,n);
	    	double result = (first+second)/Math.sqrt(5);
	             
	        return result;
	    }
	
	    
	// ìàòðè÷íîå óìíîæåíèå äâóõ ìàòðèö ðàçìåðà 2 íà 2
	public static BigInteger[][] matrixMultiplication(BigInteger[][] a, BigInteger[][] b) {
		// [a00 * b00 + a01 * b10, a00 * b01 + a01 * b11]
		// [a10 * b00 + a11 * b10, a10 * b01 + a11 * b11]
		return new BigInteger[][]{
				{
						a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])),
						a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))
				},
				{
						a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])),
						a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))
				},
		};
	}
 
	// âîçâåäåíèå ìàòðèöû ðàçìåðà 2 íà 2 â ñòåïåíü n
	public static BigInteger[][] matrixPowerFast(BigInteger[][] a, int n) {
		if (n == 0) {
			// ëþáàÿ ìàòðèöà â íóëåâîé ñòåïåíè ðàâíà åäèíè÷íîé ìàòðèöå
			return new BigInteger[][]{
					{BigInteger.ONE, BigInteger.ZERO},
					{BigInteger.ZERO, BigInteger.ONE}
			};
		} else if (n % 2 == 0) {
			// a ^ (2k) = (a ^ 2) ^ k
			return matrixPowerFast(matrixMultiplication(a, a), n / 2);
		} else {
			// a ^ (2k + 1) = (a) * (a ^ 2k)
			return matrixMultiplication(matrixPowerFast(a, n - 1), a);
		}
	}
 
	// ôóíêöèÿ, âîçâðàùàþùàÿ n-îå ÷èñëî Ôèáîíà÷÷è
	public static BigInteger fibonacci(int n) {
		if (n == 0) {
			return BigInteger.ZERO;
		}
 
		BigInteger[][] a = {
				{BigInteger.ONE, BigInteger.ONE},
				{BigInteger.ONE, BigInteger.ZERO}
		};
		BigInteger[][] powerOfA = matrixPowerFast(a, n - 1);
		// nthFibonacci = powerOfA[0][0] * F_1 + powerOfA[0][0] * F_0 = powerOfA[0][0] * 1 + powerOfA[0][0] * 0
		BigInteger nthFibonacci = powerOfA[0][0];
		return nthFibonacci;
	}
	
	
 
	public static void main(String[] args) {
		int n=200;
//		LocalTime localTime1 = LocalTime.now();	
//        System.out.print("Ðåêóðñèÿ " + recursive(n));
//        LocalTime localTime2 = LocalTime.now();
//        Duration duration1 = Duration.between(localTime1, localTime2);
//        System.out.println(", âðåìÿ âûïîëíåíèÿ - " + duration1);

        LocalTime localTime3 = LocalTime.now();
        System.out.print("Öèêë for " + calculateWithFor(n));
        LocalTime localTime4 = LocalTime.now();
        Duration duration2 = Duration.between(localTime3, localTime4);
        System.out.println(", âðåìÿ âûïîëíåíèÿ - " + duration2);
        
        LocalTime localTime5 = LocalTime.now();
        System.out.print("Ôîðìóëà " + Bine(n));
        LocalTime localTime6 = LocalTime.now();
        Duration duration3 = Duration.between(localTime5, localTime6);
        System.out.println(", âðåìÿ âûïîëíåíèÿ - " + duration3);
		
		
		 LocalTime localTime7 = LocalTime.now();
		System.out.print("Óìíîæåíèå ìàòðèö  "+ fibonacci(n));
		 LocalTime localTime8 = LocalTime.now();
		 Duration duration4 = Duration.between(localTime7, localTime8);
	     System.out.println(", âðåìÿ âûïîëíåíèÿ - " + duration4);
	     
	}
}