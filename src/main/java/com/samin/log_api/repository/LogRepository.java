package com.samin.log_api.repository;

import com.samin.log_api.model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LogRepository extends JpaRepository<Log, String> {
    @Override
    Optional<Log> findById(String s);
    Page<Log> findAllByUserId(String userId, PageRequest pageRequest);
    Page<Log> findAllByType(String type, PageRequest pageRequest);
    Page<Log> findAllByClientId(String clientId, PageRequest pageRequest);
    Page<Log> findAllByIpAddress(String ipAddress, PageRequest pageRequest);
}
