/*
Aarav Dev
Assignment 2
Problem 3.21(b)
*/

import java.util.Stack; // imports stack class

public class Main
{
	public static void main(String[] args) 
	{
	    // strings for testing isBalanced function
		String str1 = "int num() { return 0; }";
        String str2 = "void foo(int x, int y) { if (x < y) { return x + y; } }";
        String str3 = "/* This is a comment */";
        String str4 = "/* This is a comment without closing delimiter";
        String str5 = "(a + b) * c / d";
        String str6 = "int arr[] = {1, 2, 3};";
        String str7 = "{ [ ( ) ] }";
        String str8 = "{ [ ( ] ) }";

        // testing isBalanced function
        System.out.println(isBalanced(str1)); // true
        System.out.println(isBalanced(str2)); // true
        System.out.println(isBalanced(str3)); // true
        System.out.println(isBalanced(str4)); // false
        System.out.println(isBalanced(str5)); // true
        System.out.println(isBalanced(str6)); // true
        System.out.println(isBalanced(str7)); // true
        System.out.println(isBalanced(str8)); // false
	}
	
	public static boolean isBalanced(String str) 
	{
        Stack<Character> stack = new Stack<Character>(); // stack used to check if balanced
        for (int i = 0; i < str.length(); i++) // iterating through string
        {
            char ch = str.charAt(i); // current character
            if (ch == '(' || ch == '[' || ch == '{' || (ch == '/' && i + 1 < str.length() && str.charAt(i + 1) == '*'))  // if opening character
            {
                stack.push(ch);
            } 
            else if (ch == ')' || ch == ']' || ch == '}' || (ch == '*' && i + 1 < str.length() && str.charAt(i + 1) == '/')) // if closing character
            {
                if (stack.isEmpty()) 
                {
                    return false; // if stack is empty at this point, the closing character does not have a matching opening character
                } 
                else 
                {
                    char top = stack.pop();
                    if ((top == '(' && ch != ')') || (top == '[' && ch != ']') || (top == '{' && ch != '}') || (top == '/' && ch != '*')) // if characters don't match
                    {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty(); // if stack is empty at the end, all opening characters have matching closing characters
    }
}
