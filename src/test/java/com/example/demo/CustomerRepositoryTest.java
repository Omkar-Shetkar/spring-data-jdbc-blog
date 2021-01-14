package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ContextConfiguration(classes = DomainConfig.class)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void createSimpleCustomer() {
        Customer customer = new Customer();
        customer.firstName = "Albert";
        customer.dob = LocalDate.of(1904, 5, 14);

        Customer saved = customerRepository.save(customer);

        assertThat(saved.id).isNotNull();

        saved.firstName = "Hans Albert";

        customerRepository.save(saved);

        Optional<Customer> reloaded = customerRepository.findById(saved.id);

        assertThat(reloaded).isNotEmpty();

        assertThat(reloaded.get().firstName).isEqualTo("Hans Albert");

    }

    @Test
    public void findByFirstName() {
        Customer customer = new Customer();
        customer.firstName = "Albert";
        customer.dob = LocalDate.of(1904, 5, 14);

        Customer saved = customerRepository.save(customer);

        assertThat(saved.id).isNotNull();

        customer.id = null;
        customer.firstName = "Isaac";

        customerRepository.save(customer);

        customer.id = null;
        customer.firstName = "Michael";

        customerRepository.save(customer);

        assertThat(customerRepository.findByFirstName("Isaac")).hasSize(1);


    }
}
