package com.codenation.mapfood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
public class Motoboy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "motoboy_seq")
    @SequenceGenerator(name = "motoboy_seq", sequenceName = "motoboy_seq", allocationSize = 1)
    private Long id;


    @OneToMany(fetch = FetchType.LAZY, mappedBy="motoboy")
    @JsonIgnore
    private List<Orders> orders;

    @Embedded
    private Coordinates coordinates;

    public Motoboy() {
    }

    public Motoboy(Long id, String longitude, String latitude) {
        this.id = id;
        this.coordinates = new Coordinates(longitude, latitude);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

}
