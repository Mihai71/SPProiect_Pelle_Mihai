package ro.uvt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // nimic aici deocamdata
}
