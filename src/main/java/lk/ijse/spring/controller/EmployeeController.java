package lk.ijse.spring.controller;

import lk.ijse.spring.dto.EmployeeDTO;
import lk.ijse.spring.service.EmployeeService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllEmployee() {
        return new ResponseUtil(200, "OK", employeeService.getAllEmployee());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return new ResponseUtil(200, "Save", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeDTO);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteEmployee(@RequestParam String id) {
        employeeService.deleteEmployee(id);
        return new ResponseUtil(200, "Delete", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchEmployee(@PathVariable String id) {
        return new ResponseUtil(200, "Ok", employeeService.searchEmployee(id));
    }
}
