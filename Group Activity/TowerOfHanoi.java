/**
 * This Java program implements an application that prints the step-by-step of the puzzle game Tower of Hanoi to the standard output.
 * Only one disk can be moved at a time.
 * A disk can only be moved if it is the uppermost disk on a stack.
 * No disk may be placed on top of a smaller disk.
 * 
 * 
 * Exception Handling: ArithmeticException
 * - Type of exception that checks the code for unusual errors. This is a throwable exception which is instigated when a 
 * 	mathematical operation error appears during runtime.
 * 
 * 
 * @author Francyne Rigor
 * @author Jillian Marie Hernandez
 * @author Wildelyn Arriesgado
 * @version 1.0
 * @since 2023-01-24
 * 
 * */

package GrpAct;

import java.util.*;

public class TowerOfHanoi { 
	public static void main(String[] args) {
		
		// main method
		Scanner sc = new Scanner(System.in); // instantiates a scanner class
		System.out.println("Enter number of disks to stack: "); // prompts the user to enter his desired number of disks
		int diskInput = sc.nextInt(); // initializes variable for diskInput and stores the desired number of disk
		
		checkDisk(diskInput); // method call that checks the number of disks set by the user

		int numDisk = diskInput; // passes the value of diskInput to numDisk
		
		String solutionSteps = hanoi(numDisk, 1, 3); // function call
		
		// advanced for loop that prints steps for sol1, sol2, sol3
		for(String step : solutionSteps.split(";")) { 
			System.out.println(step);
			
		}
		
	}
	
	// recursion method that returns a String which contains all the commands
	public static String hanoi(int numDisk, int fromRod, int toRod) { 
		
		// base case: if the numDisk is equal to 1, it will return the command
		if (numDisk == 1) { 
			return "Move disk 1 from rod " + fromRod + " -> " + " rod " + toRod + ";";
		}
		
		// recursive method: command that calculates the steps of the disk
		else {
			String sol1, sol2, sol3; // declare variables 
			int auxRod = 6 - fromRod - toRod;
			
			sol1 = hanoi(numDisk - 1, fromRod, auxRod); // used to solve the subproblem of moving the numDisk-1 top disk from the "fromRod" to "auxRod" using the "toRod" as backup.
			sol2 = "Move disk " + numDisk + " from rod " + fromRod + " -> " + "rod " + toRod + ";";
			sol3 = hanoi(numDisk - 1, auxRod, toRod); // used to transfer the numDisk-1 top disk from "auxRod" to "toRod" with "fromRod" acting as an extra.
			
			return sol1 + sol2 + sol3;
		}
	}
	
	// exception method that checks if the disk can or cannot be stacked
	static void checkDisk(int diskInput) {
		// if disk input is less than 1 or greater than or equal to nine, throws exception and prints "CANNOT STACK"
		if (diskInput < 1 || diskInput >= 9) {
			throw new ArithmeticException("CANNOT STACK!"); // indicates that an error has occurred during the execution of the program and that the program cannot continue
		// when disk input is within range, it will print the movement of disks + solution steps
		} else { 
			System.out.println("These are the movements of the disks: ");
		}
	}
}
