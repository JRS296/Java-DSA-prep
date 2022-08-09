//Left Rotations
class ArrayLeftRotation {
    // function that rotates (left) the array of size n by d
    public static void rotateLeft(int array[], int d, int n) {
        for (int i = 0; i < d; i++)
            // calling function without passing the number of rotations
            rotateArrayByOne(array, n);
    }

    public static void rotateArrayByOne(int array[], int n) {
        int i, temp;
        // temporary array to store the newly created array
        temp = array[0];
        for (i = 0; i < n - 1; i++)
            // shifts array element to the left by 1
            array[i] = array[i + 1];
        array[i] = temp;
    }

    public static void main(String args[]) {
        int array[] = { 11, 22, 33, 44, 55, 66, 77 };
        // we can change the number of rotations accordingly
        int r = 1;
        // determines the length of array
        int n = array.length;
        System.out.println("Array before rotation: ");
        for (int i = 0; i < n; i++) {
            // prints array before rotation
            System.out.print(array[i] + " ");
        }
        System.out.println();
        rotateLeft(array, r, n);
        System.out.println("\nArray after left rotation: ");
        for (int i = 0; i < n; i++) {
            // prints array after performing rotation
            System.out.print(array[i] + " ");
        }
    }
}

class ArrayRightRotation {
    // function that rotates (right) the array of size n by d
    public static void rotateRight(int array[], int d, int n) {
        for (int i = 0; i < d; i++)
            // calling function without passing the number of rotations
            rotateArrayByOne(array, n);
    }

    public static void rotateArrayByOne(int array[], int n) {
        int i, temp;
        // temporary array to store the newly created array
        temp = array[n - 1];
        for (i = n - 1; i > 0; i--)
            // shifts array element to the left by 1
            array[i] = array[i - 1];
        array[0] = temp;
    }

    public static void main(String args[]) {
        // array to rotate
        int array[] = { 12, -9, 45, 23, -99, 67, 98, 90, 11, 45 };
        // we can change the number of rotations accordingly
        int r = 3;
        // determines the length of array
        int n = array.length;
        System.out.println("Array before rotation: ");
        for (int i = 0; i < n; i++) {
            // prints array before rotation
            System.out.print(array[i] + " ");
        }
        System.out.println();
        rotateRight(array, r, n);
        System.out.println("\nArray after right rotation: ");
        for (int i = 0; i < n; i++) {
            // prints array after performing rotation
            System.out.print(array[i] + " ");
        }
    }
}