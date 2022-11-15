package double_circle_linked_list;

import java.util.Scanner;

public class double_circle_linked_list {
	static class Node
	{
		int data;
		Node next;
		Node prev;
		Node(int data)
		{
			this.data=data;
			this.next=null;
			this.prev=null;
		}
	}
	Node head=null;
	Scanner sc=new Scanner(System.in);
	public void insertAtStart()
	{
		int data,n;
		do
		{
			System.out.print("Enter Data ");
			data=sc.nextInt();
			Node new_node=new Node(data);
			if(head==null)
			{
				head=new_node;
				new_node.next=head;
				new_node.prev=head;
			}
			else
			{
				head.prev.next=new_node;
				new_node.prev=head.prev;
				new_node.next=head;
				head.prev=new_node;
				head=new_node;
			}
			System.out.print("Press 1 For Insert ");
			n=sc.nextInt();
		}while(n==1);
	}
	public void insertAtEnd()
	{
		int data,n;
		do
		{
			System.out.print("Enter Data ");
			data=sc.nextInt();
			Node new_node=new Node(data);
			head.prev.next=new_node;
			head.prev.next.prev=head.prev;
			head.prev=new_node;
			new_node.next=head;
			System.out.print("Press 1 For Insert ");
			n=sc.nextInt();
		}while(n==1);
	}
	public void insertAtIndex()
	{
		int data,index,n,length=0;
		do
		{
			System.out.print("Enter Data ");
			data=sc.nextInt();
			System.out.print("Enter Index ");
			index=sc.nextInt();
			Node new_node=new Node(data);
			Node temp=head;
			while(length!=index-1)
			{
				temp=temp.next;
				length++;
			}
			new_node.next=temp.next;
			temp.next.prev=new_node;
			temp.next=new_node;
			new_node.prev=temp;
			System.out.print("Press 1 For Insert ");
			n=sc.nextInt();
		}while(n==1);
	}
	public void deleteAtStart()
	{
		if(head==null)
		{
			System.out.print("List Null ");
		}
		else
		{
			System.out.print("Deleted Item "+head.data);
			if(head.next==head)
			{
				head=null;
			}
			else
			{
				head.next.prev=head.prev;
				head.prev.next=head.next;
				head=head.next;
			}
		}
	}
	public void deleteAtEnd()
	{
		if(head==null)
		{
			System.out.print("List Null ");
		}
		else
		{
			if(head==head.next)
			{
				deleteAtStart();
			}
			else
			{
				System.out.print("Deleted Item "+head.prev.data);
				head.prev.prev.next=head;
				head.prev=head.prev.prev;
			}
		}
	}
	public void deleteAtIndex()
	{
		int index,length=0;
		if(head==null)
		{
			System.out.print("List Null ");
		}
		else
		{
			System.out.print("Enter Index ");
			index=sc.nextInt();
			if(head==head.next || index==1)
			{
				deleteAtStart();
			}
			else
			{
				Node temp=head;
				while(length!=index-1)
				{
					temp=temp.next;
					length++;
				}
				System.out.print("Deleted Item "+temp.data);
				temp.prev.next=temp.next;
				temp.next.prev=temp.prev;
			}
		}
	}
	public void traversal()
	{
		if(head==null)
		{
			System.out.print("List Null");
		}
		else
		{
			Node temp=head;
			do
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}while(temp!=head);
		}
	}
	public static void main(String args[])
	{
		double_circle_linked_list dcl=new double_circle_linked_list();
		int c;
		Scanner sc=new Scanner(System.in);
		dcl.insertAtStart();
		while(true)
		{
			System.out.print("\n1 For Insert At Start \n");
			System.out.print("2 For Insert At End \n");
			System.out.print("3 For Insert At Index \n");
			System.out.print("4 For Display \n");
			System.out.print("5 For Delete At Start \n");
			System.out.print("6 For Delete At End \n");
			System.out.print("7 For Delete At Index ");
			c=sc.nextInt();
			if(c==1)
			{
				dcl.insertAtStart();
			}
			else if(c==2)
			{
				dcl.insertAtEnd();
			}
			else if(c==3)
			{
				dcl.insertAtIndex();
			}
			else if(c==4)
			{
				dcl.traversal();
			}
			else if(c==5)
			{
				dcl.deleteAtStart();
			}
			else if(c==6)
			{
				dcl.deleteAtEnd();
			}
			else if(c==7)
			{
				dcl.deleteAtIndex();
			}
			else
			{
				break;
			}
		}
	}
}
