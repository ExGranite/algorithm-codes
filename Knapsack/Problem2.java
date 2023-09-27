import java.io.*;
import java.util.*;
import static java.lang.System.*;
class Problem2{
    public static void main(String[] args){
        try{
            String str;
            FileReader fr = new FileReader("2.txt");
            BufferedReader obj = new BufferedReader(fr);
            int weight = Integer.parseInt(obj.readLine());
            int trophies = Integer.parseInt(obj.readLine());
            Trophy[] trophy = new Trophy[trophies];
            for(int i = 0; i < trophies; i++){
                str = obj.readLine();
                trophy[i] = new Trophy(str.split(", ", 4));
            }
            obj.close();
            int[][] price = new int[trophies+1][weight+1];
            for(int i = 0; i < trophies + 1; i++){
                for(int w = 0; w < weight + 1; w++){
                    if(i==0 || w==0){
                        price[i][w] = 0;
                    }else if(w >= trophy[i-1].weight){
                        price[i][w] = Math.max(price[i-1][w], price[i-1][w-(trophy[i-1].weight)]+trophy[i-1].price);
                    }else{
                        price[i][w] = price[i-1][w];
                    }
                }
            }
            String index = "";
            int i = trophies, w = weight;
            while(i > 0 && w > 0){
                if(price[i][w] == price[i][w-1]){
                    w--;
                }else if(price[i][w] == price[i-1][w]){
                    i--;
                }else{
                    index = i + " " + index;
                    if((price[i][w] - trophy[i-1].price) == price[i-1][w]){
                        i--;
                    }else{
                        i--;
                        w -= trophy[i-1].weight;
                    }
                }
            }
            StringTokenizer st = new StringTokenizer(index, " ");
            String pl = trophy[Integer.parseInt(st.nextToken())-1].club;
            while(st.hasMoreTokens()){
                pl += "-->" + trophy[Integer.parseInt(st.nextToken())-1].club;
            }
            out.printf("Name of clubs whose trophies were sold: %s.%n", pl);
            out.printf("Maximum money he earned: %.1fmillion.%n", Double.valueOf(price[price.length-1][price[0].length-1])/10);
        }
        catch(Exception a){
            err.println(a);
            a.printStackTrace();
        }
    }
}

class Trophy {
    String name, club;
    int weight;
    int price;
    Trophy(String[] s){
        club = s[0]; weight = Integer.parseInt(s[1]); price = (int)(Double.parseDouble(s[2])*10); name = s[3];
    }
}