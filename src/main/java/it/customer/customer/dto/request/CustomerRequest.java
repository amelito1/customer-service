package it.customer.customer.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRequest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotNull
    private LocalDate dateOfBirth;

    @Pattern(regexp = "^([A-Z]{6}[0-9LMNPQRSTUV]{2}[ABCDEHLMPRST]{1}[0-9LMNPQRSTUV]{2}[A-Z]{1}[0-9LMNPQRSTUV]{3}[A-Z]{1})$|([0-9]{11})$")
    private String taxIdentificationNumber;
}
