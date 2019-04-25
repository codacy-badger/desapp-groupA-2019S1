package ar.edu.unq.desapp.grupoa.service;

import ar.edu.unq.desapp.grupoa.model.Fiesta;
import ar.edu.unq.desapp.grupoa.model.Guest;
import ar.edu.unq.desapp.grupoa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.apache.commons.collections.ListUtils.EMPTY_LIST;

@Service
public class BootstrapService {

    @Autowired
    private FiestaService fiestaService;

    BootstrapService(){
    }

    public void createExampleData() {
        this.fiestaService.createAll(Arrays.asList(pepeLocoFiesta(),ivanFiesta()));
    }

    private Fiesta ivanFiesta() {
        return new Fiesta(
                        new User("Ivan"),
                        Arrays.asList(
                                    new Guest(new User("Victor")),
                                    new Guest(new User("Pepe El Loco")),
                                    new Guest(new User("Ivan"))),
                        LocalDateTime.now(),
                        EMPTY_LIST);
    }

    private Fiesta pepeLocoFiesta() {
        return new Fiesta(
                new User("Pepe Loco"),
                Arrays.asList(
                        new Guest(new User("Ivan")),
                        new Guest(new User("Ivan"))),
                LocalDateTime.now(),
                EMPTY_LIST);
    }
}
