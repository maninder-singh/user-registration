UserRegistrationApp = Ember.Application.create();


// Dummy Data

UserRegistrationApp.DummyUserData = [
    {userId : 1 , firstName : "maninder" , middleName : "",lastName : "singh"},
    {userId : 2 , firstName : "bhuvneshwar" , middleName : "",lastName : "sharma"},
    {userId : 3 , firstName : "ashok" , middleName : "",lastName : "c"}
];

// Root api Url
UserRegistrationApp.BaseUrl = "http://localhost:8080/user-registration/rest/";