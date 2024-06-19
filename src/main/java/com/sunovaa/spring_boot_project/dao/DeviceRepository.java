package com.sunovaa.spring_boot_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunovaa.spring_boot_project.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
