package nl.sri.ksapp.controller

import nl.sri.ksapp.model.Response
import nl.sri.ksapp.service.SampleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(val sampleService: SampleService) {

    @GetMapping("/get")
    @ResponseBody
    fun get(): ResponseEntity<Response> =  ResponseEntity.ok().body(sampleService.getData())
}