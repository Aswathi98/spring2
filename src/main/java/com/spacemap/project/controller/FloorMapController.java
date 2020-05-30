package com.spacemap.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.CityModel;
import com.spacemap.project.model.FacilityModel;
import com.spacemap.project.model.FloorMapDetailsModel;
import com.spacemap.project.model.FloorModel;
import com.spacemap.project.model.SwapModel;
import com.spacemap.project.sevice.CityDropdownService;
import com.spacemap.project.sevice.FacilityDropdownService;
import com.spacemap.project.sevice.FloorDropdownService;
import com.spacemap.project.sevice.FloorMapOccupationDetailsService;
import com.spacemap.project.sevice.SwapDetailsService;

@RestController
@CrossOrigin("*")
public class FloorMapController {
	@Autowired
	CityDropdownService cityDemoService;

	@Autowired
	FacilityDropdownService facilityDropdownService;

	@Autowired
	FloorDropdownService floorDropdownService;

	@Autowired
	FloorMapOccupationDetailsService floorMapOccupationDetailsService;
	
	@Autowired
	SwapDetailsService swapDetailsService;

	@GetMapping(value = "/cities")
	public List<CityModel> getCities() {
		return cityDemoService.getCities();
	}

	@PostMapping(value = "/facility")
	public List<FacilityModel> getFacilities(@RequestBody CityModel cityModel) {
		// System.out.println(cityModel.getCityId());
		// System.out.println(facilityDropdownService.getfacilitytyname(cityModel));
		return facilityDropdownService.getFacilities(cityModel);

	}

	@PostMapping(value = "/floor")
	public List<FloorModel> getFloor(@RequestBody FacilityModel facilityModel) {
		return floorDropdownService.getFloor(facilityModel);
	}
	/*
	 * @PostMapping(value = "/floorMap") public Iterable<FloorMapDetailsModel>
	 * getFloorMap(@RequestBody FloorModel floorModel) { return
	 * floorMapOccupationDetailsService.getMapDetails(floorModel); }
	 */

	@PostMapping(value = "/floorMap/{floorId}")
	public Iterable<FloorMapDetailsModel> getFloorMap(@PathVariable String floorId) {
		return floorMapOccupationDetailsService.getMapDetails(floorId);
	}
	
	@PostMapping(value="/spaceSearch")
	public SwapModel getData(@RequestBody SwapModel swapModel){
		return swapDetailsService.getData(swapModel);
	}

}
