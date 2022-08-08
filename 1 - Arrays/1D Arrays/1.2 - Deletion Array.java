class soln {
    public static int shift_and_delete_at_start()
    {
        int length = 10;
        int intArray[] = new int[10];
        // Starting at index 1, we shift each element one position
        // to the left.
        for (int i = 1; i < length; i++) {
            // Shift each element one position to the left
            intArray[i - 1] = intArray[i];
        }

        // Note that it's important to reduce the length of the array by 1.
        // Otherwise, we'll lose consistency of the size. This length
        // variable is the only thing controlling where new elements might
        // get added.
        length--;

        /*
         * Next comes the costliest of all deletion operations for an Array—deleting
         *  the first element. If we want to delete the first element of the Array, 
         * that will create a vacant spot at the 0th index. To fill that spot, we will 
         * shift the element at index 1 one step to the left. Going by the ripple effect,
         *  every element all the way to the last one will be shifted one place to the left.
         *  This shift of elements takes O(N)O(N) time, where NN is the number of elements
         *  in the Array.
         */
        return length;
    }

    public static int shift_and_delete_anywhere()
    {
        int length = 4;
        int int_array[] = new int[length];
                // Say we want to delete the element at index 1
        for (int i = 2; i < length; i++) {
            // Shift each element one position to the left
            int_array[i - 1] = int_array[i];
        }

        // Again, the length needs to be consistent with the current
        // state of the array.
        length--;
        return 0;

        /*
         * For deletion at any given index, the empty space created by the deleted
         *  item will need to be filled. Each of the elements to the right of the 
         * index we're deleting at will get shifted to the left by one. Deleting 
         * the first element of an Array is a special case of deletion at a given 
         * index, where the index is 0. This shift of elements takes O(K)O(K) time 
         * where KK is the number of elements to the right of the given index. Since 
         * potentially K = NK=N, we say that the time complexity of this operation 
         * is also O(N)O(N).
         */
    }
}
