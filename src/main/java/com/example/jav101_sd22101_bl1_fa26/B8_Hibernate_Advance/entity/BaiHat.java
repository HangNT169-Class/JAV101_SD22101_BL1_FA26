package com.example.jav101_sd22101_bl1_fa26.B8_Hibernate_Advance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bai_hat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaiHat {

    // MAPPING MỌI THỨ BÌNH THƯỜNG TRỪ THUỘC TÍNH KHOÁ NGOẠI KHÔNG MAPPING
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_bai_hat")
    private String tenBaiHat;

    @Column(name = "ten_tac_gia")
    private String tenTacGia;

    @Column(name = "thoi_luong")
    private Integer thoiLuong;

    @Column(name = "ngay_san_xuat")
    private String ngaySanXuat;

    @Column
    private Float gia;

    @Column(name = "phat_hanh_dia")
    private Boolean phatHanhDia;

    @Column(name = "ngay_ra_mat")
    private String ngayRaMat;

    // C1 mapping bt -> xu ly join - repository
    // C2: Xu ly join bang o trong class entity
    // B1: Chuyen thuoc tinh -> doi tuongj entity khoa ngoai
    // B2: Xd mqh giua 2 thuc the
//    1 CS -> N bai hat
//    1 BH -> 1CS
    // CS <-> BH: 1 * N / 1 = N
    @ManyToOne
//    @JoinColumn(name = "ca_si_id", referencedColumnName = "id")
    @JoinColumn(name = "ca_si_id")
    //  @Column(name = "ngay_ra_mat")
    private CaSi1 caSi1;  // Khai bao entity cua doi tuong khoa ngoai

}
