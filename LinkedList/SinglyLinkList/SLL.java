package DSA.LinkedList.SinglyLinkList;

import java.util.Scanner;

class SLL
{
    static void Insert()
    {

    }
    static void Search()
    {

    }
    static void Delete()
    {

    }
    static void Display()
    {

    }
    static void Count()
    {

    }
    static void Reverse()
    {

    }
    public static void main(String[] args)
    {
        SLL x = new SLL();
        Scanner sc = new Scanner(System.in);
        int ch=0;
        do
        {
            System.out.println("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Count\n6.Reverse\n7.Exit");
            System.out.println(">>> ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                    x.Insert();
                    break;
                case 2:
                    x.Search();
                    break;
                case 3:
                    x.Delete();
                    break;
                case 4:
                    x.Display();
                    break;
                case 5:
                    x.Count();
                    break;
                case 6:
                    x.Reverse();
                    break;
            }

        }while(ch != 7);
    }
}