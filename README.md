# Job Scheduler

## Overview

The Job Scheduler is a Java application designed to simulate various CPU scheduling algorithms. Users can select from different scheduling strategies to see how they impact process execution. The main algorithms implemented are:

- **First-Come, First-Served (FCFS)**
- **Shortest Job First (SJF)**
- **Round Robin (RR)**
- **Preemptive Priority Scheduling**

This project aims to provide an interactive platform for users to understand and visualize the effects of different scheduling methods.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Algorithms](#algorithms)
  - [1. First-Come, First-Served (FCFS)](#1-first-come-first-served-fcfs)
  - [2. Shortest Job First (SJF)](#2-shortest-job-first-sjf)
  - [3. Round Robin (RR)](#3-round-robin-rr)
  - [4. Preemptive Priority Scheduling](#4-preemptive-priority-scheduling)
- [Data Structures](#data-structures)
- [Collection Framework](#collection-framework)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/job-scheduler.git
   cd job-scheduler
2. **Compile the Java files:**
   ```bash
   javac *.java
3. **Run the Application:***
   ```bash
   Java SchedulerMain.java

## Usage
Upon running the application, users will be prompted to select a scheduling algorithm. Depending on the chosen algorithm, users will need to input the following details for each process:

Arrival Time
Burst Time
Priority (for priority scheduling algorithms)

After entering the process details, the application will calculate and display the following metrics for each process:

Completion Time
Turnaround Time
Waiting Time

## Algorithms
### 1. First-Come, First-Served (FCFS)
The FCFS scheduling algorithm executes processes in the order they arrive. The first process to arrive is the first to be executed.

Data Structures Used
Array: To store the process details (arrival time, burst time, etc.)
Collection Framework Used
None: This algorithm uses a simple array to manage process data.

### 2. Shortest Job First (SJF)
The SJF algorithm selects the process with the smallest burst time for execution next.

Data Structures Used
Array: To store process details.
Sorting Algorithm: To sort the processes based on burst time.
Collection Framework Used
None: The implementation relies on basic arrays and sorting functions to manage process data.

### 3. Round Robin (RR)
The Round Robin scheduling algorithm assigns a fixed time unit (quantum) to each process. If a process does not finish within its allocated time, it is sent to the back of the queue.

Data Structures Used
Array: To store process details.
Queue: To manage the processes in a circular manner.
Collection Framework Used
ArrayList: Used to dynamically manage the list of processes, allowing for easy addition and removal of processes as they are scheduled.

### 4. Preemptive Priority Scheduling
This algorithm selects processes based on priority. If a new process arrives with a higher priority than the currently running process, it preempts the current process.

Data Structures Used
Array: To store process details.
Sorting Algorithm: To sort the processes based on priority.
Collection Framework Used
PriorityQueue: Used to efficiently manage processes based on their priority, allowing for easy retrieval of the highest priority process.


