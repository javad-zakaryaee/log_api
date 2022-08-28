package com.samin.log_api.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "custom_logger", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Log {

    @Id
    @NonNull
    private String id;

    @NonNull
    @Column(name = "client_id")
    private String clientId;

    @NonNull
    @Column(name = "ip_address")
    private String ipAddress;

    @NonNull
    @Column(name = "realm_id")
    private String realmId;

    @Column(name = "session_id")
    private String sessionId;

    @NonNull
    @Column(name = "type")
    private String type;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "error")
    private String error;

    @NonNull
    @Column(name = "priority")
    private int priority;

    @Column(name = "sub_type")
    private String subType;

    @Column(name = "event_time")
    private long eventTime;

}