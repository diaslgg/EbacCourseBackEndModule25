package br.com.diaslgg.service;

import br.com.diaslgg.dao.ClientDAO;
import br.com.diaslgg.domain.Client;
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
public class ClientServiceTest {
    @Mock
    private ClientDAO clientDAO;

    @Mock
    private Client client;

    private IClientService iClientService;

    @BeforeEach
    void setUp() {
        iClientService = new ClientService(clientDAO);
    }

    @Test
    void signUpSucessTest() throws KeyNotFoundException {
        when(clientDAO.signUp(client)).thenReturn(true);

        Boolean signUpTest = this.iClientService.signUp(client);

        assertTrue(signUpTest);
    }

    @Test
    void excludeVerifyCallTest() {
        this.iClientService.exclude(client.getCpf());
        verify(clientDAO).exclude(client.getCpf());
    }

    @Test
    void changeVerifyCallTest() throws KeyNotFoundException {
        this.iClientService.change(client);
        verify(clientDAO).edit(client);
    }

    @Test
    void searchByCpfSucessTest() {
        when(clientDAO.check(client.getCpf())).thenReturn(client);

        Client clientReturnedTest = iClientService.searchByCpf(client.getCpf());

        assertInstanceOf(client.getClass(), clientReturnedTest);
    }

    @Test
    void searchAllSucessTest() {
        when(clientDAO.searchAll()).thenReturn(List.of(client));

        Collection<Client> listReturnedTest = iClientService.searchAll();

        assertEquals(List.of(client), listReturnedTest);
    }

}
