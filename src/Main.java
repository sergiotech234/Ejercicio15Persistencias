import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "RIBERA";
        String password = "ribera";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT e.nombre, e.salario, d.nombre AS departamento " +
                    "FROM empleado3 e " +
                    "JOIN departamento2 d ON e.departamento_id = d.id";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");
                String departamento = rs.getString("departamento");

                System.out.println(nombre + " - " + salario + " - " + departamento);
            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}