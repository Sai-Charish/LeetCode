class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i+=1){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(beginWord,1));

        while(!que.isEmpty()){
            Pair temp = que.poll();
            int lent = temp.word.length();
            int level = temp.level;

            for(int i=0;i<lent;i+=1){
                StringBuilder str = new StringBuilder(temp.word);
                for(char ch = 'a' ; ch <='z'; ch+=1){
                    if(str.charAt(i) == ch) continue;
                    str.setCharAt(i,ch);
                    if(set.contains(str.toString())){
                        if(endWord.equals(str.toString())){
                            return level+1;
                        }
                        que.add(new Pair(str.toString(),level+1));
                        set.remove(str.toString());
                    }
                }
            }

        }

        return 0;
    }
}

class Pair {
    String word;
    int level;

    public Pair(String word,int level){
        this.word = word;
        this.level = level;
    }
}
