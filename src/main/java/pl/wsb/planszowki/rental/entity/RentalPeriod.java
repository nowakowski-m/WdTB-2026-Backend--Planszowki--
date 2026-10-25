package pl.wsb.planszowki.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

/**
 * Okres wypożyczenia od–do (wbudowany w {@link GameRental}).
 */
@Embeddable
public class RentalPeriod {

    @Column(name = "rented_at", nullable = false)
    private LocalDateTime rentedAt;

    @Column(name = "due_at", nullable = false)
    private LocalDateTime dueAt;

    protected RentalPeriod() {
    }

    public RentalPeriod(LocalDateTime rentedAt, LocalDateTime dueAt) {
        this.rentedAt = rentedAt;
        this.dueAt = dueAt;
    }

    public LocalDateTime getRentedAt() { return rentedAt; }

    public LocalDateTime getDueAt() { return dueAt; }
}
