package com.housseine.clothes.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.housseine.clothes.entity.Clothes;
import com.housseine.clothes.service.ClothesService;



@RestController()
@RequestMapping("/clothes")
public class ClothesController {
	@Autowired
	ClothesService clothesService;

	@GetMapping("/getall")
	public ResponseEntity<List<Clothes>> getAllClothes() {
		return new ResponseEntity<List<Clothes>>(clothesService.getAllclothess(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Clothes> addClothes(@RequestBody Clothes clothes) {
		return new ResponseEntity<Clothes>(clothesService.addclothes(clothes), HttpStatus.OK);
	}

	@PatchMapping()
	public void updateclothes(@RequestBody Clothes clothes) {
		clothesService.updateclothes(clothes);
	}

	@DeleteMapping("/{id}")
	void deleteclothes(@PathVariable Long id) {
		clothesService.deleteclothes(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Clothes>> getClothesById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Clothes>>(clothesService.getclothesById(id), HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<Clothes>> getClothesByName(@RequestParam("term") String term) {
		return new ResponseEntity<List<Clothes>>(clothesService.getClothesByLabel(term), HttpStatus.OK);
	}
}