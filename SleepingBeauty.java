import java.util.Random;

/**
    The answer to the sleeping beauty problem is one-third.
    Read the code and all of the comments, as the comments walk
    you through the mathematical proof alongside the proof in code.

    @Author Alex Cohen
    Github: ajcnyc
*/
public class SleepingBeauty {
     public static void main (String[] args) {
          int trials = 10000;
	  Random random = new Random();

          double[] headsTailsNeither = new double[3];
          for(int i=0; i<trials; i++){
	       
	       boolean wakeMondayOnly = false;
               boolean coinIsHeads = random.nextBoolean();
	       System.out.println(coinIsHeads);
               if(coinIsHeads) {
                   wakeMondayOnly = true;
               }

	       for(int day = 0; day <2; day++) {
		   if(day==0 || (day ==1 && wakeMondayOnly == false)){ // if wakes
			// If Wakes, That Means Either...
			if(coinIsHeads) { // It's Monday and Heads (1/4 chance)
			    headsTailsNeither[0]++;
	 		} else { // Or it's either Monday and Tails or Tuesday and Tails (2/4 chance)
			    headsTailsNeither[1]++;
			}
                   } else { // if not wakes
			headsTailsNeither[2]++; //It's Tuesday and Heads (1/4 chance)
                   }
               }
               

          }

	  // We disregard the case where not wakes (which is the Tuesday and heads case), 
	  // because we only care about what Sleeping Beauty should say when she wakes
	  //
	  // Therefore the probabilities are: 
	  // 1/4 chance of Monday and Heads out of 3/4 (Also known as one-third)
	  // 2/4 chance of Monday and Tails or Tuesday and Tails out of 3/4 (also known as two-thirds)
          // 
	  // Hence, the probability of heads is 1/3, and sleeping beauty should answer that the probability the coin landed heads is 1/3.
	  // Q.E.D.

	  System.out.println(headsTailsNeither[0]+" heads, "+headsTailsNeither[1]+" tails, and "+ headsTailsNeither[2]+" neither. Out of "+(trials*2)+" times woken up");
    	  System.out.println("probability of heads if woken up = "+ headsTailsNeither[0] + " out of " + (headsTailsNeither[0]+headsTailsNeither[1]) + " which equals: " + (headsTailsNeither[0]/(headsTailsNeither[0]+headsTailsNeither[1])));
    }
}
