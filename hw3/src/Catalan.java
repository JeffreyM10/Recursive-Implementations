public class Catalan {
    public static int SIZE = 36;
    public static Long[] c = new Long[SIZE];
    public static long c(int n) {
   	 if(c[n] == null) {
   		 if (n == 0)
   			 c[n] = 1L;
   		 else
   			 c[n] =  c(n -1) * ((4 * (n-1)) + 2)  / ((n-1) + 2);
   	 }
   	 return c[n];
    }
    public static void main(String[] args) {
   	 for(int n = 0; n < SIZE; n++)
   		 System.out.printf("c(%d) = %d\n",n, c(n));
    }
}
