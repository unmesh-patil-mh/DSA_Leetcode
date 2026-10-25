class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // Creating one loss table to store all our Losses and how many times they lose
        Map<Integer,Integer> loss_table = new HashMap<>();

        // Iterating through mathces and counting the losses of the players
        for(int i = 0 ; i < matches.length ; i++){
            int loser = matches[i][1];
            // stroing losser in loss_table and updating its count
            loss_table.put(loser,loss_table.getOrDefault(loser,0) + 1);
        }

        // Creating list to store our players 
        List<Integer> noloss = new ArrayList<>();
        List<Integer> oneloss = new ArrayList<>();

        for(int i = 0 ; i < matches.length ; i++){
            int winner = matches[i][0];
            int losser = matches[i][1];

            if(!loss_table.containsKey(winner)){
                noloss.add(winner);
                loss_table.put(winner,2);
            }

            if(loss_table.get(losser) == 1){
                oneloss.add(losser);
            }
        }

        Collections.sort(oneloss);
        Collections.sort(noloss);

        return Arrays.asList(noloss,oneloss);
    }
}