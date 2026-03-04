class Twitter {

    private static int timeStamp = 0;

    // userId -> list of tweets
    private Map<Integer, List<Tweet>> tweets;

    // userId -> set of followees
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        tweets = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) -> b.time - a.time);

        // add user's own tweets
        if (tweets.containsKey(userId)) {
            for (Tweet t : tweets.get(userId)) {
                pq.offer(t);
            }
        }

        // add followees' tweets
        if (followMap.containsKey(userId)) {
            for (int followee : followMap.get(userId)) {
                if (tweets.containsKey(followee)) {
                    for (Tweet t : tweets.get(followee)) {
                        pq.offer(t);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;

        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll().id);
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) return;

        followMap.get(followerId).remove(followeeId);
    }

    // Tweet class
    class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}

