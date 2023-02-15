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

/*
COMPRESS PATHS AND UNION RULES FOR DISJOINT SET
As shown above - when in Find - we can compress the paths. Also, in the Union, we can either set G[px] = py or G[py] = px.

CHOOSE A SMALLER GROUP ID
This would be easiest - we compare the px and py value before setting the group:

1
2
3
4
5
6
7
8
void Union(int x, int y) {
  int px = Find(x);
  int py = Find(y);
  if (px != py) {
    if (px < py) swap(px, py); // make py smaller
    G[px] = py;    
  }            
} 
 */
 
    public int size() { // number of groups
        int ans = 0;
        for (int i = 0; i < parent.length(); ++ i) {
            if (i == parent[i]) ans ++;
        }
        return ans;
    }  
}

public class Main {
    public static void main(String[] args) {
        var uf = new UnionFind(5);
        System.out.println(uf.Find(3));
        uf.Union(3, 4);
        System.out.println(uf.Find(3)); // after join, 3's parent is 4.
    }
}

//Eg: (Lexographically smallest num)
class Solution { //Same approach as planned, but since lexigraphically highest character is favoured, that is considered within array
    int[] parent;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];
        for(int i=0;i<26;i++)
            parent[i]=i;
        for(int i=0;i<s1.length();i++){
            int u = find(s1.charAt(i)-'a');
            int v = find(s2.charAt(i)-'a');
            if(u<v)
              parent[v]=u;
            else if(u>v)
              parent[u]=v;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<baseStr.length();i++)
            sb.append((char)(find(baseStr.charAt(i)-'a')+'a'));
        return sb.toString();
    }

    private int find(int u){
        return parent[u]==u? u:find(parent[u]);
    }
}
