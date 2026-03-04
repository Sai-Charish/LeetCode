import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Map<Integer, List<Integer>> data = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> heaps = new HashMap<>();

        // Build adjacency list
        for (int[] conn : connections) {
            int u = conn[0], v = conn[1];
            data.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            data.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        Map<Integer, Integer> leaders = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        // Find leaders using BFS
        for (int node = 1; node <= c; node++) {
            if (visited.contains(node)) continue;

            Queue<Integer> q = new LinkedList<>();
            visited.add(node);
            leaders.put(node, node);

            for (int neighbor : data.getOrDefault(node, new ArrayList<>())) {
                q.offer(neighbor);
            }

            while (!q.isEmpty()) {
                int temp = q.poll();
                leaders.put(temp, node);
                visited.add(temp);

                for (int neighbor : data.getOrDefault(temp, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        // Build heaps for each leader
        for (int[] conn : connections) {
            int u = conn[0], v = conn[1];
            heaps.computeIfAbsent(leaders.get(u), k -> new PriorityQueue<>()).offer(u);
            heaps.computeIfAbsent(leaders.get(v), k -> new PriorityQueue<>()).offer(v);
        }

        List<Integer> resList = new ArrayList<>();

        // Process queries
        for (int[] query : queries) {
            int op = query[0];
            int node = query[1];

            if (op == 2) {
                visited.remove(node);
            } else {
                if (visited.contains(node)) {
                    resList.add(node);
                    continue;
                }

                PriorityQueue<Integer> pq = heaps.getOrDefault(leaders.get(node), new PriorityQueue<>());

                while (!pq.isEmpty()) {
                    int top = pq.peek();
                    if (visited.contains(top)) {
                        resList.add(top);
                        break;
                    } else {
                        pq.poll();
                    }
                }

                if (pq.isEmpty()) {
                    resList.add(-1);
                }
            }
        }

        // Convert List<Integer> → int[]
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;
    }
}

