

# Spring Todo Backend




## Sequence diagram

```
                                                    Sequence Diagram                                                    
                                                                                                                        
                                                                                                               ,.-^^-._ 
                                                                                                              |-.____.-|
                                                                                                              |        |
                                 |   ,-.                                                                      |        |
     ┌─────────┐                 +--{   )           ┌────────┐          ┌──────┐          ┌──────────┐        |        |
     │Requester│                 |   `-'            │Services│          │Mapper│          │Repository│        '-.____.-'
     └─────────┘               Controller           └────────┘          └──────┘          └──────────┘           DB     
          │ HTTP Request with DTO  │                    │                  │                   │                 │      
          │  or parameter          │                    │                  │                   │                 │      
          │────────────────────────>                    │                  │                   │                 │      
          │                        │                    │                  │                   │                 │      
          │                        │ Call business logic│                  │                   │                 │      
          │                        │ ───────────────────>                  │                   │                 │      
          │                        │                    │                  │                   │                 │      
          │                        │                    │ Map DTO to Model │                   │                 │      
          │                        │                    │ ─────────────────>                   │                 │      
          │                        │                    │                  │                   │                 │      
          │                        │                    │                  │                   │                 │      
          │                        │                    │ <─ ─ ─ ─ ─ ─ ─ ─ ─                   │                 │      
          │                        │                    │                  │                   │                 │      
          │                        │                    │              Save model              │                 │      
          │                        │                    │ ─────────────────────────────────────>                 │      
          │                        │                    │                  │                   │                 │      
          │                        │                    │                  │                   │    Update DB    │      
          │                        │                    │                  │                   │ ────────────────>      
          │                        │                    │                  │                   │                 │      
          │                        │                    │                  │                   │                 │      
          │                        │                    │                  │                   │ <─ ─ ─ ─ ─ ─ ─ ─       
          │                        │                    │                  │                   │                 │      
          │                        │                    │         Return updated model         │                 │      
          │                        │                    │ <─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─                 │      
          │                        │                    │                  │                   │                 │      
          │                        │                    │ Map model to DTO │                   │                 │      
          │                        │                    │ ─────────────────>                   │                 │      
          │                        │                    │                  │                   │                 │      
          │                        │                    │                  │                   │                 │      
          │                        │                    │ <─ ─ ─ ─ ─ ─ ─ ─ ─                   │                 │      
          │                        │                    │                  │                   │                 │      
          │                        │          Return DTO or param          │                   │                 │      
          │                        │ <─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─                    │                 │      
          │                        │                    │                  │                   │                 │      
          │Return HTTP Request with│                    │                  │                   │                 │      
          │DTO or param            │                    │                  │                   │                 │      
          │<─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─                     │                  │                   │                 │      
     ┌─────────┐               Controller           ┌────────┐          ┌──────┐          ┌──────────┐           DB     
     │Requester│                 |   ,-.            │Services│          │Mapper│          │Repository│         ,.-^^-._ 
     └─────────┘                 +--{   )           └────────┘          └──────┘          └──────────┘        |-.____.-|
                                 |   `-'                                                                      |        |
                                                                                                              |        |
                                                                                                              |        |
                                                                                                              '-.____.-'

```




## Project setup
Project: Maven

Language: Java

Spring Boot: 3.0.4

Packaging: Jar

Java: 17

Dependencies
```
Spring Boot DevTools Developer Tools
	Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
Spring Configuration Processor Developer Tools
	Generate metadata for developers to offer contextual help and "code completion" when working with custom configuration keys (ex.application.properties/.yml files).
Spring Web Web
	Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
Rest Repositories Web
	Exposing Spring Data repositories over REST via Spring Data REST.
Spring Data JPA SQL
	Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
H2 Database SQL
	Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.
Spring Data MongoDB NoSQL
	Store data in flexible, JSON-like documents, meaning fields can vary from document to document and data structure can be changed over time.
Spring REST Docs Testing
	Document RESTful services by combining hand-written with Asciidoctor and auto-generated snippets produced with Spring MVC Test.
```
	
