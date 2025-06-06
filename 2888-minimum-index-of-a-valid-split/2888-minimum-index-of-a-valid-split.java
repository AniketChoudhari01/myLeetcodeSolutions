class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //using boyer-moore's majority voting algorithm
        int votes = 0;
        int candidate = -1;
        for(int item: nums){
            map.put(item, map.getOrDefault(item, 0)+1);
            if(votes == 0){
                votes = 1;
                candidate = item;
            }else{
                if(candidate == item){
                    votes++;
                }else{
                    votes--;
                }
            }
        }
        int dom_elem = candidate;
        int N = map.get(candidate);
        // for(Map.Entry<Integer, Integer> pair: map.entrySet()){
        //     if(N < pair.getValue()){
        //         N = pair.getValue();
        //         dom_elem = pair.getKey();
        //     }
        // }
        int n = nums.size();
        int left_cnt = 0;
        int right_cnt = N;
        for(int i=0; i<n; i++){
            if(nums.get(i) == dom_elem){
                left_cnt++;
                right_cnt--;
            }
            if((left_cnt*2 > (i+1)) && (right_cnt*2 > (n-i-1))){
                return i;
            }
        }
        return -1;
    }
}