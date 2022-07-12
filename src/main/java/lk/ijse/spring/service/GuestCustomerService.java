package lk.ijse.spring.service;

import lk.ijse.spring.dto.GuestCustomerDTO;

import java.util.List;

public interface GuestCustomerService {
    void saveGuestCustomer(GuestCustomerDTO dto);
    void deleteGuestCustomer(String id);
    void updateGuestCustomer(GuestCustomerDTO dto);
    GuestCustomerDTO searchGuestCustomer(String id);
    List<GuestCustomerDTO> getAllGuestCustomer();
}
