Feature: Hosting Buying Linux

  ######## ADMIN PANEL ###########
  @BuyProductwithbank
  Scenario: Buying Linux Hosting service banking Gateway from Admin Panel
    Given Ronald login into Q11 Website
    Then Ronald Choose Linux Hosting Gold Offer plan
    When Ronald open Monthly plan and add it to cart
    And Ronald creates new account
    Then Ronald pay it by bank payment
    And Arthur view Billing
    Then Arthur Approve for product
    And Arthur clicks on invoice
    Then Arthur verifies the invoice
    And Arthur opens Ronald profile
    Then Arthur verifies the log and emails

  @BuyProductwithpaypal
  Scenario: Buying Linux Hosting service paypal Gateway from Admin Panel
    Given Ginny login into Q11 Website
    Then Ginny Choose Linux Hosting Gold Offer plan
    When Ginny open Monthly plan add it to cart
    And Ginny creates new account
    Then Ginny pay it by paypal payment
    And Snape view Billing
    Then Snape verifies the invoice

  @Adding_Credit_Limit_In_Customer_Account
  Scenario: Customer lending money from Admin Panel
    Given Fred register with Q11 Website
    Then Fred open his account and add credit limit
    Then Fred Choose Linux Hosting Gold Offer plan
    When Fred open Monthly plan add it to cart
    And Fred login with his account
    Then Fred pay it by credit payment
    And McGonagall view Billing
    Then McGonagall verifies the invoice

  @Adding_Credit_Balance_in_Customer_Account_and_verify_Ledger
  Scenario: Customer Adding Credit into Account and verifying ledger from Admin Panel
    Given Dobby register with Q11 Website
    Then Dobby open his account and add credit balance
    Then Dobby Choose Linux Hosting Gold Offer plan
    When Dobby open Monthly plan add it to cart
    And Dobby login with his account
    Then Dobby pay it by credit balance
    And Dumbledore view Billing
    Then Dumbledore verifies the invoice
    And Dumbledore checks the remaining credit balance

  @Adding_receipt_to_pay_invoice_paid_by_banking_gateway
  Scenario: Adding receipt to pay due purchase from Admin Panel
    Given Justin login into Q11 Website
    Then Justin Choose Linux Hosting Gold Offer plan
    When Justin open Monthly plan and add it to cart
    And Justin creates new account
    Then Justin pay it by bank payment
    And Oliver opens Justin Profile
    Then Oliver added receipt which is paid by Justin
    Then Oliver approves for the product
    And Oliver verifies the invoice

  @Generate_Invoice_Renewal_with_autorenewal_off
  Scenario: Generating Invoice for when AutoRenewal service is off from Admin Panel
    Given Joseph login into Q11 Website
    Then Joseph Choose Linux Hosting Gold Offer plan
    When Joseph open Monthly plan add it to cart
    And Joseph creates new account
    Then Joseph pay it by paypal payment
    And Leo opens Joseph Profile
    Then Leo turns off Joseph auto renewal service off
    And Leo generates invoice
    Then Leo verifies the invoice
    And Leo adds receipt
    Then Leo again verifies the invoice

  @Generate_Invoice_Renewal_with_autorenewal_on
  Scenario: Generating Invoice for when AutoRenewal service is on from Admin Panel
    Given Robert login into Q11 Website
    Then Robert Choose Linux Hosting Gold Offer plan
    When Robert open Monthly plan add it to cart
    And Robert creates new account
    Then Robert pay it by paypal payment
    And Victor opens Robert Profile
    Then Victor turns off Robert auto renewal service on
    And Victor generates invoice
    Then Victor verifies the invoice
    And Victor adds receipt
    Then Victor again verifies the invoice

  @create_addon
  Scenario: Buying Addon Service after purchase from Admin Panel
    Given Mario login into Q11 Website
    Then Mario Choose Linux Hosting Gold Offer plan
    When Mario open Monthly plan add it to cart
    And Mario creates new account
    Then Mario pay it by paypal payment
    And Luigi opens Mario Profile
    Then Luigi adds Addons to Mario subscription plan
    And Luigi verifies generated Order
    And Luigi adds receipt
    Then Luigi approves for the product

  @3rd_module_settings
  Scenario: Buying Linux Hosting service paypal Gateway with 3rd Module setting from Admin Panel
    Given Jasper login into Q11 Website
    Then Jasper Choose Linux Hosting Gold Offer plan
    When Jasper open Monthly plan add it to cart
    And Jasper creates new account
    Then Jasper pay it by paypal payment
    And Casper view Billing
    Then Casper Approve for product
    And Casper clicks on invoice
    Then Casper verifies the invoice

  @SubContact
  Scenario: Customer is adding SubContact and Ordering from Admin Panel
    Given Louis login into Q11 Website
    Then Louis register his account
    And Louis creates SubContact
    Then Louis Choose Linux Hosting Gold Offer plan
    When Louis open Monthly plan add it to cart
    And Louis login with the SubContact account
    Then Louis pay it by paypal
    And Brian view Billing
    Then Brian verifies the invoice

  @Cancel_Whole_order
  Scenario: Cancelling Whole Order from Admin Panel
    Given Shawn login into Q11 Website
    Then Shawn Choose Linux Hosting Gold Offer plan
    When Shawn open Monthly plan and add it to cart
    And Shawn creates new account
    Then Shawn pay it by paypal payment
    And Lucca view order
    Then Lucca cancels the whole order
    And Lucca verifies the invoice

  @Custom_invoice
  Scenario: Generating Custom Invoices from Admin Panel
    Given Francis login into Q11 Website
    Then Francis Choose Linux Hosting Gold Offer plan
    When Francis open Monthly plan and add it to cart
    And Francis creates new account
    Then Francis pay it by paypal payment
    And Hank opens Francis Profile
    Then Hank Generates custom invoice
    And Hank verifies the invoice

  @test
  Scenario: this for test purpose
    Given is it working

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
    And Lockhart opens Ronald profile
    Then Lockhart verifies the log and emails

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
    Given Susan login into Q11 partner portal
    Then Susan open his account and add credit limit
    Then Susan Choose Linux Hosting Gold Offer plan
    When Susan open Monthly plan add it to cart
    And Susan login with his account
    Then Susan pay it by credit payment
    And BartyCrouch view Billing
    Then BartyCrouch verifies the invoice

  @Adding_Credit_Balance_in_Customer_Account_and_verify_Ledger_partnerpanel
  Scenario: Customer Adding Credit into Account from partner panel
    Given Harry login into Q11 partner portal
    Then Harry open his account and add credit balance
    Then Harry Choose Linux Hosting Gold Offer plan
    When Harry open Monthly plan add it to cart
    And Harry login with his account
    Then Harry pay it by credit balance
    And Quirrell view Billing
    Then Quirrell verifies the invoice
    And Quirrell checks the remaining credit balance

  @Adding_receipt_to_pay_invoice_paid_by_banking_gateway_partnerpanel
  Scenario: Buying Linux Hosting service banking Gateway from partner panel
    Given James login into Q11 partner portal
    Then James Choose Linux Hosting Gold Offer plan
    When James open Monthly plan and add it to cart
    And James creates new account
    Then James pay it by bank payment
    And William opens Justin Profile
    Then William added receipt which is paid by James
    Then William approves for the product
    And William verifies the invoice

  @Generate_Invoice_Renewal_with_autorenewal_off_partnerpanel
  Scenario: Generating Invoice for when AutoRenewal service is off from partner panel
    Given Logan login into Q11 partner portal
    Then Logan Choose Linux Hosting Gold Offer plan
    When Logan open Monthly plan add it to cart
    And Logan creates new account
    Then Logan pay it by paypal payment
    And Jackson opens Joseph Profile
    Then Jackson turns off Logan auto renewal service off
    And Jackson generates invoice
    Then Jackson verifies the invoice
    And Jackson adds receipt
    Then Jackson again verifies the invoice

  @Generate_Invoice_Renewal_with_autorenewal_on_partnerpanel
  Scenario: Generating Invoice for when AutoRenewal service is on from partner panel
    Given Luke login into Q11 partner portal
    Then Luke Choose Linux Hosting Gold Offer plan
    When Luke open Monthly plan add it to cart
    And Luke creates new account
    Then Luke pay it by paypal payment
    And Isaac opens Robert Profile
    Then Isaac turns off Luke auto renewal service on
    And Isaac generates invoice
    Then Isaac verifies the invoice
    And Isaac adds receipt
    Then Isaac again verifies the invoice

  @create_addon_partnerpanel
  Scenario: Buying Addon Service after purchase from partner panel
    Given Thomas login into Q11 partner portal
    Then Thomas Choose Linux Hosting Gold Offer plan
    When Thomas open Monthly plan add it to cart
    And Thomas creates new account
    Then Thomas pay it by paypal payment
    And Charles opens Thomas Profile
    Then Charles adds Addons to Thomas subscription plan
    And Charles verifies generated Order
    And Charles adds receipt
    Then Charles approves for the product

  ##TODO
  #@3rd_module_settings_partnerpanel
  #Scenario: Buying Linux Hosting service paypal Gateway with 3rd Module setting
  #Given Calvin login into Q11 Website
  #Then Calvin Choose Linux Hosting Gold Offer plan
  #When Calvin open Monthly plan add it to cart
  #And Calvin creates new account
  #Then Calvin pay it by paypal payment
  #And Max view Billing
  #Then Max Approve for product
  #And Max clicks on invoice
  #Then Max verifies the invoice
  
  @SubContact_partnerpanel
  Scenario: Customer is adding SubContact and Ordering from partner panel
    Given Kane login into Q11 partner portal
    Then Kane register his account
    And Kane creates SubContact
    Then Kane Choose Linux Hosting Gold Offer plan
    When Kane open Monthly plan add it to cart
    And Kane login with the SubContact account
    Then Kane pay it by paypal
    And Wade view Billing
    Then Wade verifies the invoice

  @Cancel_Whole_order_partnerpanel
  Scenario: Cancelling Whole Order from partner panel
    Given Jerry login into Q11 Website
    Then Jerry Choose Linux Hosting Gold Offer plan
    When Jerry open Monthly plan and add it to cart
    And Jerry creates new account
    Then Jerry pay it by paypal payment
    And Tom view order
    Then Tom cancels the whole order
    And Tom verifies the invoice

  @Custom_invoice_partnerpanel
  Scenario: Generating Custom Invoices from partner panel
    Given Dennis login into dQ11 Website
    Then Dennis Choose Linux Hosting Gold Offer plan
    When Dennis open Monthly plan and add it to cart
    And Dennis creates new account
    Then Dennis pay it by paypal payment
    And Cason opens Francis Profile
    Then Cason Generates custom invoice
    And Cason verifies the invoice

  ######## MEMBER PANEL ###########
  @Renew_service_with_autorenewal_on_member_panel
  Scenario: Renew Service when autorenewable is on
    Given Marlin buys the monthly plan of Hosting
    Then Marlin creates her account
    And Marlin pays from paypal gateway
    Then Marlin login into her account
    Then Marlin view her subscription
    And Marlin turns ON renewal service
    Then Marlin Renew her services
    And Marlin again pay for the service from Paypal
    Then Marlin verfies the invoice

  @Renew_service_with_autorenewal_off_member_panel
  Scenario: Renew Service when autorenewable is off
    Given Virgo buys the monthly plan of Hosting
    Then Virgo creates her account
    And Virgo pays from paypal gateway
    Then Virgo login into her account
    Then Virgo view her subscription
    And Virgo turns OFF renewal service
    Then Virgo Renew her services
    And Virgo again pay for the service from Paypal
    Then Virgo verfies the invoice

  @Term_upgrade_member_panel
  Scenario: Updating the Current service plan
    Given Dipper login into her account
    Then Dipper view his subscription
    And Dipper update his subscription
    Then Dipper checks his plan

  @Order_payment_member_panel
  Scenario: Invoice Due payment
    Given Alice buys the monthly plan of Hosting
    Then Alice creates her account
    And Alice pays from bank gateway
    Then Alice order get reviewed from Admin Panel
    Then Alice login into her account in memeber panel
    And Alice pays the due amount
    Then Alice verifies the invoice

  @Invoice_payment_member_panel
  Scenario: Invoice Due payment
    Given Helly buys the monthly plan of Hosting
    Then Helly creates her account
    And Helly pays from bank gateway
    Then Helly order get approved from Admin Panel
    Then Helly login into her account in memeber panel
    And Helly pays the due amount
    Then Helly verifies the invoice

  @Profile_update_member_panel
  Scenario: Updating profile SubUser
    Given Maxine login into his account
    Then Maxine view his profile
    And Maxine Updates his profile

  @SubUser_member_panel
  Scenario: Adding SubUser
    Given Mabel login into her account
    Then Mabel view his profile
    And Mabel adds subuser Jake
    Then Jake login into Mabel account


