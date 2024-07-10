package com.rocketseat.planner.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantRepository repository;

    @PostMapping("/{id}/confrim")
    public ResponseEntity<Participant> confirmParticipant(@PathVariable UUID id,
                                                          @RequestBody ParticipantRequestPayload payload) {
        Optional<Participant> particiant = this.repository.findById(id);

        if (particiant.isPresent()) {
            Participant rawParticipant = particiant.get();
            rawParticipant.setIsConfirmed(true);
            rawParticipant.setName(payload.name());

            this.repository.save(rawParticipant);

            return ResponseEntity.ok(rawParticipant);
        }

        return ResponseEntity.notFound().build();
    }
}