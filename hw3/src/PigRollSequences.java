public class PigRollSequences {
    public static final int SIZE = 51;
    public static int[] getNumSequences = new int[SIZE];
    public static int getNumSequences(int turnTotal) {
   	 if (getNumSequences[turnTotal] == 0) {
   		 if (turnTotal == 0)
   			 getNumSequences[0] = 1;
   		 else if (turnTotal == 1)
   			 getNumSequences[1] = 0;
   		 else if (turnTotal == 2)
   			 getNumSequences[2] = 1;
   		 else if (turnTotal == 3)
   			 getNumSequences[3] = 1;
   		 else if (turnTotal == 4)
   			 getNumSequences[4] = 2;
   		 else if (turnTotal == 5)
   			 getNumSequences[5] = 3;
   		 else
   			 getNumSequences[turnTotal] = getNumSequences(turnTotal - 2) + getNumSequences(turnTotal - 3) + getNumSequences(turnTotal - 4)+ getNumSequences(turnTotal - 5)+ getNumSequences(turnTotal - 6);
   		 
   	 }
   	 return getNumSequences[turnTotal];
    }
    public static void main(String[] args) {
   	 for (int i = 0; i < SIZE;i++)
   		 System.out.printf("%d turns = %d sequences\n", i, getNumSequences(i));
   	 System.out.println();
    }

}



