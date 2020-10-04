# Plan Generator API

In order to inform borrowers about the final repayment schedule, this service pre-calculates repayment plans throughout the lifetime of a loan.

To be able to calculate a repayment plan specific input parameters are necessary:
- duration (number of installments in months)
- nominal rate (annual interest rate)
- loan amount (principal amount)
- Date of Disbursement/Payout ("startDate")

## Run
You may execute this application locally by executing the below command
> mvn exec:java  

## Usage
#### Endpoint
POST http://localhost:8001/generate-plan

#### Request 
##### Payload:
```
{
 "loanAmount": "5000",
 "nominalRate": "5.0",
 "duration": 24,
 "startDate": "2018-01-01T00:00:01Z"
 }
```
#### Response 
##### Payload:
```
{
    "borrowerPayments":[
        {
        "borrowerPaymentAmount":"219.36",
        "date":"2018-01-01T00:00:00Z",
        "initialOutstandingPrincipal":"5000.00",
        "interest":"20.83",
        "principal":"198.53",
        "remainingOutstandingPrincipal":"4801.47"
        },
        {
        "borrowerPaymentAmount":"219.36",
        "date":"2018-02-01T00:00:00Z",
        "initialOutstandingPrincipal":"4801.47",
        "interest":"20.01",
        "principal":"199.35",
        "remainingOutstandingPrincipal":"4602.12"
        },
        ...
        {
        "borrowerPaymentAmount":"219.28",
        "date":"2019-12-01T00:00:00Z",
        "initialOutstandingPrincipal":"218.37",
        "interest":"0.91",
        "principal":"218.37",
        "remainingOutstandingPrincipal":"0"
        }
    ]
}
```