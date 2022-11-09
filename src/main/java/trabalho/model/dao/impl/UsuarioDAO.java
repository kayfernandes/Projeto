//package trabalho.model.dao.impl;
//
//import trabalho.model.dao.AbstractDAO;
//import trabalho.model.entity.Usuario;
//import javax.annotation.PostConstruct;
//import javax.enterprise.context.Dependent;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//@Dependent
//public abstract class UsuarioDAO extends AbstractDAO<Usuario> {
//
//    private Usuario fromResultSet(ResultSet resultSet){
//        try {
//            return new Usuario(resultSet.getString("nome"),
//                    resultSet.getString("telefone"));
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    @PostConstruct
//    public void createTable() {
//        StringBuilder sql = new StringBuilder();
//        // language=SQL
//        sql.append("CREATE TABLE IF NOT EXISTS PESSOA ")
//                .append(" (id INTEGER auto_increment,")
//                .append(" nome VARCHAR(255), ")
//                .append(" telefone VARCHAR(20), ")
//                .append(" PRIMARY KEY (id)); ");
//        try {
//            connection().prepareStatement(sql.toString()).executeUpdate();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        close();
//    }
//
//    @Override
//    public void insert(Usuario entity) {
//        try {
//            // language=SQL
//            PreparedStatement ps = preparedStatement("INSERT INTO PESSOA (nome, telefone) VALUES (?, ?);");
//            ps.setString(1, entity.getNome());
//            ps.setString(2, entity.getEmail());
//            ps.executeUpdate();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        close();
//    }
//
//    @Override
//    public void update(Usuario entity) {
//        StringBuilder sql = new StringBuilder();
//        // language=SQL
//        sql.append("UPDATE PESSOA SET ")
//                .append("nome = '"+entity.getNome()+"', ")
//                .append("telefone = '"+entity.getEmail()+"',")
//        try {
//            // language=SQL
//            PreparedStatement ps = preparedStatement("UPDATE PESSOA SET nome = ?, telefone = ?;");
//            ps.setString(1, entity.getNome());
//            ps.setString(2, entity.getEmail());
//            ps.executeUpdate();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        close();
//    }
//
//    @Override
//    public void delete(Usuario entity) {
//        try {
//            // language=SQL
//            PreparedStatement ps = preparedStatement("DELETE FROM PESSOA WHERE id = ?;");
//            ps.executeUpdate();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        close();
//    }
//
//    @Override
//    public Usuario getById(Usuario entity) {
//        Usuario usuario = null;
//        try {
//            // language=SQL
//            PreparedStatement ps = preparedStatement("SELECT * FROM PESSOA WHERE id = ?");
//            usuario = fromResultSet(ps.getResultSet());
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        close();
////        return new usuario();
//        return usuario;
//    }
//
//    @Override
//    public List<Usuario> getAll() {
//        List<Usuario> usuarios = new ArrayList<>();
//        try {
//            // language=SQL
//            PreparedStatement ps = preparedStatement("SELECT * FROM PESSOA");
//            ResultSet resultSet = ps.executeQuery();
//            while(resultSet.next()){
//                usuarios.add(fromResultSet(resultSet));
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        close();
//        return usuarios;
//    }
//
//}