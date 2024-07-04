package br.com.diaslgg.dao;

import br.com.diaslgg.dao.generic.GenericDAO;
import br.com.diaslgg.domain.Product;

public class ProductDAO  extends GenericDAO<Product, String> implements IProductDAO {

    public ProductDAO () {
        super();
    }

    @Override
    public Class<Product> getClassType() {
        return Product.class;
    }

    @Override
    public void updateData(Product entity, Product entityCreated) {
        entityCreated.setCode(entity.getCode());
        entityCreated.setDescription(entity.getDescription());
        entityCreated.setName(entity.getName());
        entityCreated.setPrice(entity.getPrice());

    }
}
