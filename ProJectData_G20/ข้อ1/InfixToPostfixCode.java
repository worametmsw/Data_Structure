package infixtoposfix;
import java.util.Stack; 
import java.util.regex.Pattern;
 import java.util.Scanner;
public class InfixToPosfix {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         String infix;
         System.out.println("Input Infix: "); 
        infix=sc.nextLine();
         System.out.println("Postfix is:");
         System.out.println(InfixToPostfix(infix));
         System.out.print("Press Enter to exit");
         Scanner in=new Scanner(System.in);
         in.nextLine();
         System.out.println("Exit Program Good Bye");
         
     } 
     static String InfixToPostfix(String infix){ 
        String output=new String(""); 
        Stack<Character> stack=new Stack<>(); 
        for (int i=0;i<infix.length();i++){ 
             char ch1=infix.charAt(i); 
            if(Character.isLetterOrDigit(ch1)) 
                output += ch1; 
             else if(ch1=='(') 
                 stack.push(ch1);
           else if(ch1 == ')'){ 
                while(!stack.isEmpty()&&stack.peek()!='(') 
                   output += stack.pop();  
               if(!stack.isEmpty()&&stack.peek()!='(') 
                    return "Invalid";                 
                else
                  stack.pop();} 
           else{ 
               while(!stack.isEmpty()&&Check(ch1)<= Check(stack.peek())){ 
                    if(stack.peek()=='(') 
                       return "Invalid"; 
                   output+=stack.pop();} 
           stack.push(ch1);}
      }
       while(!stack.isEmpty()){ 
            if(stack.peek()=='(') 
               return "Invalid"; 
            output+=stack.pop();} 
       return output;}   
   
   static int Check(char ch){
      if(ch=='+'||ch=='-')
            return 1;
        else if(ch=='*'||ch=='/')
             return 2;
         else if(ch=='^')
             return 3;
         return -1;}
 }