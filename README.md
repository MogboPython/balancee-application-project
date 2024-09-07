# Balancee Project

I built this project for [Balanceè](https://balancee.app/)'s internship [application](https://knotty-attention-bd2.notion.site/Apply-here-67dd0c4a8e9b41a4bbacbe853fe8a3ad) using Spring Boot. It provides a REST API for managing customer rewards and cashback transactions.

## Getting Started
1. [Setup and Running the Project](#setup-and-running-the-project)
2. [API Endpoints](#api-endpoints)
3. [Sample Requests and Responses](#sample-requests-and-responses)

## Setup and Running the Project

### Prerequisites
- Java 11 or higher
- Maven
- MySQL (or your preferred database)

### Steps
1. Clone the repository:
   ```
   git clone https://github.com/MogboPython/balancee-application-project.git
   ```

2. Navigate to the project directory:
   ```
   cd balancee-application-project
   ```

3. Change rename the file`src/main/resources/application.properties.examples` to `src/main/resources/application.properties`

4. Then configure the database connection:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/rewards_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

5. Build the project:
   ```
   mvn clean install
   ```

6. Run the application:
   ```
   mvn spring-boot:run
   ```

The application will start running on `http://localhost:8080`.

## API Endpoints

### Get Customer Balance
- **GET** `/api/rewards/balance/{customer_id}`
  - Retrieves the current balance and total cashback for a customer.
  - Replace `{customer_id}` with the customer's unique identifier.

### Get Transaction History
- **GET** `/api/rewards/history/{customer_id}`
  - Fetches the transaction history for a specific customer.
  - Replace `{customer_id}` with the customer's unique identifier.

All endpoints return a ResponseWrapper object containing a status message and the requested data or error information.

## Sample Requests and Responses

### Get Customer Rewards Balance

Request:
```http
GET /api/rewards/balance/BC_Y86QR
```

Response:
```json
{
    "status": "success",
    "data": {
        "customerId": "BC_Y86QR",
        "totalCashback": 27918.94,
        "currentBalance": 34424.44
    }
}
```

### Get Customer Cashback History

Request:
```http
GET /api/rewards/history/BC_Y86QR
```

Response:
```json
[
    {
        "status": "success",
        "data": [
            {
                "transactionId": "BT_HHGXJ",
                "amountEarned": 430.00,
                "transactionDate": "2024-09-11T10:21:30",
                "customerId": "BC_Y86QR",
                "description": "cashback on phone"
            }
        ]
    },
    {
        "status": "success",
        "data": [
            {
                "transactionId": "BT_HHGXJ",
                "amountEarned": 230.00,
                "transactionDate": "2024-07-10T10:21:30",
                "customerId": "BC_Y86QR",
                "description": "promo"
            }
        ]
    }
]
```

For any issues or feature requests, please open an issue in the GitHub repository.