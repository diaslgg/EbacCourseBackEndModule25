package br.com.diaslgg.dao;

import br.com.diaslgg.dao.generic.GenericDAO;
import br.com.diaslgg.domain.Client;

public class ClientDAO  extends GenericDAO<Client, Long> implements IClientDAO {

    public ClientDAO() {
        super();
    }

    @Override
    public Class<Client> getClassType() {
        return Client.class;
    }

    @Override
    public void updateData(Client entity, Client entityCreated) {
        entityCreated.setCity(entity.getCity());
        entityCreated.setCpf(entity.getCpf());
        entityCreated.setAddress(entity.getAddress());
        entityCreated.setCountryState(entity.getCountryState());
        entityCreated.setName(entity.getName());
        entityCreated.setPhone(entity.getPhone());
        entityCreated.setNumber(entity.getNumber());

    }
}
