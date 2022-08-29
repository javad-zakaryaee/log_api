package com.samin.log_api.repository;

import com.samin.log_api.model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LogRepository extends JpaRepository<Log, String> {

    @Query("SELECT c FROM Log c " +
            "WHERE (:userId is null or c.userId = :userId) " +
            "and (:clientId is null or c.clientId = :clientId) " +
            "and (:ipAddress is null or c.ipAddress = :ipAddress) " +
            "and (:priority is null or c.priority = :priority) " +
            "and (:type is null or c.type = :type)")
    Page<Log> findByParams(@Param("userId") String userId,
                           @Param("clientId") String clientId,
                           @Param("ipAddress") String ipAddress,
                           @Param("priority") Integer priority,
                           @Param("type") String type,
                           PageRequest pageRequest);

}
