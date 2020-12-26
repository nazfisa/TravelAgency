package com.agency.agency.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy="location", cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH })
    private Set<Status> statuses;
    @Column(name = "isDeleted", nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted;
}
