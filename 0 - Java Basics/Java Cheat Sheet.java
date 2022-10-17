import java.util.*;

class JavaCheatSheet {

    // Function to Return Unique elements from Array(arraylist)
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

    // Function to Reverse a Number: Eg: 160 = 061
    public static int reverse(int x) {
        int number = x, reverse = 0;
        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        return reverse;
    }

    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); // Simple Way to Create Char Array
    char[] number = "0123456789".toCharArray();

    public static String reverse(String str) { // Two pointer technique
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] characters = str.toCharArray();
        int i = 0;
        int j = characters.length - 1;
        while (i < j) {
            swap(characters, i, j);
            i++;
            j--;
        }
        return new String(characters);
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public int length(String s) {
        int ans = 0;
        for (char x : s.toCharArray()) {
            ans++;
        }
        return ans;
    }

    generatePermutation(str, 0, len, x);  
    //Function to get all permutations of a string
    public static void generatePermutation(String str, int start, int end, ArrayList<String> ans) {
        if (start == end - 1)
            ans.add(str);// Prints the permutations
        else {
            for (int i = start; i < end; i++) {
                str = swapString(str, start, i); // Swapping the string by fixing a character
                generatePermutation(str, start + 1, end); // Recursively calling function generatePermutation() for rest of the characters
                str = swapString(str, start, i); // Backtracking and swapping the characters again.
            }
        }
    }

    // Function to get all combinatinations of a string
    public static String[] AllPossibleSubsets(String st)
    {
        String str = st;  
        int len = str.length();  
        int temp = 0;  
        //Total possible subsets for string of size n is n*(n+1)/2  
        String arr[] = new String[len*(len+1)/2];  
  
        //This loop maintains the starting character  
        for(int i = 0; i < len; i++) {  
            //This loop adds the next character every iteration for the subset to form and add it to the array  
            for(int j = i; j < len; j++) {  
                arr[temp] = str.substring(i, j+1);  
                temp++;  
            }  
        }  
        return arr;
    }
}
