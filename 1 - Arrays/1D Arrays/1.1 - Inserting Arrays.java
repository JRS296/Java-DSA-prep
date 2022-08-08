class soln {
    public static int shift_and_insert_at_pos()
    {
        int intArray[] = new int[10];
        // First, we will have to create space for a new element.
        // We do that by shifting each element one index to the right.
        // This will firstly move the element at index 3, then 2, then 1, then finally 0.
        // We need to go backwards to avoid overwriting any elements.
        for (int i = 3; i >= 0; i--) {
            intArray[i + 1] = intArray[i];
        }

        // Now that we have created space for the new element,
        // we can insert it at the beginning.
        intArray[0] = 20;
        return 0;

        /*
         * To insert an element at the start of an Array, we'll need to shift all 
         * other elements in the Array to the right by one index to create space 
         * for the new element. This is a very costly operation, since each of the
         *  existing elements has to be shifted one step to the right. The need 
         * to shift everything implies that this is not a constant time operation. 
         * In fact, the time taken for insertion at the beginning of an Array will
         *  be proportional to the length of the Array. In terms of time complexity
         *  analysis, this is a linear time complexity: O(N)O(N), where NN is the
         *  length of the Array.
         */
    }

    public static int shift_and_insert_anywhere()
    {
        int intArray[] = new int[6];
        //Array Size = 6 (0-5)
        // Say we want to insert the element at index 2.
        // First, we will have to create space for the new element.
        for (int i = 4; i >= 2; i--) //4 as in l-1, 2 as in pos to be inserted in
        {
            // Shift each element one position to the right.
            intArray[i + 1] = intArray[i];
        }

        // Now that we have created space for the new element,
        // we can insert it at the required index.
        intArray[2] = 30;
        return 0;

        /*
         * Again, this is also a costly operation since we could potentially have to
         *  shift almost all the other elements to the right before actually inserting
         *  the new element. As your saw above, shifting lots of elements one place to
         *  the right adds to the time complexity of the insertion task.
         */
    }
}
