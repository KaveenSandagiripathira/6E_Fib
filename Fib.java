/** 
  Calculate Fibonacci number n
  3 implementations
  @precondition: n >= 1
  
  Use type "long" instead of "int", because rabbits.
 */

public class Fib {
    /** 
      @return the nth Fibonacci number
              by implementing the recurrence relation
     */
    public static long fib_recurrence( int n) {
		if (n <= 2){
			return 1;
		}
		else{
			return fib_recurrence(n-1) + fib_recurrence(n-2);
		}
	}
     /* These are class / instance methods because...\
	 Class methods because the method call is irrelavant to instance specifications.
    */


    /** 
      @return the nth Fibonacci number
              calculated via the 8th-grade algorithm
     */
    public static long fib_grade8( int n) {
        if (n <= 1){
			return n;
		}
		int fib = 1;
		int prevFib = 1;
		for(int i=2; i<n; i++) {
			int temp = fib;
			fib+= prevFib;
			prevFib = temp;
		}
		return fib;
		
    }
    /* Time complexity:
       Consider the size of the problem to be n
       
       As the proxy for the time required, count the number of for loops
       
       Then cost of the the recurrence algorithm
       grows linearly
       as the size of the problem increases,
       because as the input, n, grows, the for loop that exists will
	   continue to iterate more linearly. 
     */


    /** 
      @return the nth Fibonacci number
              calculated via Binet's formula.
              Type is double so that this exercise can
              ignore rounding issues.
     */
    public static double fib_Binet( int n) {
		long start = System.nanoTime();
        double phi = (1 + Math.sqrt(5))/2 ;
		double psi = -1/phi ;
		double ans = (Math.pow(phi,n) - Math.pow(psi,n))/Math.sqrt(5);
		long end = System.nanoTime();
		System.out.println("Elapsed Time:" + end-start);
		return ans;
    }
    /* Time complexity:
       Consider the size of the problem to be n
       
       As the proxy for the time required, count the amount of calls to Math.pow(phi,n)
       
       Then cost of the the recurrence algorithm
       grow at constant 
       as the size of the problem increases,
       because Math.pow(phi,n) is an constant operation that uses power series
	   no matter the size n. 
     */
}
