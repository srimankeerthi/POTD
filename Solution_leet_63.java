class Solution_leet_63{
    // A flat array structure to optimize memory and avoid Object overhead (MLE)
    // We assume an upper bound for total characters based on constraints (Sum of lengths <= 5 * 10^5)
    private int[][] trie;
    private int[] bestIndex;
    private int nodeCount;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        int m = wordsQuery.length;
        
        // Sum of wordsContainer[i].length is at most 5 * 10^5. 
        // Max nodes needed is sum of lengths + 1 (for root node).
        int maxNodes = 1;
        for (String word : wordsContainer) {
            maxNodes += word.length();
        }
        
        trie = new int[maxNodes][26];
        bestIndex = new int[maxNodes];
        nodeCount = 0;
        
        // Find the absolute best base fallback index (shortest, earliest string overall)
        int globalBestIdx = 0;
        for (int i = 1; i < n; i++) {
            if (wordsContainer[i].length() < wordsContainer[globalBestIdx].length()) {
                globalBestIdx = i;
            }
        }
        
        // Initialize root node
        bestIndex[0] = globalBestIdx;
        
        // Insert all words from wordsContainer into the suffix Trie (inserted backwards)
        for (int i = 0; i < n; i++) {
            insert(wordsContainer[i], i, wordsContainer);
        }
        
        // Process queries
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = search(wordsQuery[i]);
        }
        
        return ans;
    }
    
    private void insert(String word, int wordIdx, String[] wordsContainer) {
        int currNode = 0;
        int len = word.length();
        
        // Traverse backwards to handle suffixes
        for (int i = len - 1; i >= 0; i--) {
            int charIdx = word.charAt(i) - 'a';
            
            if (trie[currNode][charIdx] == 0) {
                nodeCount++;
                trie[currNode][charIdx] = nodeCount;
                // Initialize the newly created node with the current word's index
                bestIndex[nodeCount] = wordIdx;
            }
            
            currNode = trie[currNode][charIdx];
            
            // Compare and update the best index for this prefix path
            int existingBestIdx = bestIndex[currNode];
            if (len < wordsContainer[existingBestIdx].length()) {
                bestIndex[currNode] = wordIdx;
            } else if (len == wordsContainer[existingBestIdx].length()) {
                if (wordIdx < existingBestIdx) {
                    bestIndex[currNode] = wordIdx;
                }
            }
        }
    }
    
    private int search(String query) {
        int currNode = 0;
        int len = query.length();
        
        // Walk the Trie backwards matching character by character
        for (int i = len - 1; i >= 0; i--) {
            int charIdx = query.charAt(i) - 'a';
            if (trie[currNode][charIdx] == 0) {
                // Suffix mismatch, return the best index stored at the last matched node
                return bestIndex[currNode];
            }
            currNode = trie[currNode][charIdx];
        }
        
        // Complete query traversal matched, return the best index at this endpoint
        return bestIndex[currNode];
    }
}
