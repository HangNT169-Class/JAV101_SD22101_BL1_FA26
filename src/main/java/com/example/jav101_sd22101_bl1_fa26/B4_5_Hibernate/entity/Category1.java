package com.example.jav101_sd22101_bl1_fa26.B4_5_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // danh dau thuc the
@Table(name = "category") // name lay tu ten bang trong SQL
// add lombox
@Getter
@Setter
@AllArgsConstructor // contrutor full ts
@NoArgsConstructor // contructor k ts
@Builder // tao ra contructor tuy y ts
@ToString
public class Category1 {
    /**
     * Select * From table -> SQL truy van
     * Hibernate -> truy van entity (class trong java) -> HQL
     * ORM - Object Relationship Mapping:
     * Mapping quan he quan he cac bang va cac thuoc tinh trong bang
     * Thuoc tinh trong bang:
     * 1. PK
     * 2. FK
     * 3. Column binh thuong
     */

    @Id
    // neu ID tu tang/ tu gen - UUID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
