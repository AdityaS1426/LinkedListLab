package Lab;

import java.util.ArrayList;

public class LinkedList
{
    public static class Node
    {
        public Node next;
        int value;
        Node(int v)
        {
            this.value = v;
            this.next = null;
        }
    }
    public Node head;

    public void addNode(int value)
    {
        if (head == null)
        {
            head = new Node(value);
            return;
        }
        Node current = head;

        while(current.next != null)
        {
            current = current.next;
        }
        Node newNode = new Node(value);
        current.next = newNode;
    }

    public Object[] printList(Node n)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(n != null)
        {
            arr.add(n.value);
            n = n.next;
        }
        Object[] convarr = arr.toArray();
        return convarr;
    }

    Node paritionLast(Node start, Node end)
    {
        if (start == end || start == null || end == null)
        {
            return start;
        }
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.value;

        while(start != end)
        {
            if(start.value < pivot)
            {
                pivot_prev = curr;
                int temp = curr.value;
                curr.value = start.value;
                start.value = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        int temp = curr.value;
        curr.value = pivot;
        end.value = temp;

        return pivot_prev;
    }

    public void sort(Node start, Node end)
    {
        if (start == end )
        {
            return;
        }

        Node pivot_prev = paritionLast(start, end);

        sort(start, pivot_prev);

        if (pivot_prev != null && pivot_prev == start)
        {
            sort(pivot_prev.next, end);
        }
        else if (pivot_prev != null && pivot_prev.next != null)
        {
            sort(pivot_prev.next.next, end);
        }
    }

    public static void main(String[] args)
    {
        LinkedList testlist = new LinkedList();

        testlist.addNode(5);
        testlist.addNode(20);
        testlist.addNode(45);
        testlist.addNode(66);
        testlist.addNode(88);
        testlist.addNode(34);
        testlist.addNode(78);

        Node n = testlist.head;
        while (n.next != null)
        {
            n = n.next;
        }

        System.out.println("Unsorted List: ");
        testlist.printList(testlist.head);

        testlist.sort(testlist.head, n);

        System.out.println("Sorted List: ");
        testlist.printList(testlist.head);
    }
}