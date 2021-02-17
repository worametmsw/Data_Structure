// Java program to construct an expression tree

import java.util.Stack;
import java.util.regex.Pattern;
import java.util.Scanner;
class Node {

	char value;
	Node left, right;

	Node(char item) {
		value = item;
		left = right = null;
	}
}

class ExpressionTree {
	boolean isOperator(char c) {
		if (c == '+' || c == '-'
				|| c == '*' || c == '/'
				|| c == '^') {
			return true;
		}
		return false;
	}

	void inorder(Node t) {
		if (t != null) {
			inorder(t.left);
			System.out.print(t.value + " ");
			inorder(t.right);
		}
	}
        void preorder(Node t) {
            if (t != null) {
                        System.out.print(t.value + " ");
			preorder(t.left);
			preorder(t.right);
		}
        
        }
	Node constructTree(char postfix[]) {
		Stack<Node> st = new Stack<Node>();
		Node t, t1, t2;
		for (int i = 0; i < postfix.length; i++) {
			if (!isOperator(postfix[i])) {
				t = new Node(postfix[i]);
				st.push(t);
			} else
			{
				t = new Node(postfix[i]);
				t1 = st.pop();
				t2 = st.pop();
				t.right = t1;
				t.left = t2;
				st.push(t);
			}
		}
		t = st.peek();
		st.pop();

		return t;
	}

	public static void main(String args[]) {
            ExpressionTree et = new ExpressionTree();
             Scanner sc=new Scanner(System.in);
             String postfix;
             System.out.println("Input Post-Order: "); 
             postfix=sc.nextLine();
	     char[] charArray = postfix.toCharArray();
             Node root = et.constructTree(charArray);
	     System.out.println("In-Order expression is");
             et.inorder(root);
             System.out.println("\nPre-Oder expression is");
             et.preorder(root);
             System.out.println();
             System.out.print("Press Enter to exit");
             Scanner in=new Scanner(System.in);
             in.nextLine();
             System.out.println("Exit Program Good Bye");
	}
}
