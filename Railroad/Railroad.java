import java.util.*;

public class Railroad{
    
    String moves;
    MyStack rstk;
    MyStack mstk;
    MyStack lstk;
    
    public Railroad(){
        rstk = new MyStack<Integer>();
        mstk = new MyStack<Integer>();
        lstk = new MyStack<Integer>();
        for(int i=6; i>=1; i--){rstk.push(i);}
    }
    
    public Integer R(){
        Integer value = (Integer) rstk.pop();
        mstk.push(value);
        moves += "R ";
        return value;
    }
    
    public Integer L(){
        Integer value = (Integer) mstk.pop();
        lstk.push(value);
        moves += "L ";
        return value;
    }
    
    public static ArrayList<String> rrSwitch(int[] desired){
        Railroad RR = new Railroad();
        RR.moves = "";
        for(int cur : desired){
            if(RR.rstk.isEmpty() && RR.mstk.isEmpty()){break;} //this *shouldn't* happen, but JIC
            else if(RR.mstk.isEmpty()){RR.R();} //move the first car over to mstk
            if((Integer) RR.mstk.peek() == cur){RR.L();} //simplest answer
            else if((Integer)RR.mstk.peek() > cur){ //the car we want is burried in mstk; stop here
                break;
            }
            else{
                while(RR.R() != cur){;} //move cars from rstk to mstk until we find the one we want
                RR.L(); //then move to lstk
            }
        }
        ArrayList<String> toReturn = new ArrayList<String>(4);
        toReturn.add(RR.moves.trim());
        String temp = "";
        while(!RR.lstk.isEmpty()){temp = RR.lstk.pop() + " " + temp;}
        toReturn.add(temp.trim());
        temp = "";
        while(!RR.mstk.isEmpty()){temp += RR.mstk.pop() + " ";}
        toReturn.add(temp.trim());
        temp = "";
        while(!RR.rstk.isEmpty()){temp += RR.rstk.pop() + " ";}
        toReturn.add(temp.trim());
//        for(String s : toReturn){
//            if(s.length() > 0){s = s.substring(0,s.length()-1);}
//        }
        return toReturn;
    }
    
    public static void main(String[] args){
        Railroad R = new Railroad();
        String[] inputString = args[0].split(",",6);
        if(inputString.length > 6){
            System.out.println("invalid input.");
            System.exit(0);
        }
        int[] input = new int[6];
        for(int i = 0; i<inputString.length; i++){
            try{input[i] = Integer.parseInt(inputString[i]);}
            catch(NumberFormatException e){
                System.out.println("invalid input.");
                System.exit(0);
            }
        }
        ArrayList<String> result = R.rrSwitch(input);
        for(String s : result){System.out.println(s);}
    }
}