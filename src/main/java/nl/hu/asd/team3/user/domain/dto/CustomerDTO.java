package nl.hu.asd.team3.user.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//@Author Huib van Steenpaal

@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    private String companyCode;

    @NotBlank
    private String customername;

    @NotNull
    private int kvk;

    @NotBlank
    private String iban;
}
