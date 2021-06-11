package ru.burlutskiysergey.server.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.burlutskiysergey.common.dto.ClientDTO;
import ru.burlutskiysergey.server.service.ClientService;

@RestController
@AllArgsConstructor
@Log
public class ClientRestController {
    private ClientService clientService;

    @GetMapping("/clients/{clientId}")
    public ClientDTO getClient(
            @PathVariable("clientId") Long clientId
    ) {
        log.info("Запрос clientId: " + clientId);

        return clientService.getClient(clientId);
    }

}
