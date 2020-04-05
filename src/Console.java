import edu.princeton.cs.introcs.Stopwatch;

import java.util.Scanner;

public class Console {

    private static MaxFlowAlgorithm m = new MaxFlowAlgorithm();


    // Method to calculate time taken for the algorithm
    private static void maxFlow(int[][] graph, int vertices) {
        Stopwatch timer = new Stopwatch();
        System.out.println("The maximum possible flow is " +
                m.fordFulkerson(GraphData.graph, 0, vertices - 1) + "\n" +
                timer.elapsedTime());
    }


    // Console program
    public static void main(String[] args) {

        // Variable to run loop
        boolean loop = true;

        Scanner sc = new Scanner(System.in);


        // Loop consisting of cases for each graph the user may select to choose from
        while (loop) {
            System.out.println("Max Flow Algorithm!!" + "\n" +
                    "There are 4 Graphs to choose from each double in size to the previous" + "\n" +
                    "Please enter 1, 2, 3 or 4 to proceed or 5 to exit" + "\n" +
                    "(1 is the smallest 4 is the largest): ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    MaxFlowAlgorithm.vertices = 12;
                    Console.maxFlow(GraphData.graph, MaxFlowAlgorithm.vertices);
                    break;
                case 2:
                    MaxFlowAlgorithm.vertices = 24;
                    Console.maxFlow(GraphData.graph2, MaxFlowAlgorithm.vertices);
                    break;
                case 3:
                    MaxFlowAlgorithm.vertices = 48;
                    Console.maxFlow(GraphData.graph3, MaxFlowAlgorithm.vertices);
                    break;
                case 4:
                    MaxFlowAlgorithm.vertices = 96;
                    Console.maxFlow(GraphData.graph4, MaxFlowAlgorithm.vertices);
                    break;
                case 5:
                    loop = false;
            }
        }
    }


}








