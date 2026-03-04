class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dict.contains(endWord)) return result;

        Map<String, List<String>> parents = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();

        bfs(beginWord, endWord, dict, parents, dist);
        dfs(endWord, beginWord, parents, new ArrayList<>(), result);

        return result;
    }

    private void bfs(String begin, String end, Set<String> dict,
                     Map<String, List<String>> parents,
                     Map<String, Integer> dist) {

        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        dist.put(begin, 0);

        for (String w : dict) parents.put(w, new ArrayList<>());
        parents.put(begin, new ArrayList<>());

        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = dist.get(word);

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char old = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String next = new String(arr);

                    if (!dict.contains(next)) continue;

                    if (!dist.containsKey(next)) {
                        dist.put(next, steps + 1);
                        q.offer(next);
                        parents.get(next).add(word);
                    } else if (dist.get(next) == steps + 1) {
                        parents.get(next).add(word);
                    }
                }
                arr[i] = old;
            }
        }
    }

    private void dfs(String word, String begin,
                     Map<String, List<String>> parents,
                     List<String> path,
                     List<List<String>> result) {

        path.add(word);

        if (word.equals(begin)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
        } else {
            for (String p : parents.get(word)) {
                dfs(p, begin, parents, path, result);
            }
        }

        path.remove(path.size() - 1);
    }
}

