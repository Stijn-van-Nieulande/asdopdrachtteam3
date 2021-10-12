package nl.hu.asd.team3.train.domain;

import nl.hu.asd.team3.company.adapter.CompanyRESTService;
import nl.hu.asd.team3.company.domain.Company;
import nl.hu.asd.team3.company.domain.Location;
import nl.hu.asd.team3.train.adapter.repository.MessageRepository;
import nl.hu.asd.team3.train.domain.dto.TrainCompositionMessageDTO;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Train
{
    private CompanyRESTService companyRESTService;
    private MessageRepository messageRepository;

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = ThreadLocalRandom.current().nextLong(1, 100000); // Just for demo
    private int trainType;
    private String operationalTrainNumber;
    private Date scheduledTimeAtHandover;
    private Date scheduledDateTimeAtTransfer;
    @Transient
    private Location transferPoint;
    @Transient
    private Company transfereeIM;
    private Long customerId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TrainCompositionMessage> trainCompositionMessages = new ArrayList<>();

    public Train(final CompanyRESTService companyRESTService, final MessageRepository messageRepository, final Long id, final int trainType, final String operationalTrainNumber, final Date scheduledTimeAtHandover, final Date scheduledDateTimeAtTransfer, final Location transferPoint, final Company transfereeIM, final Long customerId)
    {
        this.companyRESTService = companyRESTService;
        this.messageRepository = messageRepository;
        this.id = id;
        this.trainType = trainType;
        this.operationalTrainNumber = operationalTrainNumber;
        this.scheduledTimeAtHandover = scheduledTimeAtHandover;
        this.scheduledDateTimeAtTransfer = scheduledDateTimeAtTransfer;
        this.transferPoint = transferPoint;
        this.transfereeIM = transfereeIM;
        this.customerId = customerId;
    }

    public Train()
    {
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public int getTrainType()
    {
        return this.trainType;
    }

    public void setTrainType(final int trainType)
    {
        this.trainType = trainType;
    }

    public String getOperationalTrainNumber()
    {
        return this.operationalTrainNumber;
    }

    public void setOperationalTrainNumber(final String operationalTrainNumber)
    {
        this.operationalTrainNumber = operationalTrainNumber;
    }

    public Date getScheduledTimeAtHandover()
    {
        return this.scheduledTimeAtHandover;
    }

    public void setScheduledTimeAtHandover(final Date scheduledTimeAtHandover)
    {
        this.scheduledTimeAtHandover = scheduledTimeAtHandover;
    }

    public Date getScheduledDateTimeAtTransfer()
    {
        return this.scheduledDateTimeAtTransfer;
    }

    public void setScheduledDateTimeAtTransfer(final Date scheduledDateTimeAtTransfer)
    {
        this.scheduledDateTimeAtTransfer = scheduledDateTimeAtTransfer;
    }

    public Location getTransferPoint()
    {
        return this.transferPoint;
    }

    public void setTransferPoint(final Location transferPoint)
    {
        this.transferPoint = transferPoint;
    }

    public Company getTransfereeIM()
    {
        return this.transfereeIM;
    }

    public void setTransfereeIM(final Company transfereeIM)
    {
        this.transfereeIM = transfereeIM;
    }

    public Long getCustomerId()
    {
        return this.customerId;
    }

    public void setCustomerId(final Long customerId)
    {
        this.customerId = customerId;
    }

    public List<TrainCompositionMessage> getTrainCompositionMessages()
    {
        return this.trainCompositionMessages;
    }

    public void setTrainCompositionMessages(final List<TrainCompositionMessage> trainCompositionMessages)
    {
        this.trainCompositionMessages = trainCompositionMessages;
    }

    public void sendTrainCompositionMessage(final Long senderCompanyCode, final TrainCompositionMessageDTO messageDTO)
    {
        final Company recipient = this.companyRESTService.findByCode(messageDTO.getCompanyCode());
        final Company sender = this.companyRESTService.findByCode(senderCompanyCode);

        final TrainCompositionMessage compositionMessage = new TrainCompositionMessage(messageDTO, recipient, sender, this);
        this.trainCompositionMessages.add(compositionMessage);
        this.messageRepository.save(compositionMessage);
    }

    @Override
    public String toString()
    {
        return "Train{" +
                "companyRESTService=" + this.companyRESTService +
                ", messageRepository=" + this.messageRepository +
                ", id=" + this.id +
                ", trainType=" + this.trainType +
                ", operationalTrainNumber='" + this.operationalTrainNumber + '\'' +
                ", scheduledTimeAtHandover=" + this.scheduledTimeAtHandover +
                ", scheduledDateTimeAtTransfer=" + this.scheduledDateTimeAtTransfer +
                ", transferPoint=" + this.transferPoint +
                ", transfereeIM=" + this.transfereeIM +
                ", customerId=" + this.customerId +
                ", trainCompositionMessages=" + this.trainCompositionMessages +
                '}';
    }
}
