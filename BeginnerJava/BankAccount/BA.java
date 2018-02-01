import java.util.Random;

public class BA {

    int accountNum;
    double checking;
    double saving;
    double totalInAccount;

    static double total = 0;
    static int numAccounts = 0;

    public BA( double checkingParam, double savingParam) {
        numAccounts++;
        accountNum = randomAccountNum();;
        checking = checkingParam;
        saving = savingParam;
        total = checking + saving;

    }

    private int randomAccountNum (){

        Random rand = new Random();

        this.accountNum = rand.nextInt(999999999) + 1;
        return accountNum;
    } 

    public double getChecking(){
        return checking;
    }
    public double getSaving(){
        return saving;
    }

    public void deposit(int account, double money){
        
        if(account == 1){
            this.checking = this.checking + money;
            total = total + money;
            System.out.println("Your checking account now has " + this.checking);
        }

        else if(account == 2){
            this.saving = this.saving + money;
            total = total + money;
            System.out.println("Your saving account now has " + this.saving);
        }

    }

    public void withdraw(int account, double money){

        if(account == 1){

            if(money > this.checking) {
                System.out.println("You don't have that much money in that account!"); 
            }

            else {
                this.checking = this.checking - money; 
                total = total - money;
                System.out.println("Your checking account now has " + this.checking);
            }
        }


        else if(account == 2){

            if(money > this.saving) {
                System.out.println("You don't have that much money in that account!"); 
            }
            
            else {
                this.saving = this.saving - money;
                total = total - money;
                System.out.println("Your saving account now has " + this.saving);
            }
        }
        
    }
    
    public double totalInAccount() {
        totalInAccount = getChecking() + getSaving();
        return totalInAccount;

    }
    
    
}