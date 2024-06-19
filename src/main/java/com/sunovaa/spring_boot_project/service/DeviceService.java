package com.sunovaa.spring_boot_project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.sunovaa.spring_boot_project.dao.DeviceRepository;
import com.sunovaa.spring_boot_project.model.Device;

import java.security.MessageDigest;

@Service
public class DeviceService {

    private final DeviceRepository repository;

    @Value("${signature.algorithm}")
    private String signatureAlgorithm; // "SHA-256" or "SHA-512" based on configuration

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public Device saveDeviceData(Device deviceData) {
        return repository.save(deviceData);
    }

    public String generateSignature(Long id) {
    	Device deviceData = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Device data not found for ID: " + id));

        String jsonContent = "{\"deviceSerialNumber\":\"" + deviceData.getSerialNumber() + "\","
                + "\"portNumber\":\"" + deviceData.getPortNumber() + "\","
                + "\"type\":\"" + deviceData.getType() + "\"}";

        try {
            MessageDigest digest = MessageDigest.getInstance(signatureAlgorithm);
            byte[] hash = digest.digest(jsonContent.getBytes());
            return Base64Utils.encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Error generating signature", e);
        }
    }
}
