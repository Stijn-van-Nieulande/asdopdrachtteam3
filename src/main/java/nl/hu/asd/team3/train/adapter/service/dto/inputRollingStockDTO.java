package nl.hu.asd.team3.train.adapter.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class inputRollingStockDTO {

    @NotNull
    public Integer position;

    @NotBlank
    public String stockType;
}
