class soln {
    static void rvereseArray(int arr[],int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Driver code
    public static void main(String args[]) {

        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int size = arr.length;
        rvereseArray(arr, 0, 5);
        System.out.print("Reversed array is \n");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

    }
}
