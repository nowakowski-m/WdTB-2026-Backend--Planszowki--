package pl.wsb.planszowki.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Wypożyczenie gry: kto, którą grę, na jaki okres, za ile i czy już oddał.
 * Użytkownik i gra wskazani są samymi ID (relacje dojdą na kolejnych zajęciach).
 */
@Entity
@Table(name = "game_rentals")
public class GameRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "board_game_id", nullable = false)
    private Long boardGameId;

    @Embedded
    private RentalPeriod period;

    @Column(name = "returned_at")
    private LocalDateTime returnedAt;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "deposit", precision = 10, scale = 2)
    private BigDecimal deposit;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private RentalStatus status;

    @Column(name = "notes", length = 500)
    private String notes;

    protected GameRental() {
    }

    public GameRental(Long userId, Long boardGameId, RentalPeriod period, BigDecimal totalPrice,
                      BigDecimal deposit) {
        this.userId = userId;
        this.boardGameId = boardGameId;
        this.period = period;
        this.totalPrice = totalPrice;
        this.deposit = deposit;
        this.status = RentalStatus.ACTIVE;
    }

    /** Czas wypożyczenia minął, a gra nie została jeszcze oddana. */
    public boolean isOverdue() {
        return returnedAt == null && status == RentalStatus.ACTIVE
                && LocalDateTime.now().isAfter(period.getDueAt());
    }

    public Long getId() { return id; }

    public Long getUserId() { return userId; }

    public Long getBoardGameId() { return boardGameId; }

    public RentalPeriod getPeriod() { return period; }

    public LocalDateTime getReturnedAt() { return returnedAt; }

    public BigDecimal getTotalPrice() { return totalPrice; }

    public BigDecimal getDeposit() { return deposit; }

    public RentalStatus getStatus() { return status; }

    public String getNotes() { return notes; }
}
