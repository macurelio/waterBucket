# Water Jug Challenge API

#Descripción

This API solves the problem of the water bucket challenge, where an exact amount of water must be measured using two buckets of different capacities. The API receives the capacities of the two buckets and the desired amount, and returns the steps needed to get exactly that amount of water.

# Endpoints
 POST /api/waterjug/solve

- Descripción: Solve the water bucket challenge.

To compile
mvn clean install

to run 
mvn spring-boot:run

The local main is http://localhost:8080

For the project test
mvn test


-Request:
  json
  {
    "xCapacity": 3,
    "yCapacity": 5,
    "zAmountWanted": 4
  }

{
  "solution": [
    "Fill bucket X (3, 0)",
    "Transfer from X to Y (0, 3)",
    "Fill bucket X (3, 3)",
    "Transfer from X to Y (1, 5)",
    "Empty bucket Y (1, 0)",
    "Transfer from X to Y (0, 1)",
    "Fill bucket X (3, 1)",
    "Transfer from X to Y (0, 4)",
    "Solved"
  ]
}
