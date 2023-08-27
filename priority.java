import java.util.*;

class Process {
    int pid;
    int burstTime;
    int priority;
    int startTime;
    int endTime;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

class PriorityScheduling {

    public static void findWaitingTime(Process[] proc, int n, int wt[]) {
        wt[0] = 0;
        proc[0].startTime = 0;
        proc[0].endTime = proc[0].burstTime;

        for (int i = 1; i < n; i++) {
            wt[i] = proc[i - 1].burstTime + wt[i - 1];
            proc[i].startTime = wt[i];
            proc[i].endTime = proc[i].startTime + proc[i].burstTime;
        }
    }

    public static void findTurnAroundTime(Process[] proc, int n, int wt[], int tat[]) {
        for (int i = 0; i < n; i++)
            tat[i] = proc[i].burstTime + wt[i];
    }

    public static void findAverageTime(Process[] proc, int n) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        findWaitingTime(proc, n, wt);

        findTurnAroundTime(proc, n, wt, tat);

        System.out.println("Processes    " + " Burst time     " + " Waiting time    " + " Turn around time");

        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.println(" " + proc[i].pid + "\t\t" + proc[i].burstTime + "\t\t " + wt[i] + "\t\t" + tat[i]);
        }

        System.out.println("Average waiting time = " + (float) total_wt / (float) n);
        System.out.println("Average turn around time = " + (float) total_tat / (float) n);

        System.out.println("Gantt Chart");
        for (int i = 0; i < n; i++) {
            System.out.println("Process " + proc[i].pid + ": starts at " + proc[i].startTime + " and ends at " + proc[i].endTime);
        }

        System.out.println("Text-based Line Chart");
        for (int i = 0; i < n; i++) {
            System.out.print("|--- P" + proc[i].pid + " ---| ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(proc[i].startTime + "         " + proc[i].endTime + " ");
        }
    }

    static void priorityScheduling(Process[] proc, int n) {
        Arrays.sort(proc, new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                return p1.priority - p2.priority;
            }
        });

        System.out.println("Order in which processes gets executed");
        for (int i = 0; i < n; i++)
            System.out.print(proc[i].pid + " ");
        System.out.println();

        findAverageTime(proc, n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        int n = in.nextInt();
        Process[] proc = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter burst time and priority for process " + (i + 1) + ": ");
            int burstTime = in.nextInt();
            int priority = in.nextInt();
            proc[i] = new Process(i + 1, burstTime, priority);
        }

        priorityScheduling(proc, n);
    }
}
