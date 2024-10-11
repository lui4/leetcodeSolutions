import java.util.*;

public class TheNumberOfOnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        HashMap<Integer, Integer> arrivals = new HashMap();
        HashMap<Integer, List<Integer>> leaving = new HashMap();
        PriorityQueue<Integer> freeSeats = new PriorityQueue<>();
        SortedSet<Integer> relevantEvent = new TreeSet<>();

        for (int i = 0; i < times.length; i++) {
            arrivals.putIfAbsent(times[i][0], i);
            leaving.computeIfAbsent(times[i][1], val -> new ArrayList<>());
            freeSeats.add(i);
            relevantEvent.add(times[i][1]);
            relevantEvent.add(times[i][0]);

            leaving.get(times[i][1]).add(i);
        }

        int[] state = new int[times.length];

        for(int currentTime: relevantEvent) {
            for (int person: leaving.getOrDefault(currentTime, new ArrayList<Integer>())) {
                freeSeats.add(state[person]);
            }

            int arrivedPerson = arrivals.getOrDefault(currentTime, -1);

            if(arrivedPerson == targetFriend) return freeSeats.poll();

            if(arrivedPerson != -1){
                int seat = freeSeats.poll();
                state[arrivedPerson] = seat;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        TheNumberOfOnoccupiedChair noc = new TheNumberOfOnoccupiedChair();
        System.out.println(noc.smallestChair(new int[][]{{4,5},{12,13},{5,6},{1,2},{8,9},{9,10},{6,7},{3,4},{7,8},{13,14},{15,16},{14,15},{10,11},{11,12},{2,3},{16,17}}, 15));
    }
}
