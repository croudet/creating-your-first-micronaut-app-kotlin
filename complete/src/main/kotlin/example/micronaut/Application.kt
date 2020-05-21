package example.micronaut

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
        info = Info(
                title = "Hello World",
                version = "0.0",
                description = "Demonstrate suspend functions not recognising return type",
                license = License(name = "Apache 2.0", url = "http://foo.bar"),
                contact = Contact(url = "url", name = "name", email = "email")
        )
)
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("example.micronaut")
                .mainClass(Application.javaClass)
                .start()
    }
}