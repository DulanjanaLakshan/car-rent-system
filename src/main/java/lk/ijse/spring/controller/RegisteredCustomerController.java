package lk.ijse.spring.controller;

import lk.ijse.spring.dto.RegisteredCustomerDTO;
import lk.ijse.spring.service.RegisteredCustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registered/customer")
@CrossOrigin
public class RegisteredCustomerController {

    @Autowired
    RegisteredCustomerService customer;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(200, "Ok", customer.getAllRegisteredCustomer());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute RegisteredCustomerDTO customerDTO) {
        customer.saveRegisteredCustomer(customerDTO);
        return new ResponseUtil(200, "Save", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody RegisteredCustomerDTO customerDTO) {
        customer.updateRegisteredCustomer(customerDTO);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id) {
        customer.deleteRegisteredCustomer(id);
        return new ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "{/id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id) {
        return new ResponseUtil(200, "Ok", customer.searchRegisteredCustomer(id));
    }
}
