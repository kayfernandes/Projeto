package br.edu.ifg.luziania.tiii.model.bo;

import br.edu.ifg.luziania.tiii.model.dao.impl.MarcaDAO;
import br.edu.ifg.luziania.tiii.model.dao.impl.MarcaJDBCDAO;
import br.edu.ifg.luziania.tiii.model.dao.impl.ProdutoDAO;
import br.edu.ifg.luziania.tiii.model.dto.ProdutoDTO;
import br.edu.ifg.luziania.tiii.model.entity.Marca;
import br.edu.ifg.luziania.tiii.model.entity.Produto;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Dependent
public class ProdutoBO {

    @Inject
    ProdutoDAO produtoDAO;

    @Inject
    MarcaDAO marcaDAO;

    @Inject
    MarcaJDBCDAO marcaJDBCDAO;

    @Transactional
    public void save(ProdutoDTO dto){
        Produto produto = new Produto(dto);
        produto.setMarca(marcaDAO.getByNome(dto.getMarca()));
        produtoDAO.save(produto);
        System.out.println(produto.getId());
    }

    @Transactional
    public void saveMarca(String nomeDamarca){
        Marca marca = new Marca();
        marca.setNome(nomeDamarca);
        marcaDAO.save(marca);
        System.out.println(marca.getId());
    }

    public void saveMarcaWithJDBC(String nomeDamarca){
        Marca marca = new Marca();
        marca.setNome(nomeDamarca);
        marcaJDBCDAO.save(marca);
        System.out.println(marca.getId());
    }

    public List<Marca> searchMarcasWithJDBC(String marca) {
        return marcaJDBCDAO.searchByNome(marca);
    }
}
