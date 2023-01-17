import java.util.*;
class CD {
    // DFS on n-ary tree
    public static void dfs(LinkedList < Integer > list[],int node, int arrival) {
        System.out.println(node);
        int i=0;
        while(i < list[node].size()){
            if (list[node].get(i) != arrival)
                dfs(list, list[node].get(i), node);
            i++;
        }
    }


    public static void main(String[] args) {
        int node = 7,i=0;
        LinkedList < Integer > list[] = new LinkedList[node + 1];
        while(i < list.length){
            list[i] = new LinkedList < Integer > ();
            i++;
        }
        // How to design the n-ary tree
        list[1].add(2);
        list[2].add(1);


        list[1].add(3);
        list[3].add(1);


        list[2].add(4);
        list[4].add(2);


        list[2].add(5);
        list[5].add(2);


        list[3].add(6);
        list[6].add(3);


        list[3].add(7);
        list[7].add(3);


        // Function call
        dfs(list, 0, 0);
    }
}