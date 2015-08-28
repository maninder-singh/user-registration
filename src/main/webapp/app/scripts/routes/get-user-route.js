/**
 * Created by maninders on 27/8/15.
 */

UserRegistrationApp.GetUserRoute = Ember.Route.extend({
    model : function(params){
        return UserRegistrationApp.DummyUserData.findBy('userId',parseInt(params.userId));
    }
});

UserRegistrationApp.GetAllUsersRoute = Ember.Route.extend({
   model : function(){
       //var userList = [];
       //for(var index = 0 ; index < UserRegistrationApp.DummyUserData.length ; index++){
       //     userList.push(UserRegistrationApp.DummyUserData[index]);
       //}
       //return userList;

       var url = UserRegistrationApp.BaseUrl + "registration/get-all-users";
       return Ember.$.getJSON(url).then(function (response) {
           var userList = [];
           if(response.hasOwnProperty("status") && response["status"] === "ok"){
               for(var index = 0 ; index < response.data.length ; index++){
                   var user = UserRegistrationApp.User.create({
                       userId : response.data[index]["userId"],
                       firstName : response.data[index]["firstName"],
                       middleName : response.data[index]["middleName"],
                       lastName : response.data[index]["lastName"],
                       city : response.data[index]["city"],
                       address : response.data[index]["address"],
                       state : response.data[index]["state"],
                       country : response.data[index]["country"],
                       zip : response.data[index]["zip"],
                       email : response.data[index]["email"]
                   });
                   userList.push(user);
               }
               return userList;
           }
       });

       //var xhr = new XMLHttpRequest();
       //if ("withCredentials" in xhr) {
       //    // XHR for Chrome/Firefox/Opera/Safari.
       //    xhr.open('GET', url, true);
       //} else if (typeof XDomainRequest != "undefined") {
       //    // XDomainRequest for IE.
       //    xhr = new XDomainRequest();
       //    xhr.open('GET', url);
       //} else {
       //    // CORS not supported.
       //    xhr = null;
       //}
       //
       //if (!xhr) {
       //    alert('CORS not supported');
       //    return;
       //}
       //
       //// Response handlers.
       //xhr.onload = function() {
       //    var text = xhr.responseText;
       //    alert('Response from CORS request to ');
       //    return UserRegistrationApp.DummyUserData;
       //};
       //
       //xhr.onerror = function() {
       //    alert('Woops, there was an error making the request.');
       //    return UserRegistrationApp.DummyUserData;
       //};
       //
       //xhr.send();
   }
});