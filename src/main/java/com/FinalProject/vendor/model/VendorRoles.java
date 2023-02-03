package com.FinalProject.vendor.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;


@Getter
@Setter
public class VendorRoles {
    private String roleName;

}
