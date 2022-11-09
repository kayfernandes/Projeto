//package trabalho.model.dao;
//
//import java.sql.*;
//import java.util.List;
//
//public abstract class AbstractDAO<T> {
//
//    // JDBC driver name and database URL
//    static final String JDBC_DRIVER = "org.h2.Driver";
//    static final String DB_URL = "jdbc:h2:file:~/terceiro-ano;AUTO_SERVER=true;DB_CLOSE_DELAY=-1";
//
//    //  Database credentials
//    static final String USER = "sa";
//    static final String PASS = "";
//
//    private Connection conn;
//    private Statement stmt;
//
//    public Connection connection() {
//        if (conn != null)
//            close();
//        try {
//            // STEP 1: Register JDBC driver
//            Class.forName(JDBC_DRIVER);
//            //STEP 2: Open a connection
//            return DriverManager.getConnection(DB_URL, USER, PASS);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public PreparedStatement preparedStatement(String sql) {
//        if (conn != null)
//            close();
//        try {
//            return connection().prepareStatement(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public abstract void createTable();
//    public abstract void insert(T entity) throws SQLException;
//    public abstract void delete(T entity);
//    public abstract void update(T entity);
//    public abstract T getById(T entity);
//    public abstract List<T> getAll();
//
//    public void close(){
//        try {
//            if (stmt != null && !stmt.isClosed())
//                stmt.close();
//            if (conn != null && !conn.isClosed())
//                conn.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//}
