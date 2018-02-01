public class ListTester {
    public static void main(String[] args) {
        SLL list = new SLL();
        list.add(3);
        list.add(5);
        list.add(12);
        list.add(17);
        // System.out.println(list);
        list.remove(list);
        list.printedValues(list);
    }
}