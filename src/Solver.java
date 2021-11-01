import java.sql.Array;
import java.util.Arrays;
/**
 * Solver class for the queens.
 */

public class Solver {

    private int noOfQueens;
    private int[] queens;
    private int noOfSolutions;
    private boolean showSolutions;

    public  void findAllSolutions(int noOfQueens) {
        this.noOfQueens = noOfQueens;
        this.noOfSolutions = 0;
        queens = new int[noOfQueens];
        if (!showSolutions) {
            System.out.println("*******************************");
            System.out.println("Solutions for " + noOfQueens + " queens");
            System.out.println("");
            positionQueens(0);
            System.out.println("");
            long time = System.currentTimeMillis();
            System.out.println("A total of " + noOfSolutions + " solutions were found");
            System.out.println("Within " + (System.currentTimeMillis() - time) + " ms");
            System.out.println("*******************************");
        } else {
            positionQueens(0);
        }
    }

    private void positionQueens(int row) {
            if(row >= noOfQueens) {
                noOfSolutions++;
                if(!showSolutions) {
                    printSolution();
                }
            } else {
                for (int i = 0; i < noOfQueens; i++) {
                    if (legal(row, i)) {
                        queens[row] = i;
                        positionQueens(row + 1);
                    }
                }
            }
    }

    private boolean legal(int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (queens[i] == col || queens[i] == col + (row-i) || queens[i] == col - (row - i)) {
                return false;
            }
        }
        return true;
    }
    public void findNoOfSolutions(int min, int max) {
        showSolutions = true;
        System.out.println("********************************************************");
        System.out.println("   Queens       Solutions  Time(ms)  Solutions/ms");
        long tine = System.currentTimeMillis();
        for (int i = min; i <= max; i++) {
            findAllSolutions(i);
            long time = (System.currentTimeMillis()-tine) + 1;
            System.out.format("%6d %,12d %,10d %,12d %n", noOfQueens, noOfSolutions, time, (noOfSolutions/time));
        }
        System.out.println("********************************************************");
    }

    private void printSolution() {
        if(showSolutions); {
            for (int i = 0; i < queens.length; i++) {
                System.out.print(convert(i, queens[i]) + " ");
            }
        }
        System.out.println("");
    }

    private String convert(int row, int col) {
        var ch = "abcdefghijklmnopqrstuvwxyz".charAt(col);
            return "" + ch + (row + 1);
    }
    public static void testSolver() {
        Solver s = new Solver();
        s.findAllSolutions(1);
        s.findAllSolutions(2);
        s.findAllSolutions(6);
        s.findNoOfSolutions(1,12);
    }
    }

