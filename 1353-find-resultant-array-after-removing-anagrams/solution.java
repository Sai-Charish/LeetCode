class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);

        for(int i=0;i<words.length;i+=1) {
            res.add(words[i]);
        }

        int i=1;
        while(i<res.size()){
            if(isAnagram(res.get(i),res.get(i-1))) {
                res.remove(i);
            }
            else {
                i+=1;
            }
        }

        return res;
    }

    public boolean isAnagram(String a,String b) {
        char [] arr1 = a.toCharArray();
        char [] arr2 = b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        a = new String (arr1);
        b = new String (arr2);


        return (a.compareTo(b) == 0) ? true : false ;
    }
}
