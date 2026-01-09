import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // Step 1: Sort meetings by time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        // Step 2: Track who knows the secret
        boolean[] knowsSecret = new boolean[n];
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true;

        int i = 0;
        int m = meetings.length;

        // Step 3: Process meetings grouped by same time
        while (i < m) {
            int time = meetings[i][2];

            // Temporary graph for this time
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> peopleInThisTime = new HashSet<>();

            // Collect all meetings with the same time
            while (i < m && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                peopleInThisTime.add(x);
                peopleInThisTime.add(y);

                i++;
            }

            // Step 4: BFS from people who already know the secret
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int person : peopleInThisTime) {
                if (knowsSecret[person]) {
                    queue.offer(person);
                    visited.add(person);
                }
            }

            // Spread the secret within this time block
            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int next : graph.getOrDefault(curr, Collections.emptyList())) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            // Step 5: Mark all visited people as knowing the secret
            for (int person : visited) {
                knowsSecret[person] = true;
            }
        }

        // Step 6: Prepare result
        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (knowsSecret[p]) {
                result.add(p);
            }
        }

        return result;
    }
}
