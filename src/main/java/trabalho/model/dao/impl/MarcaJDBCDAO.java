package br.edu.ifg.luziania.tiii.model.dao.impl;

import br.edu.ifg.luziania.tiii.model.dao.AbstractDAO;
import br.edu.ifg.luziania.tiii.model.entity.Marca;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class MarcaJDBCDAO extends AbstractDAO<Marca> {

    public void save(Marca entity) {
        insert(entity);
    }

    public List<Marca> searchByNome(String nome){
        List<Marca> marcas = new ArrayList<>();
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM TBMARCA WHERE NOME LIKE ?");
            ps.setString(1, "%"+nome+"%");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                marcas.add(fromResultSet(resultSet));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return marcas;
    }

    public Marca getByNome(String nome){
        Marca marca = null;
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM TBMARCA WHERE NOME = ?");
            ps.setString(1, nome);
            marca = fromResultSet(ps.getResultSet());
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return marca;
    }

    private Marca fromResultSet(ResultSet resultSet){
        try {
            return new Marca(resultSet.getInt("id"),
                    resultSet.getString("nome"));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @PostConstruct
    public void createTable() {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("CREATE TABLE IF NOT EXISTS TBMARCA ")
                .append(" (id INTEGER auto_increment,")
                .append(" nome VARCHAR(255), ")
                .append(" PRIMARY KEY (id)); ");
        try {
            connection().prepareStatement(sql.toString()).executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void insert(Marca entity) {
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("INSERT INTO TBMARCA (nome) VALUES (?);");
            ps.setString(1, entity.getNome());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void delete(Marca entity) {
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("DELETE FROM TBMARCA WHERE id = ?;");
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void update(Marca entity) {
        StringBuilder sql = new StringBuilder();
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("UPDATE TBMARCA SET nome = ? WHERE id = ?;");
            ps.setString(1, entity.getNome());
            ps.setInt(2, entity.getId());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public Marca getById(Marca entity) {
        Marca marca = null;
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM TBMARCA WHERE id = ?");
            ps.setInt(1, entity.getId());
            marca = fromResultSet(ps.getResultSet());
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return marca;
    }

    @Override
    public List<Marca> getAll() {
        List<Marca> marcas = new ArrayList<>();
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM TBMARCA");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                marcas.add(fromResultSet(resultSet));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return marcas;
    }
}
