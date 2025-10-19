class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> que = new LinkedList<>();
        Set<String> set = new HashSet<>();

        String smallest = s;
        que.add(smallest);
        set.add(smallest);

        while(!que.isEmpty()){
            String curr = que.poll();
            if(curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
            //opp 1;
            char [] ch = curr.toCharArray();
            for(int i=1;i<ch.length;i+=2){
                ch[i] = (char) ((ch[i] - '0' + a)% 10 + '0');
            }
            
            String opt1 = new String(ch);
            if(set.add(opt1)){
                que.add(opt1);
            }
            //opp 2;

            String opt2 = curr.substring(curr.length()-b) + curr.substring(0,curr.length()-b);
            if(set.add(opt2)){
                que.add(opt2);
            }

        }

        return smallest;
    }
}
