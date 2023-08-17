package controller;

import config.LoadDatabase;
import entity.Employee;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import repository.EmployeeRepo;

import java.util.List;

@RestController
@RequestMapping("/api/payroll/employees")
public class EmployeeCtrl {
    private final EmployeeRepo repository;

    public EmployeeCtrl(EmployeeRepo repository) {
        this.repository = repository;
    }
    @GetMapping("")
    public List<Employee> all(){
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/{id}")
    public Employee one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found"));
    }
}
