package com.friends.factory.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {

    private String object;
    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateCreated;

    private String customer;
    private String subscription;
    private String paymentLink;
    private double value;
    private double netValue;
    private Double originalValue;
    private Double interestValue;
    private String description;
    private String billingType;
    private boolean canBePaidAfterDueDate;
    private String pixTransaction;
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date originalDueDate;

    private Date paymentDate;
    private Date clientPaymentDate;
    private Integer installmentNumber;
    private String invoiceUrl;
    private String invoiceNumber;
    private String externalReference;
    private boolean deleted;
    private boolean anticipated;
    private boolean anticipable;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creditDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date estimatedCreditDate;
    private String transactionReceiptUrl;
    private String nossoNumero;
    private String bankSlipUrl;
    private Date lastInvoiceViewedDate;
    private Date lastBankSlipViewedDate;
    private Discount discount;
    private Fine fine;
    private Interest interest;
    private boolean postalService;
    private String custody;
    private String refunds;
}
