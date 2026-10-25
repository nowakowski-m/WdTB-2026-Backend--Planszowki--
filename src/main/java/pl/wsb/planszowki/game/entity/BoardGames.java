package pl.wsb.planszowki.game.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

/**
 * Gra planszowa: katalog wszystkich gier oferowanych w wypożyczalni / sklepie.
 */
@Entity
@Table(name = "board_games")
public class BoardGames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = false, length = 120)
    private String name;

    @Column(name = "publisher", nullable = false, length = 80)
    private String publisher;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "rental_price_per_day", nullable = false, precision = 10, scale = 2)
    private BigDecimal rentalPricePerDay;

    @Column(name = "min_players", nullable = false)
    private Integer minPlayers;

    @Column(name = "max_players", nullable = false)
    private Integer maxPlayers;

    @Column(name = "play_time_minutes")
    private Integer playTimeMinutes;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "category", length = 60)
    private String category;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "description", length = 1000)
    private String description;

    protected BoardGames() {
    }

    public BoardGames(String name, String publisher, BigDecimal price, BigDecimal rentalPricePerDay,
                      Integer minPlayers, Integer maxPlayers, Integer playTimeMinutes, Integer minAge,
                      String category, Integer releaseYear, String description) {
        this.name = name;
        this.publisher = publisher;
        this.price = price;
        this.rentalPricePerDay = rentalPricePerDay;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playTimeMinutes = playTimeMinutes;
        this.minAge = minAge;
        this.category = category;
        this.releaseYear = releaseYear;
        this.description = description;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getPublisher() { return publisher; }

    public BigDecimal getPrice() { return price; }

    public BigDecimal getRentalPricePerDay() { return rentalPricePerDay; }

    public Integer getMinPlayers() { return minPlayers; }

    public Integer getMaxPlayers() { return maxPlayers; }

    public Integer getPlayTimeMinutes() { return playTimeMinutes; }

    public Integer getMinAge() { return minAge; }

    public String getCategory() { return category; }

    public Integer getReleaseYear() { return releaseYear; }

    public String getDescription() { return description; }
}
