package com.FinalProject.vendor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Driver_Info")
public class DriverTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "driver_id")
    private String driverId;

    @Column(name = "name")
    private String driverName;

    @Column(name = "phone")
    private String phoneNo;

    @Column(name = "driver_licence_number")
    private String drivingLicense;


    @OneToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private AddressEntity addressEntity;


   // @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // private AddressEntity addressEntity;




   /* private List<AddressEntity> addresses;

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void addAddress(AddressEntity address) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<>();
        }
        this.addresses.add(address);
    }*/

}