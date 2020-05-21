package example.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class HelloController {

    @Get("/hello/{name}")
    fun hello(name: String): Name {
        return Name(name, "LastName")
    }

    @Get("/hello/suspend/{name}")
    suspend fun helloSuspend(name: String): Name {
        return Name(name, "LastNameSuspended")
    }
}

data class Name(val firstName: String, val lastName: String)