class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        ArrayList<Integer> DryDays = new ArrayList<>();
        int [] res = new int [n];
        HashMap <Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i+=1){
            if(rains[i] == 0){
                DryDays.add(i);
                res[i] = 1;
            }
            else {
                if(map.containsKey(rains[i])) {
                    int filledIndex = map.get(rains[i]);
                    int index = -1;

                    for(int j=0;j<DryDays.size();j+=1) {
                        if(filledIndex < DryDays.get(j)) {
                            index = DryDays.get(j);
                            DryDays.remove(j);
                            break;
                        }
                    }

                    if(index == -1) return new int [0];

                    res[index] = rains[i];
                }

                map.put(rains[i],i);
                res[i] = -1;

            }

        }
        return res;
    }
}
