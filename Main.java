import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listeApprenants = getListeApprenants();

        // afficher la liste
        // System.out.println(listeApprenants);

        while (listeApprenants.size() > 1) {
            // retirer deux éléments
            //System.out.println(listeApprenants);
            String apprenant1 = listeApprenants.remove(0);
            //System.out.println(listeApprenants);
            String apprenant2 = listeApprenants.remove(0);
            //System.out.println(listeApprenants);
            String groupe = "Groupe" + " " + apprenant1 + " + " + apprenant2;
            System.out.println(groupe);
        }

        if (listeApprenants.size()%2 == 1) ;
        //System.out.println(listeApprenants);
        String apprenant3 = listeApprenants.remove(0);

        ArrayList Groupe = new ArrayList<>();

        {
            System.out.println("Groupe" + " " + apprenant3);
            System.out.println("Je remercie Alexandre et Stéphane pour leur aide !");

        }
    }


    private static ArrayList<String> getListeApprenants() {
        ArrayList<String> resultat = null;
        String user = "root";
        String pwd = "root";
        String driver = "com.myslq.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/binomontron";

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(url, user, pwd);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM apprenants;");

            // declarer une ArrayList<String>
            ArrayList<String> listeApprenants = new ArrayList<>();

            while (rs.next()) {
                System.out.print(rs.getString("prenom"));
                System.out.print(" ");
                System.out.print(rs.getString("nom"));
                System.out.print(" ");
                System.out.println(rs.getString("mail"));

                String nomComplet = rs.getString("prenom") + " " + rs.getString("nom");

                // ajouter element dans liste (nom+prenom)
                listeApprenants.add(nomComplet);

            }
            Collections.shuffle(listeApprenants);
            return listeApprenants;

        } catch (Exception e) {
            System.err.println("exception : " + e.getMessage());

        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
            }
        }
        return resultat;
    }
}
