package sri.nl.sample.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import sri.nl.sample.model.Response
import sri.nl.sample.service.SampleService

@RestController
class SampleController(val sampleService: SampleService) {

    @GetMapping("/get")
    @ResponseBody
    fun get(): ResponseEntity<Response> =  ResponseEntity.ok().body(sampleService.getData())
}