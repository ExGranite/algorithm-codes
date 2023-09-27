import java.util.*;
import static java.lang.System.*;
class Problem2{
    public static void main(String[] args){
        Scanner sc = new Scanner(in);
        out.print("Please enter the word index(s) for Ross's joke: ");
        String ross = sc.nextLine();
        out.print("Please enter the word index(s) for Chandler's joke: ");
        String chandler = sc.nextLine();
        int[][] lcs = new int[ross.length()+1][chandler.length()+1];
        for(int row = 1; row < chandler.length()+1; row++){
            for(int column = 1; column < ross.length()+1; column++){
                if(ross.charAt(column-1) == chandler.charAt(row-1))
                    lcs[column][row] = lcs[column-1][row-1] + 1;
                else if(lcs[column-1][row] > lcs[column][row-1])
                    lcs[column][row] = lcs[column-1][row];
                else
                    lcs[column][row] = lcs[column][row-1];
            }
        }
        
        String substring = "";
        for(int row = chandler.length(); row > 0; row--){
            for(int column = ross.length(); column > 0; column--){
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
                    substring = chandler.charAt(row-1) + substring;
                    row = row - 1;
                    if(row < 1)
                            break;
                    //continue;
                }
            }
        }
        out.println(lcs[ross.length()][chandler.length()]);
        for(int i = 0; i < substring.length(); i++){
            if(substring.charAt(i) == 'M')
                out.print("monkeys ");
            else if(substring.charAt(i) == 'W')
                out.print("wearing ");
            else if(substring.charAt(i) == 'C')
                out.print("coats ");
            else if(substring.charAt(i) == 'A')
                out.print("are ");
            else if(substring.charAt(i) == 'D')
                out.print("doctors ");
            else if(substring.charAt(i) == 'B')
                out.print("because ");
            else if(substring.charAt(i) == 'O')
                out.print("of ");
            else if(substring.charAt(i) == 'E')
                out.print("evolution ");
            else if(substring.charAt(i) == 'R')
                out.print("results ");
            else if(substring.charAt(i) == 'E')
                out.print("eruption ");
            else {
                err.print("An unknown word was used!!");
                break;
            }
        }
        out.println();
        sc.close();
    }
}
/*
input
MWCADBOE
DMWCAROP
*/