package com.blueconch.EcommerceWebsite.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blueconch.EcommerceWebsite.DTO.AddressDTO;
import com.blueconch.EcommerceWebsite.model.Address;
import com.blueconch.EcommerceWebsite.services.AddressService;

@RestController
public class AddressController {

	@Autowired
	public AddressService service;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/{userId}/address")
	public AddressDTO getAddressByUserId(@PathVariable int userId) {
		Address address = service.getAddressByUserId(userId);
		return convertToDto(address);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/address")
	public AddressDTO addAddress(@RequestBody AddressDTO addressDTO){
		Address address = convertToEntity(addressDTO);
		return convertToDto(service.addAddress(address));
	}

	private AddressDTO convertToDto(Address address) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
		addressDTO.setUserId(address.getUser().getUserId());
        return addressDTO;
    }
	
	private Address convertToEntity(AddressDTO addressDTO) {
		
        return new ModelMapper().map(addressDTO, Address.class);
    }
}
