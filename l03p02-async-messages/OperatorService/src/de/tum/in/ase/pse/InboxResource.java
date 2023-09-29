package de.tum.in.ase.pse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/messages/")
public class InboxResource {
    

    @PostMapping(value = "r2")
    public ResponseEntity<String> droidReadyR2(@RequestBody String droid) {
        InboxClient pepe = new InboxClient();
        pepe.droidReadyR2(droid);
        int messageSize = pepe.getMessages().size();
        return new ResponseEntity<>(pepe.getMessages().get(messageSize - 1), HttpStatus.OK);
    }

    @PostMapping(value = "3po")
    public ResponseEntity<String> droidReady3PO(@RequestBody String droid) {
        InboxClient pepe = new InboxClient();
        pepe.droidReady3PO(droid);
        int messageSize = pepe.getMessages().size();
        return new ResponseEntity<>(pepe.getMessages().get(messageSize - 1), HttpStatus.OK);
    }
}
