package ro.uvt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.entity.RestockRecord;

public interface RestockRecordRepository extends JpaRepository<RestockRecord, Long> {
}
