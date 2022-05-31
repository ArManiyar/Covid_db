import java.sql.*;
import java.util.Scanner;
import java.lang.String;

class Covid_db {
    private static String url = "jdbc:mysql://localhost:3306/covid_19";
    private static String user_name = "root";
    private static String password = "Master@01480";
    // inserting values by passing in prepared statement

    // pattern matching to insert into specifc coloun by index value
    static String sql_query_covid_db = "Insert Into covid values(?,?,?,?,?,?,?,?,?,?,?)";
    static String sql_query_contacts_db = "Insert Into covid values(?,?,?,?)";

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user_name, password);
            // Statement sta = conn.createStatement();
            // ResultSet rs = sta.executeQuery(sql);
            PreparedStatement ps_for_covid_db = conn.prepareStatement(sql_query_covid_db);
            PreparedStatement ps_for_contacts_db = conn.prepareStatement(sql_query_contacts_db);
            /*
             * pt_id | int | YES | | NULL | |
             * | pt_name | varchar(25) | YES | | NULL | |
             * | pt_hosname | varchar(30) | YES | | NULL | |
             * | pt_age | int | YES | | NULL | |
             * | pt_bg | varchar(5) | YES | | NULL | |
             * | pt_gender | varchar(7) | YES | | NULL | |
             * | pt_adhar_number | int | YES | | NULL | |
             * | pt_admitdate | varchar(15) | YES | | NULL | |
             * | pt_dise_date | varchar(15) | YES | | NULL | |
             * | pt_report | varchar(25) | YES | | NULL | |
             * | pt_addr | varchar(30) | YES | | NULL | |
             */
            do {
            System.out.println("Enter the covid patient detail");
            // inputs to db
            System.out.println("Enter the covid patient ID: ");
            int id = input.nextInt(); // id pat
            ps_for_covid_db.setInt(1, id);

            System.out.println("Enter the covid patient Name: ");
            String name = input.next(); // pat name
            ps_for_covid_db.setString(2, name);

            System.out.println("Enter the name of Hospital");
            String hos_name = input.next(); // Hospital Name
            ps_for_covid_db.setString(3, hos_name);

            System.out.println("Enter the covid patient age: ");
            int age = input.nextInt(); // age pat
            ps_for_covid_db.setInt(4, age);

            System.out.println("Enter the Blood group of the patient");
            String bg_name = input.next(); // bg of patient
            ps_for_covid_db.setString(5, bg_name);

            System.out.println("Enter the covid patient gender: ");
            String gender = input.next(); // gener pat
            ps_for_covid_db.setString(6, gender);

            System.out.println("Enter the covid patient adhar card number: ");
            int adhar_card = input.nextInt(); // adhar pat
            ps_for_covid_db.setInt(7, adhar_card);

            System.out.println("Enter the covid patient admit date in format (DD/MM/YYYY): ");
            String admit_date = input.next(); // admit date
            ps_for_covid_db.setString(8, admit_date);

            System.out.println("Enter the covid patient discharge date in format (DD/MM/YYYY): ");
            String dis_date = input.next(); // discharge pat
            ps_for_covid_db.setString(9, dis_date);

            System.out.println("Report of the  Patient is: ");
            String report = input.next(); // report of pat
            ps_for_covid_db.setString(10, report);

            System.out.println("Enter the covid patient address: ");
            String addr = input.next(); // addr of pat
            ps_for_covid_db.setString(11, addr);
            /*
             * | Field | Type | Null | Key | Default | Extra |
             * +-------------------+-------------+------+-----+---------+-------+
             * | pt_id | int | YES | MUL | NULL | |
             * | Primary_Contact | varchar(20) | YES | | NULL | |
             * | Secondary_Contact | varchar(20) | YES | | NULL | |
             * | Tertiary_Contact | varchar(20) | YES | | NULL | |
             * +-------------------+-------------+------+-----+---------+-------+
             */
            System.out.println("Enter the list of persons who came in contact with patient");

            System.out.println("Enter the Id of the Patient");
            int pt_id_con = input.nextInt();
            ps_for_contacts_db.setInt(1, pt_id_con);

            System.out.println("Enter the primary contact: ");
            String pri_con = input.next();
            ps_for_contacts_db.setString(2, pri_con);

            System.out.println("Enter the Secondary contact: ");
            String sec_con = input.next();
            ps_for_contacts_db.setString(3, sec_con);

            System.out.println("Enter the Tertiary Contact: ");
            String ter_con = input.next();
            ps_for_contacts_db.setString(4, ter_con);

            System.out.println("DO you wish to continue: (Y- for yes/ N- for no)");
            String ch = input.next();
            if (ch.startsWith("N") || ch.startsWith("n")) {
                break;
            }
         
        } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        input.close();
    }
}