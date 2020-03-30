import edu.princeton.cs.introcs.Stopwatch;

import java.util.Scanner;

public class Console {

    // Console program
    public static void main(String[] args) {

        // Variable to run loop
        boolean loop = true;

        Scanner sc = new Scanner(System.in);
        MaxFlowAlgorithm m = new MaxFlowAlgorithm();
        GraphData gd = new GraphData();

        // Loop consisting of cases for each graph the user may select to choose from
        while(loop) {
            System.out.println("Max Flow Algorithm!!" + "\n" +
                    "There are 4 Graphs to choose from each double in size to the previous" + "\n" +
                    "Please enter 1, 2, 3 or 4 to proceed or 5 to exit" + "\n" +
                    "(1 is the smallest 4 is the largest): ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    m.vertices = 6;
                    Stopwatch timer = new Stopwatch();
                    System.out.println("The maximum possible flow is " +
                            m.fordFulkerson(gd.graph, 0, 5) + "\n" +
                            timer.elapsedTime());
                    break;
                case 2:
                    m.vertices = 12;
                    Stopwatch timer2 = new Stopwatch();
                    System.out.println("The maximum possible flow is " +
                            m.fordFulkerson(gd.graph2, 0, 11) + "\n" +
                            timer2.elapsedTime());
                    break;
                case 3:
                    m.vertices = 24;
                    Stopwatch timer3 = new Stopwatch();
                    System.out.println("The maximum possible flow is " +
                            m.fordFulkerson(gd.graph3, 0, 23) + "\n" +
                            timer3.elapsedTime());
                    break;
                case 4:
                    m.vertices = 48;
                    Stopwatch timer4 = new Stopwatch();
                    System.out.println("The maximum possible flow is " +
                            m.fordFulkerson(gd.graph4, 0, 47) + "\n" +
                            timer4.elapsedTime());
                    break;
                case 5:
                    loop = false;
            }
        }
    }
}








