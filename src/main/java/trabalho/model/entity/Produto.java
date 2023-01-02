package br.edu.ifg.luziania.tiii.model.entity;


import br.edu.ifg.luziania.tiii.model.dto.ProdutoDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbproduto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Produto(){
    }

    public Produto(ProdutoDTO dto){
        this(dto.getId(), dto.getNome(), "");
    }

    public Produto(Integer id, String nome, Marca marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    public Produto(Integer id, String nome, String marca) {
        this.id = id;
        this.nome = nome;
        this.marca = new Marca();
        this.marca.setNome(marca);
    }
}
