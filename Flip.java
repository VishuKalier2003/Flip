/* Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'...
A region is captured by flipping all 'O's into 'X's in that surrounded region...
* Eg 1 : Input = ['X','X','X','X']                  Output = ['X','X','X','X'] 
*                ['X','O','O','X']                           ['X','X','X','X']
*                ['X','X','O','X']                           ['X','X','X','X']
*                ['X','O','X','X']                           ['X','O','X','X']
* Eg 2 : Input = [X]                               Output = [X]
*/
import java.util.*;
public class Flip
{
    public char[][] SurroundedRegions(char board[][])
    {
        for(int i = 0; i < board.length; i++)     // Printing the Board for visualization...
        {
            for(int j = 0; j < board[0].length; j++)
                System.out.print(board[i][j]+", ");    // Generating the Input matrix...
            System.out.println();
        }
        char Answer[][] = new char[board.length][board[0].length];    // Creating the Output matrix...
        for(int i = 0; i < board.length; i++)
            Arrays.fill(Answer[i], 'O');      // Filling the output matrix with 'O' value...
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)   
                Answer = IterativeSearch(board, i, j, Answer);   // Calling the Search for every cell...
        }
        System.out.println("After Capturing the Regions the Board looks like : ");
        for(int i = 0; i < board.length; i++)     // Printing the output matrix...
        {
            for(int j = 0; j < board[0].length; j++)
                System.out.print(Answer[i][j]+", ");
            System.out.println();
        }
        return Answer;      // Returning the Output board...
    }
    public char[][] IterativeSearch(char board[][], int row, int col, char Answer[][])
    {
        if((row - 1 != 1) && (board[row - 1][col] == 'O') && (board[row][col] == 'O'))
            Answer[row][col] = 'X';    // If the element to left is 'O'...
        else if((row + 1 != board.length) && (board[row + 1][col] == 'O') && (board[row][col] == 'O'))
            Answer[row][col] = 'X';    // If the element to right is 'O'...
        else if((col - 1 != -1) && (board[row][col - 1] == 'O') && (board[row][col] == 'O'))
            Answer[row][col] = 'X';    // If the element to top is 'O'...
        else if((col + 1 != board[0].length) && (board[row][col + 1] == 'O') && (board[row][col] == 'O'))
            Answer[row][col] = 'X';    // If the element to bottom is 'O'...
        if((board[row][col] == 'X') && (Answer[row][col] == 'O'))
            Answer[row][col] = 'X';    // If element on Input Board is 'X' and Output Board is 'O'...
        return Answer;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m, n;
        System.out.print("Enter board length : ");
        m = sc.nextInt();
        System.out.print("Enter board breadth : ");
        n = sc.nextInt();
        char board[][] = new char[m][n];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                System.out.print("Enter row "+(i+1)+" and column "+(j+1)+" data : ");
                board[i][j] = sc.next().charAt(0);
            }
        }
        Flip flip = new Flip();       // Object creation...
        board = flip.SurroundedRegions(board);           // Function calling...
        sc.close();
    }
}


// Time Complexity - O(N x M) time...
// Space Complexity - O(N x M) space...

/* DEDUCTIONS :-
 * 1. We check for the four cardinal directions of every cell in the given matrix...
 * 2. We exclude the conditions of corner cells, then we check for the condition of adjacency and then evaluate the Output matrix...
 */