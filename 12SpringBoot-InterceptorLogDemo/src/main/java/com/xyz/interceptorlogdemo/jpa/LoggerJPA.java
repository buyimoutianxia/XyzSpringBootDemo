package com.xyz.interceptorlogdemo.jpa;

import com.xyz.interceptorlogdemo.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerJPA extends JpaRepository<LoggerEntity, Long> {
}
