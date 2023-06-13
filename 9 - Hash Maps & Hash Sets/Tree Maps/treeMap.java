import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
 
class TreeMain {
    public static void main(String[] args) {
        Map<String, Integer> treeMap = new TreeMap<>();
 
        // Adding elements to the tree map
        treeMap.put("A", 1);
        treeMap.put("C", 3);
        treeMap.put("B", 2);
        treeMap.put("F", 9);
        treeMap.put("T", 0);
        treeMap.put("G", 6);
 
        // Getting values from the tree map
        int valueA = treeMap.get("A");
        System.out.println("Value of A: " + valueA);
 
        // Removing elements from the tree map
        treeMap.remove("B");
 
        // Iterating over the elements of the tree map
        for (String key : treeMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
        }

        treeMap.forEach((k,v) -> System.out.println("Key: "+k+" Value: "+v));
    }
}

// Java Program to Demonstrate TreeMap
// using the Default Constructor

// Main class
class TreeMapImplementation {

	// Method 1
	// To illustrate constructor<Map>
	static void Example3rdConstructor()
	{
		// Creating an empty HashMap
		Map<Integer, String> hash_map
			= new HashMap<Integer, String>();

		// Mapping string values to int keys
		// using put() method
		hash_map.put(10, "Geeks");
		hash_map.put(15, "4");
		hash_map.put(20, "Geeks");
		hash_map.put(25, "Welcomes");
		hash_map.put(30, "You");

		// Creating the TreeMap using the Map
		TreeMap<Integer, String> tree_map
			= new TreeMap<Integer, String>(hash_map);

		// Printing the elements of TreeMap
		System.out.println("TreeMap: " + tree_map);
	}

	// Method 2
	// Main driver method
	public static void main(String[] args)
	{

		System.out.println("TreeMap using "
						+ "TreeMap(Map)"
						+ " constructor:\n");

		Example3rdConstructor();
	}
}
