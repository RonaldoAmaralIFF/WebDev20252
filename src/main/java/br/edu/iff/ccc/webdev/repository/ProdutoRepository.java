package br.edu.iff.ccc.webdev.repository;

import br.edu.iff.ccc.webdev.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Produto findByNome(String nome);

    List<Produto> findByQuantidadeEstoque(int quantidadeEstoque);

    @Query("SELECT p FROM Produto p WHERE p.preco > ?1")
    List<Produto> findByPrecoGreaterThan(double preco);

}
