package com.acc.services;

import com.acc.entity.CustomerDetail;
import com.acc.model.dto.Customer.CustomerDetailRequest;
import com.acc.model.dto.Customer.CustomerDetailResponse;
import com.acc.repository.CustomerDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CustomerDetailService {

    @Autowired
    private CustomerDetailRepository repository;

    // GET API
    public CustomerDetailResponse getCustomerById(String customerId) {
        Optional<CustomerDetail> optionalCustomer = repository.findByCustomerIdAndMaintenanceFlag(customerId, "A");

        if (optionalCustomer.isPresent()) {
            CustomerDetail entity = optionalCustomer.get();
            return mapToResponse(entity);
        } else {
            // Option 1: Throw meaningful exception
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with ID: " + customerId);

            // Option 2: Return null or custom empty response (not recommended)
             return null;
        }
    }

    // ADD API
    public CustomerDetailResponse addCustomer(CustomerDetailRequest request) {
        CustomerDetail entity = mapToEntity(request);
        entity.setMaintenanceFlag("A");
        entity.setCreditRatingDate(LocalDate.now());
        entity.setRetirementAge(60); // example default value

        CustomerDetail saved = repository.save(entity);
        return mapToResponse(saved);
    }

    // Converts Entity to DTO
    private CustomerDetailResponse mapToResponse(CustomerDetail entity) {
        CustomerDetailResponse dto = new CustomerDetailResponse();
        dto.setCustomerId(entity.getCustomerId());
        dto.setOccupation(entity.getOccupation());
        dto.setOccupationCategory(entity.getOccupationCategory());
        dto.setDesignation(entity.getDesignation());
        dto.setTenure(entity.getTenure());
        dto.setEmployerName(entity.getEmployerName());
        dto.setEmpAddr1(entity.getEmpAddr1());
        dto.setEmpAddr2(entity.getEmpAddr2());
        dto.setEmpAddr3(entity.getEmpAddr3());
        dto.setEmpCity(entity.getEmpCity());
        dto.setEmpState(entity.getEmpState());
        dto.setEmpCountry(entity.getEmpCountry());
        dto.setEmpZip(entity.getEmpZip());
        dto.setEmpPhone(entity.getEmpPhone());
        dto.setEmpTelex(entity.getEmpTelex());
        dto.setEmpFax(entity.getEmpFax());
        dto.setYearsInJob(entity.getYearsInJob());
        dto.setRetirementAge(entity.getRetirementAge());
        dto.setCreditRating(entity.getCreditRating());
        dto.setCreditRatingDate(entity.getCreditRatingDate());
        dto.setCreditCard1Name(entity.getCreditCard1Name());
        dto.setCreditCard1Ref(entity.getCreditCard1Ref());
        dto.setCreditCard2Name(entity.getCreditCard2Name());
        dto.setCreditCard2Ref(entity.getCreditCard2Ref());
        dto.setCreditCard3Name(entity.getCreditCard3Name());
        dto.setCreditCard3Ref(entity.getCreditCard3Ref());
        dto.setPreviousEmployer(entity.getPreviousEmployer());
        dto.setPreviousJobDesignation(entity.getPreviousJobDesignation());
        dto.setReasonForLeaving(entity.getReasonForLeaving());
        dto.setLastSalary(entity.getLastSalary());
        dto.setLegalCaseFlag(entity.getLegalCaseFlag());
        dto.setLegalCaseText(entity.getLegalCaseText());
        dto.setPoliceRecord(entity.getPoliceRecord());
        dto.setSpouseName(entity.getSpouseName());
        dto.setSpouseNationalId(entity.getSpouseNationalId());
        dto.setSpouseOccupation(entity.getSpouseOccupation());
        dto.setSpouseDesignation(entity.getSpouseDesignation());
        dto.setSpouseDob(entity.getSpouseDob());
        dto.setMarriageDate(entity.getMarriageDate());
        dto.setSpouseEmployer(entity.getSpouseEmployer());
        dto.setSpouseEmpAddr1(entity.getSpouseEmpAddr1());
        dto.setSpouseEmpAddr2(entity.getSpouseEmpAddr2());
        dto.setSpouseEmpAddr3(entity.getSpouseEmpAddr3());
        dto.setSpouseEmpPhone(entity.getSpouseEmpPhone());
        return dto;
    }

    // Converts DTO to Entity
    private CustomerDetail mapToEntity(CustomerDetailRequest dto) {
        CustomerDetail entity = new CustomerDetail();
        entity.setCustomerId(dto.getCustomerId());
        entity.setOccupation(dto.getOccupation());
        entity.setOccupationCategory(dto.getOccupationCategory());
        entity.setDesignation(dto.getDesignation());
        entity.setTenure(dto.getTenure());
        entity.setEmployerName(dto.getEmployerName());
        entity.setEmpAddr1(dto.getEmpAddr1());
        entity.setEmpAddr2(dto.getEmpAddr2());
        entity.setEmpAddr3(dto.getEmpAddr3());
        entity.setEmpCity(dto.getEmpCity());
        entity.setEmpState(dto.getEmpState());
        entity.setEmpCountry(dto.getEmpCountry());
        entity.setEmpZip(dto.getEmpZip());
        entity.setEmpPhone(dto.getEmpPhone());
        entity.setEmpTelex(dto.getEmpTelex());
        entity.setEmpFax(dto.getEmpFax());
        entity.setYearsInJob(dto.getYearsInJob());
        entity.setCreditRating(dto.getCreditRating());
        entity.setCreditCard1Name(dto.getCreditCard1Name());
        entity.setCreditCard1Ref(dto.getCreditCard1Ref());
        entity.setCreditCard2Name(dto.getCreditCard2Name());
        entity.setCreditCard2Ref(dto.getCreditCard2Ref());
        entity.setCreditCard3Name(dto.getCreditCard3Name());
        entity.setCreditCard3Ref(dto.getCreditCard3Ref());
        entity.setPreviousEmployer(dto.getPreviousEmployer());
        entity.setPreviousJobDesignation(dto.getPreviousJobDesignation());
        entity.setReasonForLeaving(dto.getReasonForLeaving());
        entity.setLastSalary(dto.getLastSalary());
        entity.setLegalCaseFlag(dto.getLegalCaseFlag());
        entity.setLegalCaseText(dto.getLegalCaseText());
        entity.setPoliceRecord(dto.getPoliceRecord());
        entity.setSpouseName(dto.getSpouseName());
        entity.setSpouseNationalId(dto.getSpouseNationalId());
        entity.setSpouseOccupation(dto.getSpouseOccupation());
        entity.setSpouseDesignation(dto.getSpouseDesignation());
        entity.setSpouseDob(dto.getSpouseDob());
        entity.setMarriageDate(dto.getMarriageDate());
        entity.setSpouseEmployer(dto.getSpouseEmployer());
        entity.setSpouseEmpAddr1(dto.getSpouseEmpAddr1());
        entity.setSpouseEmpAddr2(dto.getSpouseEmpAddr2());
        entity.setSpouseEmpAddr3(dto.getSpouseEmpAddr3());
        entity.setSpouseEmpPhone(dto.getSpouseEmpPhone());
        return entity;
    }
}

