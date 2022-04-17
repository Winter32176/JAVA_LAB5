package lv.tsi.webshop.service;

import lombok.RequiredArgsConstructor;
import lv.tsi.webshop.Repository.ProductRepository;
import lv.tsi.webshop.models.ErrorResponse;
import lv.tsi.webshop.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    public ResponseEntity getProductsById(Long id) {
        var employee = productRepository.findById(id);

        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(
                            ErrorResponse.builder()
                                    .errorCode("PRODUCT_NOT_FOUND")
                                    .errorMessage("Product does not exist with id:" + id)
                                    .referenceId(UUID.randomUUID().toString())
                                    .build()
                    );
        }
    }
}
