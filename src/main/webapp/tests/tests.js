// in order to see the app running inside the QUnit runner
UserRegistrationApp.rootElement = '#ember-testing';

// Common tests setup
UserRegistrationApp.setupForTesting();
UserRegistrationApp.injectTestHelpers();

// common QUnit module declaration
module("Integration tests", {
  setup: function() {
    // before each tests, ensure the application is ready to run.
    Ember.run(UserRegistrationApp, UserRegistrationApp.advanceReadiness);
  },

  teardown: function() {
    // reset the application state between each tests
    UserRegistrationApp.reset();    
  }
});

// QUnit tests case
test("get-all-users template", function() {
  // async helper telling the application to go to the '/' route
  visit("/get-all-users");

  // helper waiting the application is idle before running the callback
  andThen(function() {
    equal(currentRouteName(),"get-all-users","route name is get-all-users");
    equal(currentURL(),"/get-all-users","url is /get-all-users");
  });
});



test("add-user template", function() {
  // async helper telling the application to go to the '/' route
  
  visit("/get-all-users");
  var listOfUser;
  andThen(function(){
      listOfUser = find("table tr").length;
  });
  

  visit("/add-user");

  // helper waiting the application is idle before running the callback
  andThen(function() {
    equal(currentRouteName(),"add-user","route name is add-user");
    equal(currentURL(),"/add-user","url is /add-user");
    
    fillIn('#firstName', "firstName");
    fillIn('#middleName', "middleName");
    fillIn('#lastName', "lastName");
    fillIn('#email', "email@email.com");
    fillIn('#address', "address");
    fillIn('#city', "city");
    fillIn('#state', "state");
    fillIn('#zip', "500034");  
    fillIn('#country', "country");
    click('button.btn-success');
  });

  visit("/get-all-users");

  andThen(function(){
      equal(find("table tr").length,listOfUser + 1,"New user added successfully");
  });
});
