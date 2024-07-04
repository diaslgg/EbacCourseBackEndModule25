package br.com.diaslgg.service;

import br.com.diaslgg.dao.generic.IGenericDAO;
import br.com.diaslgg.domain.Client;
import br.com.diaslgg.exception.KeyNotFoundException;
import br.com.diaslgg.service.generic.GenericService;

public class ClientService extends GenericService<Client, Long> implements IClientService {

    public ClientService(IGenericDAO<Client, Long> dao) {
        super(dao);
    }

    @Override
    public Client searchByCpf(Long cpf) {
        return this.dao.check(cpf);
    }

    @Override
    public void change(Client client) throws KeyNotFoundException {
        this.dao.edit(client);

    }

}
