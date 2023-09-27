import java.util.*;
import static java.lang.System.*;
class Problem1{
    public static void main(String[] args){
        Scanner sc = new Scanner(in);
        out.print("Please enter the given note sequence: ");
        String given = sc.nextLine();
        out.print("Please enter your played note sequence: ");
        String played = sc.nextLine();
        int[][] lcs = new int[given.length()+1][played.length()+1];
        for(int row = 1; row < played.length()+1; row++){
            for(int column = 1; column < given.length()+1; column++){
                if(given.charAt(column-1) == played.charAt(row-1))
                    lcs[column][row] = lcs[column-1][row-1] + 1;
                else if(lcs[column-1][row] > lcs[column][row-1])
                    lcs[column][row] = lcs[column-1][row];
                else
                    lcs[column][row] = lcs[column][row-1];
            }
        }
        int accuracy = (100 * (lcs[given.length()][played.length()])) / given.length();
        
        String substring = "";
        for(int row = played.length(); row > 0; row--){
            for(int column = given.length(); column > 0; column--){
                if(((lcs[column][row] == lcs[column-1][row]) || (lcs[column][row] == lcs[column-1][row])) && (lcs[column][row]-1 != lcs[column-1][row-1])){
                    if(lcs[column][row] == lcs[column][row-1]){
                        row = row - 1;
                        if(row < 1)
                            break;
                        column = column + 1;
                        //continue;
                    } else {
                        //continue
                    }
                } else {
                    substring = played.charAt(row-1) + substring;
                    row = row - 1;
                    if(row < 1)
                            break;
                    //continue;
                }
            }
        }
        out.printf("Longest common note played: %s.%n", substring);
        out.printf("%d%% Passed.%n", accuracy);
        sc.close();
    }
}
/*
input
CDEFGABC
CEFDABGAC
*/