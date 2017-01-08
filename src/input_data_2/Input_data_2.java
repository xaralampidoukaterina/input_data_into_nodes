/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input_data_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Katerina
 */
public class Input_data_2 {

    private static final String USERNAME= "root";
    private static final String PASSWORD= "";
    private static final String CONN_STRING= "jdbc:mysql://localhost:3306/DataBase";


    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {
        // TODO code application logic here
        Connection conn =null;
         //read from the file
        String  filename ="bsn_alldata.csv";
        File file = new File(filename);
        try{
            int i=10;
            conn = (Connection)DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            try (Scanner inputStream = new Scanner(file)) {
                while(inputStream.hasNext()){
                    String data =inputStream.next(); //gets a whole line
                    String[] values =data.split(",");
                    /*mobile device*/
                    String mobile_device = "android_1";
                    /*sensor_id*/
                    Integer sens_id = Integer.parseInt(values[7]);
                    Integer sensor_id = sens_id;
                    /*Status*/
                    String status ="ON";
                    /*channel_id*/
                    String acc_x= "acc_x";
                    String acc_y = "acc_y";
                    String acc_z= "acc_z";
                    String gyro_x = "gyro_x";
                    String gyro_y = "gyro_y";
                    String gyro_z = "gyro_z";
                    String mag_x = "mag_x";
                    String mag_y = "mag_y";
                    String mag_z= "mag_z";
                    
                    /*Sql nodes*/
                    PreparedStatement post0 = conn.prepareStatement("INSERT INTO nodes(mobile_device,status,address_id,channel_1,channel_2,channel_3,channel_4,channel_5,channel_6,channel_7,channel_8,channel_9)VALUES('"+mobile_device+"','"+status+"','"+sensor_id+"','"+acc_x+"','"+acc_y+"','"+acc_z+"','"+gyro_x+"','"+gyro_y+"','"+gyro_z+"','"+mag_x+"','"+mag_y+"','"+mag_z+"')");
                    post0.executeUpdate();
                    
              
                }
                System.out.println("Connected");
            }
           
        }catch(SQLException e){
            System.err.println(e);
        }
        
    }
    
}



    

