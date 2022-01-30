package com.revature.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Request {
//int requestId, double amount, Date submitted, Date resolved, String description, int author, int resolver, String status, String type

    public int getRequestId() {
        return requestId;
    }

    public double getAmount() {
        return amount;
    }

    public String getSubmitted() {
        return submitted;
    }

    public String getResolved() {
        return resolved;
    }

    public String getDescription() {
        return description;
    }

    public int getAuthor() {
        return author;
    }

    public int getResolver() {
        return resolver;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    private int requestId;
    private double amount;
    private String submitted;
    private String resolved;
    private String description;
    private int author;
    private int resolver;
    private String status;
    private String type;

//    private Date resolved;
//    private Date submitted;
//    private int requestId;
//    private double amount;
//    private String description;
//    private int author;
//    private int resolver;
//    private String status;
//    private String type;

//    public Request(int requestId, double amount, String description, String status, int authorId, int resolverId, String type) {
//        this.requestId = requestId;
//        this.amount = amount;
//        this.description = description;
//        this.status = status;
//        this.author = authorId;
//        this.resolver = resolverId;
//        this.type = type;
//    }

    public Request(int requestId, double amount, String submitted, String resolved, String description, int author, int resolver, String status, String type) {
        this.requestId = requestId;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.author = author;
        this.resolver = resolver;
        this.status = status;
        this.type = type;


    }


}
