package com.accenture.banking.resource.builder;

import org.springframework.stereotype.Component;

import com.accenture.banking.model.Office;
import com.accenture.banking.resource.dto.OfficeDto;

@Component("entityToDtoBuilder")
public class EntityToDtoBuilder {

	public EntityToDtoBuilder() {
	}

	public OfficeDto buildOfficeDto(Office office) {
		OfficeDto dto = null;
		if (office != null) {
			dto = new OfficeDto();
			dto.setId(office.getId());
			dto.setAddress(office.getAddress());
			dto.setPhone(office.getPhone());
		}
		return dto;
	}

}
