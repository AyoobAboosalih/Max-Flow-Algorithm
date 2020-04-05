import edu.princeton.cs.introcs.Stopwatch;

import java.util.Scanner;

public class Console {

    private static MaxFlowAlgorithm m = new MaxFlowAlgorithm();
    static GraphData gd = new GraphData();


    // Method to calculate time taken for the algorithm
    private static void maxFlow(int[][] graph, int vertices) {
        Stopwatch timer = new Stopwatch();
        System.out.println("The maximum possible flow is " +
                m.fordFulkerson(graph, 0, vertices - 1) + "\n" +
                timer.elapsedTime());
    }

    public static void mainMenu() {
        System.out.println("Max Flow Algorithm!!" + "\n" +
                "Enter 1: To check the max Flow of all available graphs" + "\n" +
                "Enter 2: To delete a connection within a graph" + "\n" +
                "Enter 3: To exit!!");
    }

    public static void maxFlowMenu() {
        System.out.println("Max Flow Algorithm!!" + "\n" +
                "There are 4 Graphs to choose from each double in size to the previous" + "\n" +
                "Please enter 1, 2, 3 or 4 to proceed" + "\n" +
                "(1 is the smallest 4 is the largest): ");
    }

    public static void deleteMenu() {
        System.out.println("Delete a Connection!!" + "\n" +
                "There are 4 Graphs to choose from each double in size to the previous" + "\n" +
                "Please enter 1, 2, 3 or 4 to proceed" + "\n" +
                "(1 is the smallest 4 is the largest): ");
    }


    // Console program
    public static void main(String[] args) {

        // Variable to run loop
        boolean loop = true;

        Scanner sc = new Scanner(System.in);


        // Loop consisting of cases for each graph the user may select to choose from
        while (loop) {
            Console.mainMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Console.maxFlowMenu();
                    int graphSelected = sc.nextInt();
                    switch (graphSelected) {
                        case 1:
                            MaxFlowAlgorithm.vertices = 12;
                            maxFlow(GraphData.graph, MaxFlowAlgorithm.vertices);
                            continue;
                        case 2:
                            MaxFlowAlgorithm.vertices = 24;
                            maxFlow(GraphData.graph2, MaxFlowAlgorithm.vertices);
                            continue;
                        case 3:
                            MaxFlowAlgorithm.vertices = 48;
                            Console.maxFlow(GraphData.graph3, MaxFlowAlgorithm.vertices);
                            continue;
                        case 4:
                            MaxFlowAlgorithm.vertices = 96;
                            Console.maxFlow(GraphData.graph4, MaxFlowAlgorithm.vertices);
                            continue;
                        case 5:
                            loop = false;
                            continue;

                    }
                case 2:
                    int initialNode;
                    int endNode;
                    deleteMenu();
                    int deleteNodeGraph = sc.nextInt();
                    switch (deleteNodeGraph) {
                        case 1:
                            System.out.println("This graph has 12 nodes, numbered 0-11" + "\n" +
                                    "Enter the initial node: ");
                            initialNode = sc.nextInt();
                            System.out.println("Enter the end node: ");
                            endNode = sc.nextInt();
                            gd.deleteConnection(GraphData.graph, initialNode, endNode);
                            break;
                        case 2:
                            System.out.println("This graph has 24 nodes, numbered 0-23" + "\n" +
                                    "Enter the initial node: ");
                            initialNode = sc.nextInt();
                            System.out.println("Enter the end node: ");
                            endNode = sc.nextInt();
                            gd.deleteConnection(GraphData.graph, initialNode, endNode);
                            break;
                        case 3:
                            System.out.println("This graph has 48 nodes, numbered 0-47" + "\n" +
                                    "Enter the initial node: ");
                            initialNode = sc.nextInt();
                            System.out.println("Enter the end node: ");
                            endNode = sc.nextInt();
                            gd.deleteConnection(GraphData.graph, initialNode, endNode);
                            break;
                        case 4:
                            System.out.println("This graph has 96 nodes, numbered 0-95" + "\n" +
                                    "Enter the initial node: ");
                            initialNode = sc.nextInt();
                            System.out.println("Enter the end node: ");
                            endNode = sc.nextInt();
                            gd.deleteConnection(GraphData.graph, initialNode, endNode);
                            break;

                    }
                case 3:
                    loop = false;
                    continue;
            }
        }
    }


}








