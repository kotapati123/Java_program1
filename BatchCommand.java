
// Step 1: Create a database
// SQL database imported

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;
 

public class BatchCommand {
 

    // Main driver method

    public static void main(String args[])

    {
 

        // Try block to check if exception occurs

        try {
 

            // Step 2: Loading driver class

            // Using forName()

            Class.forName("com.mysql.jdbc.Driver");
 

            // Step 3: Create connection object

            Connection con = DriverManager.getConnection(

                "jdbc:mysql://localhost:3306/assignment","root","");

            Statement s = con.createStatement();

			 // Print commands

            System.out.println(

                "Product ID\tDepot ID\t\tQuantiy");

            System.out.println(

                "-------------------------------------------------------");
 

            // Condition to check pointer pointing

            while (rs.next()) {

                System.out.println(rs.getString(1) + "\t\t"

                                   + rs.getString(2)

                                   + "\t\t"

                                   + rs.getString(3));

            }
 
            String sql1

                = "DELETE FROM `product` WHERE prodid='1'";
 
		//The above query deletes the prodid 1 from product and stock table.
 
            String sql2

                = "DELETE FROM `depot ` WHERE depid='1'";

//The above query deletes the depid 1 from depot and stock table.
            String sql3

                = "UPDATE `product` SET `prodid` = pp1 WHERE prodid = ‘p1’";
//The above query updates the prodid from p1 to pp1 on product and stock table.

            String sql4

                = "UPDATE `depot ` SET `depid` = dd1 WHERE depid = ‘d1’";
//The above query updates the depid from d1 to dd1 on depot and stock table.

            String sql5

                = "INSERT INTO `product ` (`prodid`, `pname `, `price `) VALUES ('p100', ‘cd’, '5')";

            String sql6

                = "INSERT INTO `stock` (`prodid`, `depid`, `quantity`) VALUES ('p100', ‘d2’,’50’)";

//The above queries Inserts the (P100,cd,5) in product table and (p100,d2,50) in stock table.
	   String sql7

                = "INSERT INTO `depot` (`depid`, `addr`, `volume`) VALUES ('d100', 'Chicago', '100')";

            String sql8

                = "INSERT INTO `stock` (`prodid`, `depid`, `quantity`) VALUES ('p1', ‘d100’,’100’)";
//The above queries inserts (d100, Chicago, 100) in depot table and (p1,d100,100) in stock table.

            s.addBatch(sql1);

            s.addBatch(sql2);

            s.addBatch(sql3);

            s.addBatch(sql4);

            s.addBatch(sql5);

            s.addBatch(sql6);
			
		    s.addBatch(sql7);
			
            s.addBatch(sql8);
 

            // Step 6: Process the results

            // execute the sql statements

            s.executeBatch();

            ResultSet rs

                = s.executeQuery("Select prodid,depid,quantity from stock");
 

            // Print commands

            System.out.println(

                "Product ID\tDepot ID\t\tQuantiy");

            System.out.println(

                "-------------------------------------------------------");
 

            // Condition to check pointer pointing

            while (rs.next()) {

                System.out.println(rs.getString(1) + "\t\t"

                                   + rs.getString(2)

                                   + "\t\t"

                                   + rs.getString(3));

            }
 

            // Step 7: Close the connection

            con.commit();

            con.close();

        }
 

        // Catch block to handle exceptions

        catch (Exception e) {
 

            // Print line number if exception occured

            System.out.println(e);

        }

    }
}