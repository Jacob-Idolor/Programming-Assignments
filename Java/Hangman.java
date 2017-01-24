import java.util.*;
public class Hangman {
   public static void main(String[] args) throws Exception {
 
   String[] words = new String[9];
   java.io.File wordfile = new java.io.File("words.txt");
 
   Scanner input = new Scanner(wordfile);
 
   int count = 0;
   while (input.hasNext()) {
      words[count] = input.next();
      /*System.out.print(words[count]);
      System.out.println(count);*/
      count++;
   }
      input.close();
      
      boolean allright = true;
      while (allright) {
      String chosen = words[(int)(Math.random() * 9)]; /*Change the Math.random number depending on the amount of words you have in your text file (ex. 5 words = Math.random()*6) (10 words = Math.random()*11) delete this comment */
      StringBuilder temp = new StringBuilder(chosen);
      
      
      for (int i = 0; i < chosen.length(); i++) 
         temp.setCharAt(i, '*');
      
      
      int numwrong = 0;
      
      while (true) {
         System.out.println("Enter a letter in a word " + temp);
         Scanner input2 = new Scanner(System.in);
         char guess = input2.next().charAt(0);
      
         int indexnum = chosen.indexOf(guess);
         
         if (indexnum == -1) {
            System.out.println(guess + " is not in the word");
            numwrong++;
         }
         else {
            if (indexnum >= 0) {
               if (chosen.charAt(indexnum) == temp.charAt(indexnum))
                  System.out.println(guess + " is already in word.");
               else {
                  temp.setCharAt(indexnum, guess);
                  while (indexnum > -1) {
                     indexnum = chosen.indexOf(guess, (indexnum+1));
                     System.out.println("index num = " + indexnum);
                     if (indexnum != -1)
                        temp.setCharAt(indexnum, guess);
                  }
               }
            }
         }
         
         int trucount = 0;
         for (int i = 0; i < chosen.length(); i++)
            if (temp.charAt(i) == chosen.charAt(i))
               trucount++;
         if (trucount == chosen.length()) {
            System.out.println("The word is " + temp + " You missed " + numwrong + " time(s).");
            break;
         }
      }
            System.out.println("Do you want to guess another word? Enter y or n.");
            Scanner input3 = new Scanner(System.in);
            char reply = input3.next().charAt(0);
            if (reply == 'n')
               allright = false;
            else
               allright = true;
         
      }
      
   }
   
   
}
