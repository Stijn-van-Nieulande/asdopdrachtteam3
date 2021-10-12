package nl.hu.asd.team3.train.domain;

import nl.hu.asd.team3.company.domain.Company;
import nl.hu.asd.team3.train.domain.dto.TrainCompositionMessageDTO;

import javax.persistence.Transient;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class TrainCompositionMessage
{
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = ThreadLocalRandom.current().nextLong(1, 100000); // Just for demo
    private String objectType;
    private String core;
    private String variant;
    private int timetableYear;
    private Train train;
    private Long customerId;
    private Integer messageStatus;
    private String senderReference;
    @Transient
    private Company sender;
    @Transient
    private Company recipient;
    private int messageType;
    private String messageTypeVersion;
    private String messageIdentifier;
    private Date messageDateTime;

    public TrainCompositionMessage(final TrainCompositionMessageDTO messageDTO, final Company recipient, final Company sender, final Train train)
    {
        this.objectType = messageDTO.getObjectType();
        this.core = messageDTO.getCore();
        this.variant = messageDTO.getVariant();
        this.timetableYear = messageDTO.getTimetableYear();
        this.train = train;
        this.customerId = messageDTO.getCustomerId();
        this.messageStatus = messageDTO.getMessageStatus();
        this.senderReference = messageDTO.getSenderReference();
        this.sender = sender;
        this.recipient = recipient;
        this.messageType = messageDTO.getMessageType();
        this.messageTypeVersion = messageDTO.getMessageTypeVersion();
        this.messageIdentifier = messageDTO.getMessageIdentifier();
        this.messageDateTime = messageDTO.getMessageDateTime();
    }

    public TrainCompositionMessage()
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

    public String getObjectType()
    {
        return this.objectType;
    }

    public void setObjectType(final String objectType)
    {
        this.objectType = objectType;
    }

    public String getCore()
    {
        return this.core;
    }

    public void setCore(final String core)
    {
        this.core = core;
    }

    public String getVariant()
    {
        return this.variant;
    }

    public void setVariant(final String variant)
    {
        this.variant = variant;
    }

    public int getTimetableYear()
    {
        return this.timetableYear;
    }

    public void setTimetableYear(final int timetableYear)
    {
        this.timetableYear = timetableYear;
    }

    public Train getTrain()
    {
        return this.train;
    }

    public void setTrain(final Train train)
    {
        this.train = train;
    }

    public Long getCustomerId()
    {
        return this.customerId;
    }

    public void setCustomerId(final Long customerId)
    {
        this.customerId = customerId;
    }

    public Integer getMessageStatus()
    {
        return this.messageStatus;
    }

    public void setMessageStatus(final Integer messageStatus)
    {
        this.messageStatus = messageStatus;
    }

    public String getSenderReference()
    {
        return this.senderReference;
    }

    public void setSenderReference(final String senderReference)
    {
        this.senderReference = senderReference;
    }

    public Company getSender()
    {
        return this.sender;
    }

    public void setSender(final Company sender)
    {
        this.sender = sender;
    }

    public Company getRecipient()
    {
        return this.recipient;
    }

    public void setRecipient(final Company recipient)
    {
        this.recipient = recipient;
    }

    public int getMessageType()
    {
        return this.messageType;
    }

    public void setMessageType(final int messageType)
    {
        this.messageType = messageType;
    }

    public String getMessageTypeVersion()
    {
        return this.messageTypeVersion;
    }

    public void setMessageTypeVersion(final String messageTypeVersion)
    {
        this.messageTypeVersion = messageTypeVersion;
    }

    public String getMessageIdentifier()
    {
        return this.messageIdentifier;
    }

    public void setMessageIdentifier(final String messageIdentifier)
    {
        this.messageIdentifier = messageIdentifier;
    }

    public Date getMessageDateTime()
    {
        return this.messageDateTime;
    }

    public void setMessageDateTime(final Date messageDateTime)
    {
        this.messageDateTime = messageDateTime;
    }

    @Override
    public String toString()
    {
        return "TrainCompositionMessage{" +
                "id=" + this.id +
                ", objectType='" + this.objectType + '\'' +
                ", core='" + this.core + '\'' +
                ", variant='" + this.variant + '\'' +
                ", timetableYear=" + this.timetableYear +
                ", trainId=" + this.train.getId() +
                ", customerId=" + this.customerId +
                ", messageStatus=" + this.messageStatus +
                ", senderReference='" + this.senderReference + '\'' +
                ", sender=" + this.sender +
                ", recipient=" + this.recipient +
                ", messageType=" + this.messageType +
                ", messageTypeVersion='" + this.messageTypeVersion + '\'' +
                ", messageIdentifier='" + this.messageIdentifier + '\'' +
                ", messageDateTime=" + this.messageDateTime +
                '}';
    }
}
