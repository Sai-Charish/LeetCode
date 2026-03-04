class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int max_len = 0;
        int left = 0;
        int right = 0;

        while(right < fruits.length) {
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            if(map.size() <= 2) {
                int len = right - left + 1;
                max_len = Math.max(max_len,len);    
            }
            else{
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left+=1;
            }

            right+=1;
        }

        return max_len;
    }
}
