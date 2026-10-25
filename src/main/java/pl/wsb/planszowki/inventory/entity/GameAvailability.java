package pl.wsb.planszowki.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

/**
 * Dostępność gry: ile sztuk danej gry mamy łącznie i ile jest teraz do wypożyczenia.
 * Gra wskazana jest samym ID (relacja {@code @OneToOne} dojdzie na kolejnych zajęciach).
 */
@Entity
@Table(name = "game_availability")
public class GameAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_game_id", nullable = false, unique = true)
    private Long boardGameId;

    @Column(name = "quantity_total", nullable = false)
    private Integer quantityTotal;

    @Column(name = "quantity_available", nullable = false)
    private Integer quantityAvailable;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    protected GameAvailability() {
    }

    public GameAvailability(Long boardGameId, Integer quantityTotal, Integer quantityAvailable) {
        this.boardGameId = boardGameId;
        this.quantityTotal = quantityTotal;
        this.quantityAvailable = quantityAvailable;
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public Long getBoardGameId() { return boardGameId; }

    public Integer getQuantityTotal() { return quantityTotal; }

    public Integer getQuantityAvailable() { return quantityAvailable; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
