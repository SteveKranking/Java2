import java.util.ArrayList;
public class AL {
    public void firstFor() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    public void forOdds() {
        for (int i = 1; i <= 255; i+=2) {
            System.out.println(i);
        }
    }

    public void sums() {
        int sums = 0;
        for (int i = 1; i <= 255; i++) {
            sums = sums + i;
            System.out.println("New Number: " + i + " New Sum: " + sums);
        }
    }

    public void thruArray(int[] x) {
        
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }

    }

    public void findMax(int[] x) {
        int max = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }
        System.out.println(max);

    }

    public void findAvg(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum = sum + x[i];
        }
        double avg = sum / x.length;
        System.out.println(avg);

    }

    public void arrayOdds() {
        
        ArrayList<Integer> myArray = new ArrayList<Integer>();

        for (int i = 1; i <= 255; i++) {
            myArray.add(i);
        }
        System.out.println(myArray);
    }


}