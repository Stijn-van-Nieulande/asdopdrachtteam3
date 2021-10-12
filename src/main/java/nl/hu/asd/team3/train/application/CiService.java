package nl.hu.asd.team3.train.application;

import nl.hu.asd.team3.train.adapter.repository.TrainRepository;
import nl.hu.asd.team3.train.domain.Train;
import nl.hu.asd.team3.train.domain.dto.TrainCompositionMessageDTO;
import nl.hu.asd.team3.user.user.adapter.SecurityContext;
import org.springframework.stereotype.Service;

@Service
public class CiService
{
    private final SecurityContext securityContext;
    private final TrainRepository trainRepository;

    public CiService(final SecurityContext securityContext, final TrainRepository trainRepository)
    {
        this.securityContext = securityContext;
        this.trainRepository = trainRepository;
    }

    public Train sendMessageToCi(final TrainCompositionMessageDTO messageDTO)
    {
        final long senderCustomerId = this.securityContext.getCustomerId();
        final Train train = this.trainRepository.findByIdAndCustomerId(messageDTO.getTrainCode(), messageDTO.getCustomerId());
        train.sendTrainCompositionMessage(senderCustomerId, messageDTO);
        return this.trainRepository.save(train);
    }
}
