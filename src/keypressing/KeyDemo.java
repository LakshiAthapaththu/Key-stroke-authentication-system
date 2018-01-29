package keypressing;

import java.sql.SQLException;
import java.util.ArrayList;

public class KeyDemo {
    ArrayList<String> allmails = new ArrayList<>();
    ArrayList<String> allpw = new ArrayList<>();
    ConnectDB con = new ConnectDB();
    String pw ="";
    //interface_of b = new interface_of();
    ArrayList<String> mail = new ArrayList<>(10);
    ArrayList<String> pass = new ArrayList<>(10);
    ArrayList<Double> mailtime = new ArrayList<>(10);
    ArrayList<Double> pwtime = new ArrayList<>(10); 
    ArrayList<Double> pressed = new ArrayList<>();
    ArrayList<Double> released = new ArrayList<>();
    ArrayList<Double> typed = new ArrayList<>();
    String str ="";
    double totemail;
    double totpw;
  public void addToArray(String email,String pw){
      allmails.add(email);
      allpw.add(pw);
      
   }  
  public ArrayList returnMails(){
      return allmails;
  }
   public ArrayList returnpw(){
      return allpw;
  }
  
  public double getTotal(ArrayList array){  
    double tot=0;
    for(int i=0; i < array.size() ; i++){
        tot += (double)array.get(i);
    }
    
    return tot;
  }
  
  public double getAvarage(ArrayList array){
      return (double)getTotal(array)/array.size();
  }
  
  
  public double nfoldCrossDiffAvg(ArrayList array,double tot){
      double diff = 0,val,arrayAvg;
      for(int i=0; i < array.size() ; i++){
          val = (double)array.get(i);
          arrayAvg = (double)(tot - val)/(array.size()-1);
          if(arrayAvg > val){
              diff += (arrayAvg - val);
          } else {
              diff += (val - arrayAvg);
          }
      }
      
      return diff/(array.size()*2);
  }
  public ArrayList remove(ArrayList array,int l){
      ArrayList<String> newArray = new ArrayList<>();
      for(int i=0; i<array.size();i++){
          if(((array.get(i)).toString()).length() == l){
              newArray.add((String) array.get(i));
              
          }
      }
      System.out.println("This is my newarray " + newArray);
      return newArray;
      
  }
  public boolean check(ArrayList array){
      boolean same=true;
      String first = (String)(array.get(0));
      for(int i=0; i<array.size();i++){
          if(first.equals((String)(array.get(i)))==false){
              same = false;
              break;
          }
      }
      return same;
  }
  public ArrayList getBin(ArrayList array){
      ArrayList<String> bin = new ArrayList<>();
      ArrayList<ArrayList> binar = new ArrayList<>();
      for(int i=0;i<array.size();i++){
          String binnum="";
          for(int j=0;j<array.get(i).toString().length();j++){
              binnum+=Integer.toBinaryString(array.get(i).toString().charAt(j));
          }
       bin.add(binnum);
      }
      System.out.println(bin);
      for(int k =0;k<bin.size();k++){
          ArrayList<Integer> str= new ArrayList<>();
          for(int l=0;l<bin.get(k).length();l++){
              str.add(Character.getNumericValue((bin.get(k).charAt(l))));
          }
          binar.add(str);
      }
      
      
      
      
      
      System.out.println(bin.get(0).length());
      return binar;

  }
  public void signUpAction(int counter,String email,String password) throws SQLException{
      if(counter<10){
           mail.add(str);
           pass.add(pw);
           mailtime.add(totemail);
           pwtime.add(totpw);
           totemail = 0;
           totpw = 0;
           str ="";
           pw="";
           addToArray(email, password);
         
        }
      else if (counter == 10){
           mail.add(str);
           pass.add(pw);
           mailtime.add(totemail);
           pwtime.add(totpw);
           totemail = 0;
           totpw = 0;
           str ="";
           pw="";
           addToArray(email, password);
            System.out.println("ok you entered 10 times");
            System.out.println(mail);
            System.out.println(pass);
            System.out.println(mailtime);
            System.out.println(pwtime);
            System.out.println(pressed);
            System.out.println(typed);
            System.out.println(released);
            System.out.println(returnMails());
            System.out.println(returnpw());
            if(check(returnMails()) && check(returnpw())){
            //System.out.println(kd.remove(mail, (mail).get(0).toString().length()));
            System.out.println(getTotal(mailtime));
            System.out.println(getTotal(pwtime));
            
            Double rangemail=(nfoldCrossDiffAvg(mailtime, getTotal(mailtime)));
            System.out.println((getAvarage(mailtime)-rangemail)+" "+(getAvarage(mailtime)+rangemail));
            Double rangepw = nfoldCrossDiffAvg(pwtime, getTotal(pwtime));
            System.out.println((getAvarage(pwtime)-rangepw)+" "+(getAvarage(pwtime)+rangepw));
            Double rangepressed = nfoldCrossDiffAvg(pressed, getTotal(pressed));
            System.out.println((getAvarage(pressed)-rangepressed)+" "+(getAvarage(pressed)+rangepressed));
            Double rangetyped = nfoldCrossDiffAvg(typed, getTotal(typed));
            System.out.println((getAvarage(typed)-rangetyped)+" "+(getAvarage(typed)+rangetyped));
            Double rangereleased = nfoldCrossDiffAvg(released, getTotal(released));
            System.out.println((getAvarage(released)-rangereleased)+" "+(getAvarage(released)+rangereleased));
            con.insertIntoDBuser(returnMails().get(0).toString(),returnpw().get(0).toString());
            //System.out.println(kd.getBin(mail));
            con.insertIntoRanges((getAvarage(mailtime)+rangemail),(getAvarage(mailtime)-rangemail),(getAvarage(pwtime)+rangepw),
                   (getAvarage(pwtime)-rangepw),(getAvarage(pressed)+rangepressed),(getAvarage(pressed)-rangepressed),
                   (getAvarage(typed)+rangetyped),(getAvarage(typed)-rangetyped),(getAvarage(released)+rangereleased),
                   (getAvarage(released)-rangereleased),email);
            }
            else{
                System.out.println("invalid data");
            }
           
            
            
        } else {
            
        }
  }
  public void signinAction(String eemail,String ppw) throws SQLException{
       if (eemail.equals("")==false && ppw.equals("")==false){
           //System.out.println("gya");
           
            
            System.out.println(totemail);
            System.out.println(totpw);
            //System.out.println(pressed);
            //System.out.println(typed);
            //System.out.println(released);
            
            
            //Double rangepressed = nfoldCrossDiffAvg(pressed, getTotal(pressed));
            System.out.println((getAvarage(pressed)));
            //Double rangetyped = nfoldCrossDiffAvg(typed, getTotal(typed));
            System.out.println((getAvarage(typed)));
            //Double rangereleased = nfoldCrossDiffAvg(released, getTotal(released));
            System.out.println((getAvarage(released)));
            con.getDataRanges(eemail,ppw,totemail,totpw,(double)getAvarage(pressed),(double)getAvarage(typed),(double)getAvarage(released));
            //welcomePage l = new welcomePage();
            //l.setVisible(true);
            //b.dispose();
            totemail =0 ;
            totpw = 0;
           
       }
  }
  
}