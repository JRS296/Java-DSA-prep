import java.util.*;

class Program { //ALE
  static class UnionFind {
    private Map<Integer, Integer> parents;

    public UnionFind() {
      parents = new HashMap<Integer,Integer>();
    }

    public void createSet(int value) {
      /*
      // create `n` disjoint sets (one for each item)
        for (int i: universe) {
            parent.put(i, i);
        }
      */
      if(parents.containsKey(value)) return;
      parents.put(value,value);
    }

    public Integer find(int value) { 
      if(!parents.containsKey(value)) return null; // if `value` is null
      if(parents.get(value) == value) return value; // if `value` is root
      return find(parents.get(value)); // recur for the parent until we find the root
    }

    public void union(int valueOne, int valueTwo) {
      // find the root of the sets in which elements `x` and `y` belongs
      Integer set1 = find(valueOne);
      Integer set2 = find(valueTwo);
      if(set1 == null || set2 == null || set2.equals(set1)) return;
      parents.put(set2, set1);
    }
  }
}

//Using Array instead of HashMap

class UnionFind {
    private int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (var i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
 
    public int Find(int x) {
        if (x == parent[x]) {
            return x;
        }
        // compress the paths
        return parent[x] = Find(parent[x]);
    }
 
    public void Union(int x, int y)  {
        var px = Find(x);
        var py = Find(y);
        if (px != py) {
            parent[px] = py;
        }
    }
 
    public int size() { // number of groups
        int ans = 0;
        for (int i = 0; i < parent.length; ++ i) {
            if (i == parent[i]) ans ++;
        }
        return ans;
    }  
}

class Main {
    public static void main(String[] args) {
        var uf = new UnionFind(5);
        System.out.println(uf.Find(3));
        uf.Union(3, 4);
        System.out.println(uf.Find(3)); // after join, 3's parent is 4.
    }
}
