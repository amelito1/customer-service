package it.customer.customer.dto.response;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CustomerResponse(
        @NotNull long id,
        @NotNull String name,
        @NotNull LocalDate dateOfBirth,
        String taxIdentificationNumber,
        String email) {
}
