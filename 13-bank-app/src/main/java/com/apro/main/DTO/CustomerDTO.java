package com.apro.main.DTO;



import com.apro.main.entity.Customer;
import com.apro.main.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDTO {
	private Long customerId;
	private String firstName;
	private String lastName;
	private String email; 
	private int userId;
    public static CustomerDTO toCustomerDtoMapper(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(customer.getCustomerId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        User user = customer.getUser();
        int userId=0;
        if(user!=null)
        	userId=user.getUserId();
        dto.setUserId(userId);
        return dto;
    }

    public static Customer toCustomerMapper(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setCustomerId(dto.getCustomerId());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        return customer;
    }
	
}
