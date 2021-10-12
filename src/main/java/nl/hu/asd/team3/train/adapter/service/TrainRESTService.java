package nl.hu.asd.team3.train.adapter.service;

import nl.hu.asd.team3.train.application.CiService;
import nl.hu.asd.team3.train.domain.dto.TrainCompositionMessageDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainRESTService
{
    private final CiService ciService;

    public TrainRESTService(final CiService ciService)
    {
        this.ciService = ciService;
    }

    public void sendTrainCompositionMessage(@Validated @RequestBody final Long trainId, @Validated @RequestBody final TrainCompositionMessageDTO messageDTO)
    {
        this.ciService.sendMessageToCi(messageDTO);
    }
}
