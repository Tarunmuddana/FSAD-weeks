package com.hospital.controller;

import com.hospital.entity.Doctor;
import com.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> insertDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.insertDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping("/high-fee")
    public ResponseEntity<List<Doctor>> getHighFeeDoctors(@RequestParam(defaultValue = "1000.0") Double threshold) {
        return new ResponseEntity<>(doctorService.getDoctorsWithHighFee(threshold), HttpStatus.OK);
    }
}
