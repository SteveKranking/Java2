package com.project.OneToOne.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.OneToOne.models.License;
import com.project.OneToOne.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	private LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

    public void addLicense (License license) {
        licenseRepository.save(license);
    }

}