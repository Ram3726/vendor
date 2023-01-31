package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.AddressEntity;
import com.FinalProject.vendor.entity.DriverTable;
import com.FinalProject.vendor.model.Address;
import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.repository.AddressRepository;
import com.FinalProject.vendor.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;


@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;
@Autowired
private AddressRepository addressRepository;

    public String saveDriver(List<DriverModel> driverModel) throws ParseException {
        for (DriverModel driverDetails : driverModel) {//advance loop to set each element from model
            DriverTable driverTable = new DriverTable();
            driverTable.setDriverId(driverDetails.getDriverId());
            driverTable.setDriverName(driverDetails.getDriverName());
            driverTable.setPhoneNo(driverDetails.getPhoneNo());
            driverTable.setDrivingLicense(driverDetails.getDrivingLicense());


            List<Address> addresses = driverDetails.getAddress();
            for (Address address : addresses) {
                AddressEntity addressEntity = new AddressEntity();
                addressEntity.setCity(address.getCity());
                addressEntity.setCountry(address.getCountry());
                addressEntity.setPin(address.getPin());
                driverTable.setAddressEntity(addressEntity);
            }
            this.driverRepository.save(driverTable);
           // this.addressRepository.save(addressEntity);


            /*

            public String saveAddressData(List<EmployeeModel> employee) throws ParseException {
                for (EmployeeModel empModel : employee) {
                    EmployeeEntity employeeEntity = new EmployeeEntity();
                    employeeEntity.setFirstName(empModel.getName());
                    if (empModel.getEmpId() != null && empModel.getEmpId().startsWith("E")) {
                        employeeEntity.setEmpId(empModel.getEmpId());
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/YYYY");
                    Date dob = simpleDateFormat.parse(empModel.getDob());
                    employeeEntity.setStudDoB(dob);
                    List<Address> addresses = empModel.getAddress();
                    //List<AddressEntity> addressEntities = new ArrayList<>();
                    for (Address address : addresses) {
                        AddressEntity addressEntity =  new AddressEntity();
                        addressEntity.setCity(address.getCity());
                        addressEntity.setHouseNumber(address.getHouseNumber());
                        addressEntity.setPinCode(address.getPinCode());
                        //if we are using Many to one
                        //addressEntity.setEmployeeEntity(employeeEntity);
                        employeeEntity.addAddress(addressEntity);
                        //addressEntities.add(addressEntity);
                    }

                    //employeeEntity.setAddressList(addressEntities);
                    this.employeeRepository.save(employeeEntity);
                }
                return "success";
            }*/







            try {
                driverRepository.save(driverTable);
            } catch (Exception e) {
                System.err.println("Error details " + e.getMessage());
            }
        }
        return "success";
    }
}
/*
    // Update Logic
    public String updateDriverDetails(DriverModel driverModel
    ) {

        DriverTable driverTable = driverRepository.findBylicense(driverModel.getDrivingLicense());

        if (driverTable == null) {
            return "Error: driver not found.";
        }
        driverTable.setDriverId(driverModel.getDriverId());
        driverTable.setDriverName(driverModel.getDriverName());
        driverTable.setPhoneNo(driverModel.getPhoneNo());
        driverTable.setDrivingLicense(driverModel.getDrivingLicense());

        return "Driver details updated";
    }

    // Fetch Login
    public DriverModel fetchDriverDetails(DriverModel drivertable) {
        DriverTable driverTable = driverRepository.findBylicense(drivertable.getDrivingLicense());
        DriverModel driverModel1 = new DriverModel();

        if (driverTable != null) {

            driverModel1.setDriverId(drivertable.getDriverId());
            driverModel1.setDriverName(drivertable.getDriverName());
            driverModel1.setPhoneNo(drivertable.getPhoneNo());
            driverModel1.setDrivingLicense(drivertable.getDrivingLicense());

        }
        return driverModel1;
    }

    public String deleteDriverInfo(Integer id) {
        try {
            driverRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        }
        return "Success";
    }
}



*/











