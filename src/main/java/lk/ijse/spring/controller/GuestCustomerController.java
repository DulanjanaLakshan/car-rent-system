package lk.ijse.spring.controller;


import lk.ijse.spring.dto.GuestCustomerDTO;
import lk.ijse.spring.service.GuestCustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class GuestCustomerController {
    @Autowired
    GuestCustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllGuestCustomer() {
        return new ResponseUtil(200, "ok", customerService.getAllGuestCustomer());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute GuestCustomerDTO customer) {
        customerService.saveGuestCustomer(customer);
        return new ResponseUtil(200, "save", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody GuestCustomerDTO customer) {
        customerService.updateGuestCustomer(customer);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id) {
        customerService.deleteGuestCustomer(id);
        return new ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "{/id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id) {
        return new ResponseUtil(200, "Ok", customerService.searchGuestCustomer(id));
    }
}
