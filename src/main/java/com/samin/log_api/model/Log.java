package com.samin.log_api.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "custom_logger", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Log {

    @Id
    private String id;


    @Column(name = "client_id")
    private String clientId;

    @Column(name = "ip_address")
    private String ipAddress;


    @Column(name = "realm_id")
    private String realmId;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "type")
    private String type;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "error")
    private String error;


    @Column(name = "priority")
    private int priority;

    @Column(name = "sub_type")
    private String subType;

    @Column(name = "event_time")
    private long eventTime;

}