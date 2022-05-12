package sk.stuba.fei.uim.oop.assignment3.autor.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findAutorById(Long id);
}