######## MEMBER PANEL PARTNER ###########

  @Renew_service_with_autorenewal_on_member_panel_partner
  Scenario: Renew Service when autorenewable is on
    Given Cami buys the monthly plan of Hosting
    Then Cami creates her account
    And Cami pays from paypal gateway
    Then Cami login into her account
    Then Cami view her subscription
    And Cami turns ON renewal service
    Then Cami Renew her services
    And Cami again pay for the service from Paypal
    Then Cami verfies the invoice

  @Renew_service_with_autorenewal_off_member_panel_partner
  Scenario: Renew Service when autorenewable is off
    Given Clara buys the monthly plan of Hosting
    Then Clara creates her account
    And Clara pays from paypal gateway
    Then Clara login into her account
    Then Clara view her subscription
    And Clara turns OFF renewal service
    Then Clara Renew her services
    And Clara again pay for the service from Paypal
    Then Clara verfies the invoice

  @Term_upgrade_member_panel_partner
  Scenario: Updating the Current service plan
    Given Chole login into her account
    Then Chole view his subscription
    And Chole update his subscription
    Then Chole checks his plan

  @Order_payment_member_panel_partner
  Scenario: Invoice Due payment
    Given Noami buys the monthly plan of Hosting
    Then Noami creates her account
    And Noami pays from bank gateway
    Then Noami order get reviewed from Admin Panel
    Then Noami login into her account in memeber panel
    And Noami pays the due amount
    Then Noami verifies the order

  @Invoice_payment_member_panel_partner
  Scenario: Invoice Due payment
    Given Violet buys the monthly plan of Hosting
    Then Violet creates her account
    And Violet pays from bank gateway
    Then Violet order get approved from Admin Panel
    Then Violet login into her account in memeber panel
    And Violet pays the due amount
    Then Violet verifies the invoice

  @Profile_update_member_panel_partner
  Scenario: Updating profile SubUser
    Given Pearl login into his account
    Then Pearl view his profile
    And Pearl Updates his profile

  ######## MANAGE SUBSCRIPTION ADMIN PANEL ###########
  @Suspend_subscription_admin
  Scenario: Suspending subscription
    Given Pluto login into Q11 Website
    And Pluto creates new account
    Then Pluto pay it by paypal payment
    And Mickey view Billing
    And Mickey opens Pluto profile
    Then Mickey Suspends Pluto order

    @Unsuspend_subscription_admin
  Scenario: Unsuspending subscription
    Given Wade login into Q11 Website
    And Wade creates new account
    Then Wade pay it by paypal payment
    And Foster view Billing
    And Foster opens Wade profile
    Then Foster Unsuspends Wade order
    
    @Terminate_subscription_admin
  Scenario: Terminating subscription
    Given June login into Q11 Website
    And June creates new account
    Then June pay it by paypal payment
    And Monty view Billing
    And Monty opens June profile
    Then Monty terminate June order
    
    @Create_subscription_admin
    Scenario: Create subscription
    Given Daniel login into Q11 Website
    And Daniel creates new account
    Then Daniel pay it by paypal payment
    And Oscar view Billing
    And Oscar opens Daniel profile
    Then Oscar Create Daniel order
    

  ######## MANAGE SUBSCRIPTION PARTNER PANEL ###########
  @Suspend_subscription_partner
  Scenario: Suspending subscription
    Given Ash login into Q11 Website
    And Ash creates new account
    Then Ash pay it by paypal payment
    And Asher view Billing
    And Asher opens Ash profile
    Then Asher Suspends Ash order
    
     @Unsuspend_subscription_partner
  Scenario: Unsuspending subscription
    Given Xavier login into Q11 Website
    And Xavier creates new account
    Then Xavier pay it by paypal payment
    And Timber view Billing
    And Timber opens Xavier profile
    Then Timber Suspends Xavier order
    
    
     @Terminate_subscription_partner
  Scenario: Terminating subscription
    Given Axel login into Q11 Website
    And Axel creates new account
    Then Axel pay it by paypal payment
    And Aston view Billing
    And Aston opens Axel profile
    Then Aston Suspends Axel order
    
     @Create_subscription_partner
    Scenario: Create subscription
    Given David login into Q11 Website
    And David creates new account
    Then David pay it by paypal payment
    And Tyler view Billing
    And Tyler opens David profile
    Then Tyler Create David order
