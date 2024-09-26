import java.util.*;

public class MinimumGeneticMutation {
    class Pair {
        String geneString;
        int mutationsNeeded;

        public Pair(String geneString, int mutationsNeeded) {
            this.geneString = geneString;
            this.mutationsNeeded = mutationsNeeded;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> seen = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(startGene, 0));
        seen.add(startGene);


        while(!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            String gene = currentPair.geneString;
            int mutations = currentPair.mutationsNeeded;

            if(Objects.equals(gene, endGene)){
                return mutations;
            }


            for (int i = 0; i < gene.length(); i++) {
                for(char c : new char[]{'A', 'C', 'G', 'T'}) {
                    String newGene = gene.substring(0, i) + c + gene.substring(i+1);

                    if (Arrays.asList(bank).contains(newGene)&& !seen.contains(newGene)) {
                        seen.add(newGene);
                        queue.add(new Pair(newGene, mutations+1));
                    }

                }
            }

        }
        return -1;
    }

}
