## Spring Cloud and Microservices exercises/examples

### Microservices vs Monolithic

##### Monolithic challenges
- Multiple clients to the API with different needs have to maintained in a single app (mobile, web, other systems)
- Multiple persistence and back-end technologies maintained in the same system (search, cache, inMemory DB, SQL, NoSQL)
- Multiple features that need to be implemented at the same time in the same system
- Large teams coding, testing, deploying, etc. the same app
- Errors are discovered late in the deploy pipeline (hard to know what caused it having many features being developed together)

##### Monolithic advantages
- Easy to comprehend (although hard to digest)
- Easier to test as a single unit (up to a point)
- Easier to deploy as unit

##### Monolithic drawbacks
- Entire app stuck to a single language/technology (hard to take advantage of some new tech to tackle some specific problem)
- Hard to digest the large code base
- A single team cannot manage the entire app
- Cannot deploy a single change to a single component

##### Microservices
- Architectural style
- Decomposition of a single application into a suite of small services that run independently and communicate via an open protocol
- Each service encapsulates a business capability (rather than using languages constructs as packages and classes)
- Separately written, deployed and maintained

##### Microservices - API Gateway
- Provides an easy to use interface for each client technology (mobile, web, other service)
- Manages the complexity of talking to different services on the server side which is much more efficient (e.g., when a single API request needs info from several services)
- Authentication
- Caching

##### Microservices advantages
- Encapsulation (not made by using language constructs)
- Small, independently deployable applications
- Services evolve separately
- Forces design of clear interfaces (it needs to be flexible/abstract in order to remain decoupled)
- Changes affect only the services that manage that part of the scope
- Not a single code base:
- Can evolve separately
— Can use/experiment different languages/technologies that is best for that part of the job (without affecting the whole system)
- Easy to comprehend, alter, test, version, deploy (i.e., when approached individually)
- Small teams can manage a service (even individuals)
- Flexibility to manage staff (search team, the cart team, the review team)

##### Microservices drawbacks
- Complexity moves from the app level to the operation layer (i.e., communication between system parts happens remotely instead of locally)
- Services may be unavailable (need to be designed for failure)
- Needs much more monitoring
- Remotes call are more expensive than in-processes calls
- No ACID transactions. We must rely on eventual consistency
- Refactoring services may be difficult (e.g., combine two services into one or split one into two)
- If a feature spam multiple servers it get harder to manage changes, deal with dependency/version and the interaction between services (test, manage, etc.)

##### Microservices principles
- Should be tolerant readers (resilient, should no break if a new field appears in the API)
- Consumer driven API (changes affects the consumers)
- Services as choreographed (talk to each other), not orchestrated (SOA)
- Noun-based (Cart, Catalog, Consumer) or Verb-based (Search, Checkout, Shipping)
- Single responsibility principle
- Bounded context