class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // step 1 : first window 
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        result.add(map.size());
        
        // step 2 : slide the window 
        for (int i = k; i < arr.length; i++) {
            // remove outgoing element s
            int outgoing = arr[i - k];
            map.put(outgoing, map.get(outgoing) - 1);
            
            if (map.get(outgoing) == 0) {
                map.remove(outgoing);
            }
            
            // add incoming elements
            int incoming = arr[i];
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);
            
            result.add(map.size());
        }
        
        return result;
    }
}
