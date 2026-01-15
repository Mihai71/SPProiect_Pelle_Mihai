package ro.uvt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
