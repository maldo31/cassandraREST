package com.cassandra.api.controller;

import com.cassandra.api.exceptions.ResourceNotFoundException;
import com.cassandra.api.model.Wildfire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cassandra.api.repository.WildfireRepository;

import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/api")
public class WildfireController {

    @Autowired
    WildfireRepository wildfireRepository;

    @PostMapping("/wildfires")
    public ResponseEntity<Wildfire>  addWildfire(@RequestBody Wildfire wildfire2) {
        Integer id = new Random().nextInt();
        Wildfire new_wildfire = new Wildfire(id, wildfire2.getCounty(), wildfire2.getDistrict(),
                wildfire2.getFire_name(),wildfire2.getFire_year(),wildfire2.getFuel_descr(),wildfire2.getFuel_model(),
                wildfire2.getGeneral_cause(),wildfire2.getReport_date(),wildfire2.getTotal_acres(),wildfire2.getUnit());
        wildfireRepository.save(new_wildfire);
        return ResponseEntity.ok().body(new_wildfire);
    }

    @GetMapping("/wildfires/{id}")
    public  ResponseEntity<Wildfire> findById(@PathVariable("id") Integer id) {
        Wildfire wildfire = wildfireRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Fire not found " + id));
        return ResponseEntity.ok().body(wildfire);
    }

    @GetMapping("wildfires")
    public List<Wildfire> getWildfires(){
        return wildfireRepository.findAll();
    }

    @PutMapping("/wildfires/{id}")
    public ResponseEntity<Wildfire> updateWildfire(@PathVariable(value = "id") Integer id,
                                                   @RequestBody Wildfire wildfireDetails) {
        Wildfire wildfire = wildfireRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No fire found for this id :: " + id));
        wildfire.setCounty(wildfireDetails.getCounty());
        final Wildfire updatedWildfire = wildfireRepository.save(wildfire);
        return  ResponseEntity.ok(updatedWildfire);
    }

    @DeleteMapping("/wildfires/{id}")
    public ResponseEntity<Void> deleteWildfire(@PathVariable(value = "id") Integer id) {
        Wildfire wildfire = wildfireRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product not found::: " + id));
        wildfireRepository.delete(wildfire);
        return ResponseEntity.ok().build();
    }

//    @PutMapping("/wildfires/{id}")
//    public ResponseEntity<Wildfire> updateWildfire(@PathVariable("id") Integer id, @RequestBody Wildfire wildfire) {
//        Optional<Wildfire> wildfireData = wildfireRepository.findById(id);
//
//        if (wildfireData.isPresent()){
//            Wildfire _wildfire = wildfireData.get();
//            _wildfire.setFire_name(wildfire.getFire_name());
//            _wildfire.setCounty(wildfire.getCounty());
//            _wildfire.setDistrict(wildfire.getDistrict());
//            _wildfire.setFire_year(wildfire.getFire_year());
//            _wildfire.setFuel_descr(wildfire.getFuel_descr());
//            _wildfire.setTotal_acres(wildfire.getTotal_acres());
//            _wildfire.setReport_date(wildfire.getReport_date());
//            _wildfire.setGeneral_cause(wildfire.getGeneral_cause());
//            _wildfire.setUnit(wildfire.getUnit());
//            return new ResponseEntity<>(wildfireRepository.save(_wildfire),HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/wildfires/{id}")
//    public ResponseEntity<HttpStatus> deleteWildfire(@PathVariable("id") Integer id) {
//        try {
//            wildfireRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
//
//    @DeleteMapping("/wildfires")
//    public ResponseEntity<HttpStatus> deleteAllWildfires() {
//        try {
//            wildfireRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
}
