package sri.nl.sample.service

import java.net.URI
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import sri.nl.sample.model.Response

@Service
class SampleService {

    //fun getData() : Response = RestTemplate().getForEntity(URI("http://localhost:8081/backend"), Response::class.java).body ?: Response()
    fun getData() : Response = RestTemplate().exchange(RequestEntity(null, null, HttpMethod.GET, URI("http://localhost:8081/backend")), Response::class.java).body ?: Response()

}