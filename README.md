### micronaut-openapi kotlin suspend issue

The generated swagger spec for kotlin suspend functions is missing response type -
always generated as Object

#### To recreate

Clone this repo then

```$bash
cd complete
./gradlew clean build run
```

and go to http://localhost:8080/swagger/hello-world-0.0.yml

##### Expected result

Responses type of both suspend and non-suspend function should be Name

```
openapi: 3.0.1
info:
  title: Hello World
  description: Demonstrate suspend functions not recognising return type
  contact:
    name: name
    url: url
    email: email
  license:
    name: Apache 2.0
    url: http://foo.bar
  version: "0.0"
paths:
  /hello/{name}:
    get:
      operationId: hello
      parameters:
      - name: name
        in: path
        required: true
        schema:
          type: string
      responses:
        default:
          description: hello default response
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Name'
  /hello/suspend/{name}:
    get:
      operationId: helloSuspend
      parameters:
      - name: name
        in: path
        required: true
        schema:
          type: string
      responses:
        default:
          description: helloSuspend default response
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Name'
components:
  schemas:
    Name:
      type: object
      properties:
        firstName:
          type: string
        lastName:
          type: string
```

##### Actual result

Responses type of suspend function is Object, not Name

```
openapi: 3.0.1
info:
  title: Hello World
  description: Demonstrate suspend functions not recognising return type
  contact:
    name: name
    url: url
    email: email
  license:
    name: Apache 2.0
    url: http://foo.bar
  version: "0.0"
paths:
  /hello/{name}:
    get:
      operationId: hello
      parameters:
      - name: name
        in: path
        required: true
        schema:
          type: string
      responses:
        default:
          description: hello default response
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Name'
  /hello/suspend/{name}:
    get:
      operationId: helloSuspend
      parameters:
      - name: name
        in: path
        required: true
        schema:
          type: string
      responses:
        default:
          description: helloSuspend default response
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Object'
components:
  schemas:
    Name:
      type: object
      properties:
        firstName:
          type: string
        lastName:
          type: string
    Object:
      type: object
```
