package de.tum.in.ase.pse;

import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;



@RestController
@RequestMapping(value = "/droid/", consumes = "application/json")
public class DroidFactoryResource {

    private final DroidFactory factory = new DroidFactory();

    @PostMapping("r2")
    public CompletableFuture<String> produceR2Async(@RequestBody Droids droid) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete(factory.produce(droid).getName());
        return completableFuture;
    }

    @PostMapping("3po")
    public CompletableFuture<String> produce3POAsync(@RequestBody Droids droid) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete(factory.produce(droid).getName());
        return completableFuture;    
    }

}
