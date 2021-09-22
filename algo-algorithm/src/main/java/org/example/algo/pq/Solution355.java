package org.example.algo.pq;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/design-twitter/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution355 {
    static class Twitter {
        private static int timestamp = 0;

        private static class Tweet {
            private int id;
            private int time;
            private Tweet next;

            public Tweet(int id, int time) {
                this.id = id;
                this.time = time;
                this.next = null;
            }
        }

        private static class User {
            private int id;
            public Set<Integer> followedUserId;
            public Tweet firstTweet;

            public User(int userId) {
                this.followedUserId = new HashSet<>();
                this.id = userId;
                this.firstTweet = null;
                follow(this.id);
            }

            public void follow(int userId) {
                followedUserId.add(userId);
            }

            public void unfollow(int userId) {
                if (userId != this.id) {
                    followedUserId.remove(userId);
                }
            }

            public void post(int tweetId) {
                Tweet tweet = new Tweet(tweetId, Twitter.timestamp);
                Twitter.timestamp++;
                tweet.next = firstTweet;
                firstTweet = tweet;
            }
        }

        private Map<Integer, User> userMap = new HashMap<>();

        public Twitter() {
        }

        public void postTweet(int userId, int tweetId) {
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, new User(userId));
            }
            User user = userMap.get(userId);
            user.post(tweetId);
        }

        public void follow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId)) {
                userMap.put(followerId, new User(followerId));
            }
            if (!userMap.containsKey(followeeId)) {
                userMap.put(followeeId, new User(followeeId));
            }
            userMap.get(followerId).follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (userMap.containsKey(followerId)) {
                userMap.get(followerId).unfollow(followeeId);
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> list = new LinkedList<>();
            if (!userMap.containsKey(userId)) {
                return list;
            }
            Set<Integer> users = userMap.get(userId).followedUserId;
            // 大顶堆，堆顶是堆中最大的元素
            PriorityQueue<Tweet> pq = new PriorityQueue<>(
                    users.size(), (a, b) -> (b.time - a.time)
            );
            for (Integer user : users) {
                Tweet firstTweet = userMap.get(user).firstTweet;
                if (firstTweet == null) {
                    continue;
                }
                pq.offer(firstTweet);
            }
            while (!pq.isEmpty()) {
                if (list.size() == 10) {
                    break;
                }
                Tweet tweet = pq.poll();
                list.add(tweet.id);
                if (tweet.next != null) {
                    pq.offer(tweet.next);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
    }
}
