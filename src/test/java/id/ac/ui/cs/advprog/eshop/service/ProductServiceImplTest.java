package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAll() {
        List<Product> productList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList.iterator());

        List<Product> retrievedProducts = productService.findAll();

        assertEquals(productList, retrievedProducts);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFind() {
        String productId = "1";
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(product);

        Product retrievedProduct = productService.find(productId);

        assertEquals(product, retrievedProduct);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testEdit() {
        Product product = new Product();
        when(productRepository.edit(product)).thenReturn(product);

        Product editedProduct = productService.edit(product);

        assertEquals(product, editedProduct);
        verify(productRepository, times(1)).edit(product);
    }

    @Test
    void testDelete() {
        String productId = "1";
        Product product = new Product();
        when(productRepository.deleteById(productId)).thenReturn(product);

        Product deletedProduct = productService.delete(productId);

        assertEquals(product, deletedProduct);
        verify(productRepository, times(1)).deleteById(productId);
    }
}
