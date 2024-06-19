package com.sunovaa.spring_boot_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sunovaa.spring_boot_project.model.Device;
import com.sunovaa.spring_boot_project.service.DeviceService;

@RestController
@RequestMapping("/api")
public class DeviceController {

    private final DeviceService deviceDataService;

    public DeviceController(DeviceService deviceDataService) {
        this.deviceDataService = deviceDataService;
    }

    @PostMapping("/save")
    public ResponseEntity<Device> saveData(@RequestBody Device deviceData) {
    	Device savedData = deviceDataService.saveDeviceData(deviceData);
        return ResponseEntity.ok(savedData);
    }

    @GetMapping("/downloadsignature/{id}")
    public ResponseEntity<String> downloadSignature(@PathVariable Long id) {
        String signature = deviceDataService.generateSignature(id);
        return ResponseEntity.ok(signature);
    }
}
