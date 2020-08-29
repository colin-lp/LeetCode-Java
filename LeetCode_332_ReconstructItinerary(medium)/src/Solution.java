import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<List<String>> input=new ArrayList<>(){{
            this.add(new ArrayList<>(){{
                this.add("JFK");
                this.add("SFO");
            }});
            this.add(new ArrayList<>(){{
                this.add("JFK");
                this.add("ATL");
            }});
            this.add(new ArrayList<>(){{
                this.add("SFO");
                this.add("ATL");
            }});
            this.add(new ArrayList<>(){{
                this.add("ATL");
                this.add("JFK");
            }});
            this.add(new ArrayList<>(){{
                this.add("ATL");
                this.add("SFO");
            }});
        }};
        Solution s=new Solution();
        List<String> result=s.findItinerary(input);
        System.out.println(result.toString());
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.size() == 0) return new ArrayList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (List<String> listString : tickets) {
            if (!map.containsKey(listString.get(0))) {
                map.put(listString.get(0), new PriorityQueue<String>());
            }
            map.get(listString.get(0)).offer(listString.get(1));
        }
        dfs("JFK",map,result);
        Collections.reverse(result);
        return result;
    }

    public void dfs(String key, Map<String, PriorityQueue<String>> map, List<String> result) {
        while (map.containsKey(key) && map.get(key).size() > 0) {
            String pri = map.get(key).poll();
            dfs(pri, map, result);
        }
        result.add(key);
    }
}
