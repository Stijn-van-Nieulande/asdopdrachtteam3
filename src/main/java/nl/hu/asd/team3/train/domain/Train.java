package nl.hu.asd.team3.train.domain;

import net.minidev.json.annotate.JsonIgnore;
import nl.hu.asd.team3.company.domain.Company;
import nl.hu.asd.team3.company.domain.Location;
import nl.hu.asd.team3.train.adapter.service.TrainService;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Train {
    //@Id
    //@GeneratedValue (strategy = GenerationType.AUTO)
    // Because there is no real database, I use random number generator.
    private Long id = ThreadLocalRandom.current().nextLong(0, 99999999);
    private int trainType;
    private String operationalTrainNumber;
    private Date scheduledTimeAtHandover;
    private Date scheduledDateTimeAtTransfer;

    private Long customerId;
    private Location transferPoint;
    private Company transfereeIM;


    public Train(int trainType, String operationalTrainNumber, Date scheduledTimeAtHandover, Date scheduledDateTimeAtTransfer, String companyCode, Long locationId, TrainService trainService) {
        this.trainType = trainType;
        this.operationalTrainNumber = operationalTrainNumber;
        this.scheduledTimeAtHandover = scheduledTimeAtHandover;
        this.scheduledDateTimeAtTransfer = scheduledDateTimeAtTransfer;

        this.customerId = trainService.getCustomerId();
        this.transferPoint = trainService.getLocation(locationId);

        Company tempObject = trainService.findRecipientByCode(companyCode);

        if(tempObject != null){
            this.transfereeIM = tempObject;
        }
    }

    public Train() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTrainType() {
        return trainType;
    }

    public void setTrainType(int trainType) {
        this.trainType = trainType;
    }

    public String getOperationalTrainNumber() {
        return operationalTrainNumber;
    }

    public void setOperationalTrainNumber(String operationalTrainNumber) {
        this.operationalTrainNumber = operationalTrainNumber;
    }

    public Date getScheduledTimeAtHandover() {
        return scheduledTimeAtHandover;
    }

    public void setScheduledTimeAtHandover(Date scheduledTimeAtHandover) {
        this.scheduledTimeAtHandover = scheduledTimeAtHandover;
    }

    public Date getScheduledDateTimeAtTransfer() {
        return scheduledDateTimeAtTransfer;
    }

    public void setScheduledDateTimeAtTransfer(Date scheduledDateTimeAtTransfer) {
        this.scheduledDateTimeAtTransfer = scheduledDateTimeAtTransfer;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Location getTransferPoint() {
        return transferPoint;
    }

    public void setTransferPoint(Location transferPoint) {
        this.transferPoint = transferPoint;
    }

    public Company getTransfereeIM() {
        return transfereeIM;
    }

    public void setTransfereeIM(Company transfereeIM) {
        this.transfereeIM = transfereeIM;
    }

    @Override
    public String toString() {
            return "Train{" +
                    "id=" + id +
                    ", trainType=" + trainType +
                    ", operationalTrainNumber='" + operationalTrainNumber + '\'' +
                    ", scheduledTimeAtHandover=" + scheduledTimeAtHandover +
                    ", scheduledDateTimeAtTransfer=" + scheduledDateTimeAtTransfer +
                    ", customerId=" + customerId +
                    ", transferPoint=" + transferPoint +
                    ", transfereeIM=" + (transfereeIM != null ? transfereeIM.getName() : "null")+
                    '}';

    }
}
