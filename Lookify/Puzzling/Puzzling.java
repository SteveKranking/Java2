import java.util.Arrays;
import java.util.Random;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Puzzling {
    public static void main(String[] args){
        int[] myArray ={3,5,1,2,7,9,8,13,25,32};
        int sum = 0;
        for (int i = 0; i< myArray.length; i++){
            sum += myArray[i];
            if ( myArray[i] > 10){
                System.out.println(myArray[i]);
            }
        }
        System.out.println(sum);

        String[] solutionArray = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        shuffleArray(solutionArray);
        for (int i = 0; i < solutionArray.length; i++)
        {
          System.out.print(solutionArray[i] + " ");
        }
        System.out.println();
      


      String[] alphabet= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
      shuffleArray(alphabet);
      System.out.print(alphabet[0]);
      System.out.print(alphabet[alphabet.length-1]);

      if(alphabet[0]=="a" ||alphabet[0]=="e"||alphabet[0]=="i"||alphabet[0]=="o"||alphabet[0]=="u"){
        System.out.print("   winner winner chicken dinner");
      }
    

        double[] random;
      random = new double[10];
      Random randomly = new Random();
      for( int i = 0; i < random.length; i++){
        
        random[i]=55+randomly.nextInt(45);
      }

      for (int i=0; i< random.length; i++){
          for(int x=0; x< random.length-i-1; x++){
              if(random[x]> random[x+1]){
                double temp = random[x];
                random[x] = random[x+1];
                random[x+1] = temp;
              }
          }
      }
      System.out.print(Arrays.toString(random));
    
      String[] alpha= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
      String rando = "";
      for(int i=0; i < 5; i++){
          int position= randomly.nextInt(25);
          String newChar= alpha[position];
          rando += newChar;
      }
      System.out.print(rando);


    }
    
      // Implementing Fisher�Yates shuffle
      static void shuffleArray(String[] ar)
      {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          // Simple swap
          String a = ar[index];
          ar[index] = ar[i];
          ar[i] = a;
        }
      }
   

      
    
    }