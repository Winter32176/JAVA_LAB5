package lv.tsi.webshop.resource;

import lv.tsi.webshop.models.Product;
import lv.tsi.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

@Resource
public class ProductResource {
    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
    return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductsById(@PathVariable Long id) {
        return productService.getProductsById(id);
    }


}
