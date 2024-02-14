package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createProductPage() {
        String viewName = productController.createProductPage(model);
        assertEquals("createProduct", viewName);
    }

    @Test
    void createProductPost() {
        Product product = new Product();
        String viewName = productController.createProductPost(product, model);
        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).create(product);
    }

    @Test
    void productListPage() {
        List<Product> productList = new ArrayList<>();
        when(productService.findAll()).thenReturn(productList);

        String viewName = productController.productListPage(model);

        assertEquals("productList", viewName);
        verify(model, times(1)).addAttribute("products", productList);
    }

    @Test
    void deleteProduct() {
        String productId = "1";

        String viewName = productController.deleteProduct(productId, model);

        assertEquals("redirect:../list", viewName);
        verify(productService, times(1)).delete(productId);
    }

    @Test
    void editProductPage() {
        String productId = "1";
        Product product = new Product();
        when(productService.find(productId)).thenReturn(product);

        String viewName = productController.editProductPage(productId, model);

        assertEquals("editProduct", viewName);
        verify(model, times(1)).addAttribute("product", product);
    }

    @Test
    void editProductPost() {
        Product product = new Product();

        String viewName = productController.editProductPost(product, model);

        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).edit(product);
    }
}
