package br.com.diaslgg.service;

import br.com.diaslgg.domain.Client;
import br.com.diaslgg.domain.Product;
import br.com.diaslgg.exception.KeyNotFoundException;
import br.com.diaslgg.service.generic.IGenericService;

public interface IProductService extends IGenericService<Product, String> {

    Boolean signUp(Product product) throws KeyNotFoundException;

    void searchByCode(String code);

    void change(Product product) throws KeyNotFoundException;

    void exclude(String code);
}
