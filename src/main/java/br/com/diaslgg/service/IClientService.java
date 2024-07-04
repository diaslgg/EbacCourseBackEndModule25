package br.com.diaslgg.service;

import br.com.diaslgg.domain.Client;
import br.com.diaslgg.exception.KeyNotFoundException;

import java.util.Collection;

public interface IClientService {

    Boolean signUp(Client client) throws KeyNotFoundException;

    Client searchByCpf(Long cpf);

    void exclude(Long cpf);

    void change(Client client) throws KeyNotFoundException;

    Collection<Client> searchAll();
}
