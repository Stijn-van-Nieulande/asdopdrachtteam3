package nl.hu.asd.team3.train.domain.dto;

import java.util.Date;

public class TrainDTO {
    public int trainType;
    public String operationalTrainNumber;
    public Date scheduledTimeAtHandover;
    public Date scheduledDateTimeAtTransfer;
    public String companyCode;
    public Long locationId;

    public TrainDTO(int trainType, String operationalTrainNumber, Date scheduledTimeAtHandover, Date scheduledDateTimeAtTransfer, String companyCode, Long locationId) {
        this.trainType = trainType;
        this.operationalTrainNumber = operationalTrainNumber;
        this.scheduledTimeAtHandover = scheduledTimeAtHandover;
        this.scheduledDateTimeAtTransfer = scheduledDateTimeAtTransfer;
        this.companyCode = companyCode;
        this.locationId = locationId;
    }
}
