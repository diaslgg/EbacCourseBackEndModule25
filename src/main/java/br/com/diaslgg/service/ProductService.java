package br.com.diaslgg.service;

import br.com.diaslgg.dao.generic.IGenericDAO;
import br.com.diaslgg.domain.Product;
import br.com.diaslgg.exception.KeyNotFoundException;
import br.com.diaslgg.service.generic.GenericService;

public class ProductService extends GenericService<Product, String> implements IProductService {

    public ProductService(IGenericDAO<Product, String> dao) {
        super(dao);
    }

    @Override
    public void searchByCode(String Code) {

    }

    @Override
    public void change(Product product) throws KeyNotFoundException {

    }
}
