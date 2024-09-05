package com.spring.orderapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="items")
public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemid;

}
