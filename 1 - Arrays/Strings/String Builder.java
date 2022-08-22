
class StringBuilder_exp {
    public static void main(String[] args) {
        int n = 10000;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append("hello");
        }
        String s = str.toString();
    }
}

//If you have to concatenate strings often,
// it will be better to use some other data structures 
//like StringBuilder. The below code runs in O(n) complexity.

//Normal methods to concatenate is O(n^2), so beware

/*
 * Other String BUilder Functions:
 * append()
 * delete()
 */