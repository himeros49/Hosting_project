Feature: Hosting Buying Linux

  ######## ADMIN PANEL ###########
  @BuyProductwithbank
  Scenario: Buying Linux Hosting service banking Gateway
    Given Ronald login into Q11 Website
    Then Ronald Choose Linux Hosting Gold Offer plan
    When Ronald open Monthly plan and add it to cart
    And Ronald creates new account
    Then Ronald pay it by bank payment
    And Arthur view Billing
    Then Arthur Approve for product
    And Arthur clicks on invoice
    Then Arthur verifies the invoice


  @BuyProductwithpaypal
  Scenario: Buying Linux Hosting service paypal Gateway
    Given Ginny login into Q11 Website
    Then Ginny Choose Linux Hosting Gold Offer plan
    When Ginny open Monthly plan add it to cart
    And Ginny creates new account
    Then Ginny pay it by paypal payment
    And Snape view Billing
    Then Snape verifies the invoice


  @Adding_Credit_Limit_In_Customer_Account
  Scenario: Customer lending money
    Given Fred register with Q11 Website
    Then Fred open his account and add credit limit
    Then Fred Choose Linux Hosting Gold Offer plan
    When Fred open Monthly plan add it to cart
    And Fred login with his account
    Then Fred pay it by credit payment
    And McGonagall view Billing
    Then McGonagall verifies the invoice


  @Adding_Credit_Balance_in_Customer_Account
  Scenario: Customer Adding Credit into Account
    Given Dobby register with Q11 Website
    Then Dobby open his account and add credit balance
    Then Dobby Choose Linux Hosting Gold Offer plan
    When Dobby open Monthly plan add it to cart
    And Dobby login with his account
    Then Dobby pay it by credit balance
    And Dumbledore view Billing
    Then Dumbledore verifies the invoice


  @Adding_receipt_to_pay_invoice_paid_by_banking_gateway
  Scenario: Buying Linux Hosting service banking Gateway
    Given Justin login into Q11 Website
    Then Justin Choose Linux Hosting Gold Offer plan
    When Justin open Monthly plan and add it to cart
    And Justin creates new account
    Then Justin pay it by bank payment
    And Oliver opens Justin Profile
    Then Oliver added receipt which is paid by Justin
    Then Oliver approves for the product
    And Oliver verifies the invoice
    

  ######## PARTNER PANEL ###########
  @BuyProductwithbank_partnerpanel
  Scenario: Buying Linux Hosting service banking Gateway from Partner panel
    Given Neville login into Q11 partner portal
    Then Neville Choose Linux Hosting Gold Offer plan
    When Neville open Monthly plan and add it to cart
    And Neville creates new account
    Then Neville pay it by bank payment
    And Lockhart view Billing
    Then Lockhart Approve for product
    And Lockhart clicks on invoice
    Then Lockhart verifies the invoice

  @BuyProductwithpaypal_partnerpanel
  Scenario: Buying Linux Hosting service paypal Gateway from Partner panel
    Given Hermione login into Q11 partner portal
    Then Hermione Choose Linux Hosting Gold Offer plan
    When Hermione open Monthly plan add it to cart
    And Hermione creates new account
    Then Hermione pay it by paypal payment
    And Hagrid view Billing
    Then Hagrid verifies the invoice

  @Adding_Credit_Limit_In_Customer_Account_partnerpanel
  Scenario: Customer lending money from partner panel
    Given Susan register with Q11 Website
    Then Susan open his account and add credit limit
    Then Susan Choose Linux Hosting Gold Offer plan
    When Susan open Monthly plan add it to cart
    And Susan login with his account
    Then Susan pay it by credit payment
    And BartyCrouch view Billing
    Then BartyCrouch verifies the invoice

  @Adding_Credit_Balance_in_Customer_Account_partnerpanel
  Scenario: Customer Adding Credit into Account from partner panel
    Given Harry register with Q11 Website
    Then Harry open his account and add credit balance
    Then Harry Choose Linux Hosting Gold Offer plan
    When Harry open Monthly plan add it to cart
    And Harry login with his account
    Then Harry pay it by credit balance
    And Quirrell view Billing
    Then Quirrell verifies the invoice
    
    
    @Adding_receipt_to_pay_invoice_paid_by_banking_gateway_partnerpanel
  Scenario: Buying Linux Hosting service banking Gateway
    Given James login into Q11 Website
    Then James Choose Linux Hosting Gold Offer plan
    When James open Monthly plan and add it to cart
    And James creates new account
    Then James pay it by bank payment
    And William opens Justin Profile
    Then William added receipt which is paid by James
    Then William approves for the product
    And William verifies the invoice

  @Adding_receipt
  Scenario: Adding Recepit to pay invoice
    Given Customer is in his dashboard page
    Then Customer added Receipt
    And Customer verifies the payment by checking invoice
    Then Customer generated invoice with autoRenewable ON
    And Customer generated invoice with autorenewable OFF
    
    
    
 ######## MEMBER PANEL ###########
 	@
  Scenario: 
