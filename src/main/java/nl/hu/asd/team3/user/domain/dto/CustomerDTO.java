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

    @NotNull
    private long id;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public int getKvk() {
        return kvk;
    }

    public void setKvk(int kvk) {
        this.kvk = kvk;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
