package com.agency.agency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
@Table(name = "tbl_status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content")
    private String content;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH })
    @JoinColumn(name = "user_id")
//    @JsonIgnore
    private User user;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH })
    @JoinColumn(name = "location_id")
//    @JsonIgnore
    private Location location;
    @Column(name = "isPined", nullable = false)
    private boolean isPined;
    @Column(name = "isPrivate")
    private boolean isPrivate;
    @Column(name = "isDeleted", nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted;
}
