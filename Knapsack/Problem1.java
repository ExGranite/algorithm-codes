import java.io.*;
import java.util.*;
import static java.lang.System.*;
class Problem1{
    public static void main(String[] args){
        try{
            String str;
            FileReader fr = new FileReader("1.txt");
            BufferedReader obj = new BufferedReader(fr);
            int budget = Integer.parseInt(obj.readLine());
            int playersNo = Integer.parseInt(obj.readLine());
            Players[] players = new Players[playersNo];
            for(int i = 0; i < playersNo; i++){
                str = obj.readLine();
                StringTokenizer st = new StringTokenizer(str, ", ");
                players[i] = new Players(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken());
            }
            obj.close();
            int[][] form = new int[playersNo + 1][budget + 1];
            for(int i = 0; i < playersNo + 1; i++){
                for(int w = 0; w < budget + 1; w++){
                    if(i==0 || w==0){
                        form[i][w] = 0;
                    }else if(w >= players[i-1].price){
                        form[i][w] = Math.max(form[i-1][w], form[i-1][w-(players[i-1].price)]+players[i-1].form);
                    }else{
                        form[i][w] = form[i-1][w];
                    }
                }
            }
            String index = "";
            int i = playersNo, w = budget;
            while(i > 0 && w > 0){
                if(form[i][w] == form[i][w-1]){
                    w--;
                }else if(form[i][w] == form[i-1][w]){
                    i--;
                }else{
                    index = i + " " + index;
                    if((form[i][w] - players[i-1].form) == form[i-1][w]){
                        i--;
                    }else{
                        i--;
                        w -= players[i-1].price;
                    }
                }
            }
            StringTokenizer st = new StringTokenizer(index, " ");
            String pl = players[Integer.parseInt(st.nextToken())-1].name;
            while(st.hasMoreTokens()){
                pl += "-->" + players[Integer.parseInt(st.nextToken())-1].name;
            }
            out.printf("Bought Players: %s.%n", pl);
            out.printf("Maximum summation of form: %d.%n", form[form.length-1][form[0].length-1]);
        }
        catch(Exception a){
            err.println(a);
            a.printStackTrace();
        }
    }
}

class Players {
    String name, position;
    int price, form;
    Players(String n, int p, int f, String po){
        name = n; price = p; form = f; position = po;
    }
}