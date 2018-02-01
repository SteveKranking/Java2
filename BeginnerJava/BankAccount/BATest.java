public class BATest{
    public static void main(String[] args) {
        BA myBank = new BA(1, 2);
        BA myBank2 = new BA(100, 100);

        System.out.println("Bank Account 1: ");
        System.out.println("id: " + myBank.accountNum);
        System.out.println("Checking: " + myBank.checking);
        System.out.println("Saving: " + myBank.saving);
        myBank.deposit(1, 99999);
        myBank.withdraw(1, 1000);
        myBank.withdraw(2, 100000);
        System.out.println("The total in your account is: " + myBank.totalInAccount());

        System.out.println(BA.numAccounts);
        System.out.println("Total in all accounts is: " + BA.total);
        
    
    }
}
