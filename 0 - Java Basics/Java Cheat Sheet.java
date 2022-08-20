import java.util.*;

class JavaCheatSheet {

    //Function to Return Unique elements from Array(arraylist)
    public static ArrayList<Integer> unique(ArrayList<Integer> arr) {
        ArrayList<Integer> uq = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (uq.contains(arr.get(i))) {
                continue;
            } else {
                uq.add(arr.get(i));
            }
        }
        return uq;
    }

    //Function to Reverse a Number: Eg: 160 = 061
    public static int reverse(int x)
    {
        int number = x, reverse = 0;  
        while(number != 0)   
        {  
            int remainder = number % 10;  
            reverse = reverse * 10 + remainder;  
            number = number/10;  
        }  
        return reverse;
    }

    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Simple Way to Create Char Array
    char[] number = "0123456789".toCharArray(); 

    public static String reverse(String str) 
    { //Two pointer technique
        if(str == null || str.isEmpty()){ return str; } 
        char[] characters = str.toCharArray(); 
        int i = 0; int j = characters.length - 1; 
        while (i < j) { swap(characters, i, j); i++; j--; } 
        return new String(characters); 
    }

    private static void swap(char[] str, int i, int j) { char temp = str[i]; str[i] = str[j]; str[j] = temp; }

    public int length(String s)    {
        int ans = 0;
        for(char x : s.toCharArray())
        {ans++;}
        return ans;
    }
}

