class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length/groupSize;
        if(hand.length%groupSize != 0){
            return false;
        }
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int i=0;i<hand.length;i+=1){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

        for(int ind=0;ind<n;ind+=1){
            int small = map.firstKey();
            for(int i=0;i<groupSize;i+=1){
                if(!map.containsKey(small)){
                    return false;
                }
                else{
                    map.put(small,map.get(small)-1);
                    if(map.get(small) == 0){
                        map.remove(small);
                    }
                    small += 1;
                }
                
            }
        }

        return true;

    }
}
