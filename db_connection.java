import java.sql.*;
import java.util.*;

public class db_connection {
      private static Connection connection = null;
      private static Scanner sc = new Scanner(System.in);
      String name;

      public static void main(String[] args) {
            db_connection insertdata = new db_connection();

            

            try {
                  // Class.forName(com.mysql.cj.jdbc.Driver);
                  connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "rushi5091");

                  System.out.println("Enter your choice :");
                  System.out.println("1.insert record");
                  System.out.println("2.serach record ");
                  System.out.println("3.delete record ");
                  System.out.println("4.delete record ");
                  int choice = sc.nextInt();
                  switch (choice) {
                        case 1:
                              insertdata.insertrecord();
                              break;
                        case 2:
                              insertdata.selectrecord();
                              break;
                        case 3:
                              insertdata.updaterecord();
                              break;
                              case 4:
                              insertdata.deleterecord();
                              break;
                  }

            } catch (Exception e) {
                  System.out.println(e);
            }
      }

      private void insertrecord() throws SQLException {
            System.out.println("insert insersion");
            String sql = "insert into studentdata1 (s_name,s_addr,s_city,s_state,s_fname)values(?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            System.out.println("enter name:");
            pst.setString(1, sc.next());
            System.out.println("enter the address :");
            pst.setString(2, sc.next());
            System.out.println("enter city :");
            pst.setString(3, sc.next());
            System.out.println("enter the state :");
            pst.setString(4, sc.next());
            System.out.println("enter the Father name :");
            pst.setString(5, sc.next());
            int row = pst.executeUpdate();

            if (row > 0) {
                  System.out.println("record inserted successfully");
            }
      }

      public void selectrecord() throws SQLException {
            System.out.println("enter the name to serch record :");
            String name = sc.next();

            String sql = "select * from studentdata1 where s_name= ''" + name;

            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                  String Name = result.getString("s_name");
                  String Address = result.getString("s_addr");
                  String City = result.getString("s_city");
                  String State = result.getString("s_state");
                  String Fname = result.getString("s_fname");

                  System.out.println("name is :" + Name);
                  System.out.println("address is :" + Address);
                  System.out.println("City :" + City);
                  System.out.println("state :" + State);
                  System.out.println("Father name :" + Fname);

            }
      }

      public void updaterecord() throws SQLException {
            // System.out.println("enter the name to update record :");
            // name=sc.next();
            String sql = "select * from studentdata1 where s_name='rushi'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(sql);

            if (result.next()) {

                  String Name = result.getString("s_name");
                  String address = result.getString("s_addr");

                  String city = result.getString("s_city");

                  String state = result.getString("s_state");

                  String fathername = result.getString("s_fname");

                  System.out.println("Name :" + Name);
                  System.out.println("Address :" + address);
                  System.out.println("City is :" + city);
                  System.out.println("state is :" + state);
                  System.out.println("Father name :" + fathername);

                  System.out.println("what do you want to update it ?");
                  System.out.println("1.name");
                  System.out.println("2.address");
                  System.out.println("3.city");
                  System.out.println("4.state");
                  System.out.println("5.fname");

                  int choice = sc.nextInt();
                  String sqlq = "update studentdata1 set";
                  switch (choice) {
                        case 1:
                              sqlq = sqlq + "s_name='anna' where s_addr='shingave'";
                              PreparedStatement pt = connection.prepareStatement(sqlq);
                              int row = pt.executeUpdate();
                              if (row > 0) {
                                    System.out.println("name is update");
                              }
                              break;
                        case 2:
                        sqlq = sqlq + "s_addr='nagpur' where s_name='rushi'";
                        PreparedStatement pt1 = connection.prepareStatement(sqlq);
                        int row1 = pt1.executeUpdate();
                        if (row1 > 0) {
                              System.out.println("address is update");
                        }
                              break;
                        case 3:
                        sqlq = sqlq + "s_city='nagpur' where s_name='rushi'";
                        PreparedStatement pt2 = connection.prepareStatement(sqlq);
                        int row2 = pt2.executeUpdate();
                        if (row2 > 0) {
                              System.out.println("city is update");
                        }
                              break;
                        case 4:
                        sqlq = sqlq + "s_state='deli' where s_name='rushi'";
                              PreparedStatement pt3 = connection.prepareStatement(sqlq);
                              int row3 = pt3.executeUpdate();
                              if (row3> 0) {
                                    System.out.println("state is update");
                              }
                              break;
                        case 5:
                        sqlq = sqlq + "s_fname='rakesh' where s_name='rushi'";
                        PreparedStatement pt4 = connection.prepareStatement(sqlq);
                        int row4 = pt4.executeUpdate();
                        if (row4 > 0) {
                              System.out.println("name is update");
                        }
                              break;
                        default:
                              break;
                  }
            } else {
                  System.out.println("Record not Found");
            }
      }
      public void deleterecord() throws SQLException
      {
            String sql="delete  from studentdata1 where s_name='rushi'";

            Statement st=connection.createStatement();
            st.executeUpdate(sql);
            int row=st.executeUpdate(sql);
            if(row >0)
            {
                  System.out.println("record deleted");
            }

      }
}
