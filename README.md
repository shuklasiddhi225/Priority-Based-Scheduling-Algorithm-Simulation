# Priority-Based-Scheduling-Algorithm-Simulation

This is a Java program that simulates a priority-based process scheduling algorithm. It calculates various performance metrics such as waiting time, turn-around time and displays those metrics in additional to start and end times for each process.

## Classes

- **Process**: This class represents a process. It consists of PID (Process ID), Burst Time, Priority, Start Time, and End Time attributes.

- **PriorityScheduling**: This class contains the scheduling algorithm, various utility methods for calculating waiting time, turnaround time etc., and a main function to interact with the user.

## Functions

- **findWaitingTime**: A function to calculate the waiting time for all the processes.

- **findTurnAroundTime**: A function to calculate the turn around time for all the processes.

- **findAverageTime**: A function to compute average waiting and turn-around times.

- **priorityScheduling**: This method sorts the processes in ascending order of their priority and then executes them. It then calls the findAverageTime method to calculate the performance metrics.

## Usage

To use this program, follow these steps:

1. Compile the java code using a java compiler.
2. Run the program.
3. The program will ask for the number of processes to be executed.
4. You will then need to enter the burst time and priority for each process.
5. The program will then calculate the average waiting time, average turn around time and create a Gantt chart showing the start and end times for each process.
6. Finally, it will also display a text-based line chart of the process execution.

This simulation of priority scheduling algorithm provides a clear and concise view of how an operating system's priority-based process scheduler might work.
