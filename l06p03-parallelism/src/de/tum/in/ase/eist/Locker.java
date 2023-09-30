package de.tum.in.ase.eist;

import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import static de.tum.in.ase.eist.ThreadUtils.takeSomeTime;

public class Locker {
    private static int counter = 0;
    private final int id;
    private Optional<Swimmer> occupant;
    private final ReentrantLock mutex;

    public Locker() {
        this.id = counter++;
        this.occupant = Optional.empty();
        this.mutex = new ReentrantLock();
    }

    public void storeClothes(Swimmer newOccupant) {
        occupant = Optional.of(newOccupant);
        mutex.lock();
        takeSomeTime(); // take some time to store clothes in locker
        System.out.printf("Swimmer %d has stored their clothes in locker %d\n", newOccupant.getId(), this.id);
    }

    public void retrieveClothes() {
        System.out.printf("Swimmer %d has retrieved their clothes from locker %d\n", this.occupant.get().getId(),
                this.id);
        mutex.unlock();
        occupant = Optional.empty();
    }

    public Optional<Swimmer> getOccupant() {
        return occupant;
    }

    public ReentrantLock getMutex() {
        return mutex;
    }
}
