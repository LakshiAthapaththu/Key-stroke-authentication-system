/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypressing;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lakshi Athapaththu
 */
public class ConnectDB {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private Statement st1;
    private ResultSet rs1;
    ArrayList<Object> ranges = new ArrayList<>();
    welcomePage wel = new welcomePage();
    
    public ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("ok");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keystroke","root","");
            st = con.createStatement();
        }
        catch(Exception ex){
            System.out.println("Error"+ex);
        }
    }
    
    public Integer getData(String eemail) throws SQLException{
        PreparedStatement statement = con.prepareStatement("select id from keystroke.user where email = ?");    
        statement.setString(1, eemail);    
        ResultSet rs = statement.executeQuery();
       //String query = "select id from user where email="+" "+eemail;
       //rs = st.executeQuery(query);
       int idof=0;
       //System.out.println("record from database");
       while(rs.next()){
           idof = rs.getInt("id");
           System.out.println("id is"+idof);
           
       }
     
       return idof;
       
    }
    public void getDataRanges(String eemail,String ppw, double mailt, double pwt, double presst,double typet,double releaset) throws SQLException{
        PreparedStatement statement; 
        PreparedStatement statement2;
        
        try {
            statement = con.prepareStatement("select id,password from keystroke.user where email = ?");
            statement.setString(1, eemail);    
            ResultSet rs = statement.executeQuery();
       //String query = "select id from user where email="+" "+eemail;
       //rs = st.executeQuery(query);
            int idof=0;
            String pw="";
            if(rs.next()==true ){
       //System.out.println("record from database");
                idof = rs.getInt("id");
                pw = rs.getString("password");
                
                System.out.println("id is"+idof);
                System.out.println("pw is"+pw);
                
           if(pw.equals(ppw)){
            statement2 = con.prepareStatement("select * from keystroke.ranges where id = ?");
            statement2.setString(1,Integer.toString(idof));    
            ResultSet rs2 = statement2.executeQuery();
            ArrayList<Double> mailtime = new ArrayList<>();
            ArrayList<Double> pwtime = new ArrayList<>();
            ArrayList<Double> press = new ArrayList<>();
            ArrayList<Double> type = new ArrayList<>();
            ArrayList<Double> release = new ArrayList<>();
            while(rs2.next()){
                    //idof = rs.getInt("id");
                    mailtime.add(rs2.getDouble("Mtime_upper_range"));
                    mailtime.add(rs2.getDouble("Mtime_lower_range"));
                    pwtime.add(rs2.getDouble("Ptime_upper_range"));
                    pwtime.add(rs2.getDouble("Ptime_lower_range"));
                    press.add(rs2.getDouble("pressed_upper_range"));
                    press.add(rs2.getDouble("pressed_lower_range"));
                    type.add(rs2.getDouble("typed_upper_range"));
                    type.add(rs2.getDouble("typed_lower_range"));
                    release.add(rs2.getDouble("released_upper_range"));
                    release.add(rs2.getDouble("released_lower_range"));
                    
                    //System.out.println("id is"+idof);
           
            }
            ranges.add(mailtime);
            ranges.add(pwtime);
            ranges.add(press);
            ranges.add(type);
            ranges.add(release);
            
            System.out.println(ranges);
            compair comp = new compair();
            int count = 0;
            if(comp.comNum(mailtime.get(0),mailtime.get(1),mailt)){
                count++;
            }
            if(comp.comNum(pwtime.get(0),pwtime.get(1),pwt)){
                count++;
            }
            if(comp.comNum(press.get(0),press.get(1),presst)){
                count++;
            }
            if(comp.comNum(type.get(0),type.get(1),typet)){
                count++;
            }
            if(comp.comNum(release.get(0),release.get(1),releaset)){
                count++;
            }
            System.out.println((comp.comNum(mailtime.get(0),mailtime.get(1),mailt)));
            System.out.println(comp.comNum(pwtime.get(0),pwtime.get(1),pwt));
            System.out.println(comp.comNum(press.get(0),press.get(1),presst));
            System.out.println(comp.comNum(type.get(0),type.get(1),typet));
            System.out.println(comp.comNum(release.get(0),release.get(1),releaset));
            System.out.println(count);
            if(count>=3){
              wel.setVisible(true);
                
            }   
           }
                
           else{
               System.out.println("invalid password or username");
           }
            }
            else{
                System.out.println("invalid ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    public void insertIntoDBuser(String email,String pw) throws SQLException{
        
        try {
            String insertTableSQL = "INSERT INTO user"
		+ "(email,password) VALUES"
		+ "(?,?)";
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pw);
        
        // execute insert SQL stetement
        preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void insertIntoRanges(Double mailupper,Double maillower, Double pwupper, Double pwlower, Double pressedupper, Double pressedlower,
    Double typedupper, Double typedlower, Double releaseupper, Double releaselower,String email) throws SQLException{
        try {
            String id =getData(email).toString();
            String insertTableSQL = "INSERT INTO ranges"
		+ "(id,Mtime_upper_range,Mtime_lower_range,Ptime_upper_range,Ptime_lower_range,pressed_upper_range,pressed_lower_range,typed_upper_range,typed_lower_range,released_upper_range,	released_lower_range) VALUES"
		+ "(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2,mailupper.toString());
            preparedStatement.setString(3, maillower.toString());
            preparedStatement.setString(4,pwupper.toString());
            preparedStatement.setString(5, pwlower.toString());
            preparedStatement.setString(6,pressedupper.toString());
            preparedStatement.setString(7, pressedlower.toString());
            preparedStatement.setString(8,typedupper.toString());
            preparedStatement.setString(9, typedlower.toString());
            preparedStatement.setString(10,releaseupper.toString());
            preparedStatement.setString(11, releaselower.toString());
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    public void closeConnec() throws SQLException{
        con.close();
    }
    
    
    
    
    
}
