package ro.uvt.controller;

import org.springframework.web.bind.annotation.*;
import ro.uvt.entity.*;
import ro.uvt.repository.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/restocks")
public class RestockController {

    private final RestockRecordRepository restockRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public RestockController(RestockRecordRepository restockRepository,
                             ProductRepository productRepository,
                             SupplierRepository supplierRepository) {
        this.restockRepository = restockRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @PostMapping
    public RestockRecord addRestock(@RequestParam Long productId,
                                    @RequestParam Long supplierId,
                                    @RequestParam int quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // marim stocul
        product.setStock(product.getStock() + quantity);
        productRepository.save(product);

        // salvam inregistrarea
        RestockRecord record = new RestockRecord();
        record.setProduct(product);
        record.setSupplier(supplier);
        record.setQuantity(quantity);
        record.setDate(LocalDate.now());

        return restockRepository.save(record);
    }
}
