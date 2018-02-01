public class SLL {
   
    public Node head;

    public SLL() {
        this.head = null;
    }

    public void add(int value) {

        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = newNode;
        }

        else {

        Node runner = this.head;

        while(runner.next != null) {
            runner = runner.next;
        }
        runner.next = newNode;

        }

    }

    public void remove(SLL list) {

        if (this.head == null) {
            System.out.println("there is no list");
        }
        else if (this.head.next == null) {
            System.out.println("Only one value in list");
        }
        else {
            
            Node runner = this.head;

            while (runner.next.next != null) {
                runner = runner.next;
            }
                runner.next = null;
        }

    }

    public void printedValues(SLL list) {

        if (this.head == null) {
            System.out.println("there is no list");
        }
        else if (this.head.next == null) {
            System.out.println("Only one value in list");
        }
        else {
            Node runner = this.head;

            while (runner != null) {
                System.out.println(runner.value + " ");
                runner = runner.next;
            }
        }

    }


}