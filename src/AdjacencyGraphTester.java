public class AdjacencyGraphTester {

    public static void main(String[] args) {
            int[][] input = {
                    {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                    {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                    {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                    {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                    {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            };
            int[][] input2 = {
                    {1, 0, 0, 1, 0},
                    {1, 0, 1, 0, 0},
                    {0, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1},
                    {1, 0, 1, 1, 0},
            };
            int[][] input3 = {{1}};
            int[] expected = {1};
            System.out.println(AdjacencyMatrixGraph.riverSizes(input));
        }
}
