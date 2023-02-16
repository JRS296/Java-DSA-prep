class StreamChecker { //https://leetcode.com/problems/stream-of-characters/solutions/1610403/java-simple-solution-trie-detailed-explanation-using-image/

    class TrieNode{
        boolean isWord;
        TrieNode children[] = new TrieNode[26];
    }
    
    TrieNode root = new TrieNode();
    int maxSize;
    StringBuilder sb = new StringBuilder();
    
    public StreamChecker(String[] words) {
        insert(words);
    }
    
    public boolean query(char letter) {
        if(sb.length()>=maxSize){
            sb.deleteCharAt(0);
        }
        sb.append(letter);
        TrieNode curr = root;
        
        for(int i=sb.length()-1;i>=0;i--){
            char ch = sb.charAt(i);
            
            if(curr!=null) curr = curr.children[ch-'a'];
            
            if(curr!=null && curr.isWord) return true;
        }
        return false;
    }
    
    public void insert(String[] words){
        
        for(String s : words){
            maxSize = Math.max(maxSize,s.length());
            TrieNode curr = root;
            for(int i = s.length()-1;i>=0;i--){
                char ch = s.charAt(i);
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.isWord = true;
        }
    }
}