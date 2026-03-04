class Solution {
    public String frequencySort(String s) {
        HashMap <Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<s.length();i+=1){
            int freq = map.getOrDefault(s.charAt(i),0) + 1;
            map.put(s.charAt(i),freq);
            max = Math.max(max,freq);
        }

        ArrayList<ArrayList<Character>> Bucket = new ArrayList<>(max+1);

        for(int i=0;i<=max;i+=1){
            Bucket.add(new ArrayList<>());
        }

        for(Map.Entry<Character,Integer> pair : map.entrySet()) {
            char key = pair.getKey();
            int value = pair.getValue();
            Bucket.get(value).add(key);
        }

        StringBuilder str = new StringBuilder();

        for(int i=max;i>0;i-=1){
            for(int j=0;j<Bucket.get(i).size();j+=1){
                char ch = Bucket.get(i).get(j);
                for(int k=0;k<i;k+=1){
                    str.append(ch);
                }
            }
        }

        return str.toString();

    }
}
