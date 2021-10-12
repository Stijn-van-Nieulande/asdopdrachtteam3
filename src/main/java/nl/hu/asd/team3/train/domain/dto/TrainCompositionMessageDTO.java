package nl.hu.asd.team3.train.domain.dto;

import java.util.Date;

public class TrainCompositionMessageDTO
{
    private final String objectType;
    private final Long companyCode;
    private final String core;
    private final String variant;
    private final int timetableYear;
    private final Long trainCode;
    private final Long customerId;
    private final Integer messageStatus;
    private final String senderReference;
    private final int messageType;
    private final String messageTypeVersion;
    private final String messageIdentifier;
    private final Date messageDateTime;

    public TrainCompositionMessageDTO(final String objectType, final Long companyCode, final String core, final String variant, final int timetableYear, final Long trainCode, final Long customerId, final Integer messageStatus, final String senderReference, final int messageType, final String messageTypeVersion, final String messageIdentifier, final Date messageDateTime)
    {
        this.objectType = objectType;
        this.companyCode = companyCode;
        this.core = core;
        this.variant = variant;
        this.timetableYear = timetableYear;
        this.trainCode = trainCode;
        this.customerId = customerId;
        this.messageStatus = messageStatus;
        this.senderReference = senderReference;
        this.messageType = messageType;
        this.messageTypeVersion = messageTypeVersion;
        this.messageIdentifier = messageIdentifier;
        this.messageDateTime = messageDateTime;
    }

    public String getObjectType()
    {
        return this.objectType;
    }

    public String getCore()
    {
        return this.core;
    }

    public String getVariant()
    {
        return this.variant;
    }

    public int getTimetableYear()
    {
        return this.timetableYear;
    }

    public Long getCompanyCode()
    {
        return this.companyCode;
    }

    public Long getTrainCode()
    {
        return this.trainCode;
    }

    public Long getCustomerId()
    {
        return this.customerId;
    }

    public Integer getMessageStatus()
    {
        return this.messageStatus;
    }

    public String getSenderReference()
    {
        return this.senderReference;
    }

    public int getMessageType()
    {
        return this.messageType;
    }

    public String getMessageTypeVersion()
    {
        return this.messageTypeVersion;
    }

    public String getMessageIdentifier()
    {
        return this.messageIdentifier;
    }

    public Date getMessageDateTime()
    {
        return this.messageDateTime;
    }
}
