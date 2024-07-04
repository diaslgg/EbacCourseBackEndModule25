package br.com.diaslgg.service;

import br.com.diaslgg.dao.ProductDAO;
import br.com.diaslgg.domain.Product;
import br.com.diaslgg.exception.KeyNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductDAO productDAO;

    @Mock
    private Product product;

    private IProductService iProductService;

    @BeforeEach
    void setUp() {
        iProductService = new ProductService(productDAO);
    }

    @Test
    void signUpSucessTest() throws KeyNotFoundException {
        when(productDAO.signUp(product)).thenReturn(true);

        Boolean signUpTest = this.iProductService.signUp(product);

        assertTrue(signUpTest);
    }

    @Test
    void excludeVerifyCallTest() {
        this.iProductService.exclude(product.getCode());
        verify(productDAO).exclude(product.getCode());
    }

    @Test
    void editVerifyCallTest() throws KeyNotFoundException {
        this.iProductService.edit(product);
        verify(productDAO).edit(product);
    }

    @Test
    void checkSucessTest() {
        when(productDAO.check(product.getCode())).thenReturn(product);

        Product productReturnedTest = iProductService.check(product.getCode());

        assertInstanceOf(product.getClass(), productReturnedTest);
    }

    @Test
    void searchAllSucessTest() {
        when(productDAO.searchAll()).thenReturn(List.of(product));

        Collection<Product> listReturnedTest = iProductService.searchAll();

        assertEquals(List.of(product), listReturnedTest);
    }

}
