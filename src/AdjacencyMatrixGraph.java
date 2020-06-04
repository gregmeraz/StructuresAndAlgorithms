import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class AdjacencyMatrixGraph {


    static class Node{
        int i;
        int j;

        public Node(int i, int j){
            this.i=i;
            this.j=j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return i == node.i &&
                    j == node.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

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

        int[][] input4 = {{1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0}};
        System.out.println(riverSizes(input4).size());
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Node> visitedNodes= new ArrayList<>();
        List<Integer> riverSizes= new ArrayList<>();
        if(matrix.length==1&&matrix[0].length==1){
            if(matrix[0][0]==1){
               riverSizes.add(1);
               return riverSizes;
            }
            else{
                return riverSizes;
            }
        }
        else if(matrix.length==1&&matrix[0].length>1){
            int counter=0;
            for(int i=0; i<=matrix[0].length-1; i++){
                if(matrix[0][i]==1){
                    counter++;
                }
                else if(matrix[0][i]==0){
                    if(counter>0){
                        riverSizes.add(counter);
                    }
                    counter=0;
                }
            }
            Collections.reverse(riverSizes);
            return riverSizes;
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]==1){
                    Node node= new Node(i,j);
                    if(!visitedNodes.contains(node)){
                        List<Node> adjacentNodes= new ArrayList<>();
                        Queue<Node> adjacentNodesBFS= new LinkedList<>();
                        adjacentNodesBFS.add(node);
                        adjacentNodes.add(node);
                        visitedNodes.add(node);
                        riverSizes.add(breadFirstSearch(matrix, adjacentNodesBFS, visitedNodes,  adjacentNodes));
                    }
                }
            }
        }
        return riverSizes;
    }

    private static Integer breadFirstSearch(int[][] matrix, Queue<Node> queue, List<Node> visitedNodes, List<Node> adjacentNodes){
        while(!queue.isEmpty()){
            Node polledNode=queue.poll();
            //upper left corner edge case
            if (polledNode.i == 0 && polledNode.j == 0) {
                if(matrix[polledNode.i][polledNode.j+1]==1){
                    Node adjacentNode= new Node(polledNode.i, polledNode.j+1);
                    if(!visitedNodes.contains(adjacentNode)){
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i+1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i+1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)){
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
            }
            //upper right corner edge case
            else if(polledNode.i == 0 && polledNode.j == matrix[polledNode.i].length-1){
                if(matrix[polledNode.i][polledNode.j-1]==1){
                    Node adjacentNode=new Node(polledNode.i, polledNode.j - 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i+1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i + 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
            }

            //bottom left corner edge case
            else if(polledNode.i==matrix.length-1&&polledNode.j==0){
                if(matrix[polledNode.i-1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i - 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i][polledNode.j+1]==1){
                    Node adjacentNode=new Node(polledNode.i, polledNode.j + 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
            }
            //bottom right corner edge case
            else if(polledNode.i==matrix.length-1&&polledNode.j==matrix[polledNode.i].length-1){
                if(matrix[polledNode.i][polledNode.j-1]==1){
                    Node adjacentNode=new Node(polledNode.i, polledNode.j - 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i-1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i - 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
            }

            else if(polledNode.i==0){
                if(matrix[polledNode.i][polledNode.j-1]==1){
                    Node adjacentNode=new Node(polledNode.i, polledNode.j - 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i][polledNode.j+1]==1){
                    Node adjacentNode=new Node(polledNode.i, polledNode.j + 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i+1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i + 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
            }

            else if(polledNode.j==0){
                if(matrix[polledNode.i-1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i - 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i+1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i + 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i][polledNode.j+1]==1){
                    Node adjacentNode=new Node(polledNode.i, polledNode.j + 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
            }
            else if(polledNode.i==matrix.length-1){
                if(matrix[polledNode.i][polledNode.j-1]==1){
                    Node adjacentNode=new Node(polledNode.i, polledNode.j - 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i][polledNode.j+1]==1){
                    Node adjacentNode=new Node(polledNode.i, polledNode.j + 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i-1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i - 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
            }
            else if(polledNode.j==matrix[polledNode.i].length-1){
                if(matrix[polledNode.i-1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i - 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i+1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i + 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i][polledNode.j-1]==1){
                    Node adjacentNode=new Node(polledNode.i, polledNode.j - 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
            }
            //every other case that is not an edge case
            else{
                if(matrix[polledNode.i-1][polledNode.j]==1){
                    Node adjacentNode=new Node(polledNode.i - 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i+1][polledNode.j]==1){
                    Node adjacentNode= new Node(polledNode.i + 1, polledNode.j);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i][polledNode.j-1]==1){
                    Node adjacentNode=new Node(polledNode.i, polledNode.j - 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
                if(matrix[polledNode.i][polledNode.j+1]==1){
                    Node adjacentNode= new Node(polledNode.i, polledNode.j + 1);
                    if(!visitedNodes.contains(adjacentNode)) {
                        queue.offer(adjacentNode);
                        visitedNodes.add(adjacentNode);
                        adjacentNodes.add(adjacentNode);
                    }
                }
            }

           breadFirstSearch(matrix, queue, visitedNodes,  adjacentNodes);
        }
        return adjacentNodes.size();
    }



}
