/**
 * This GetUserRoute class have functionality to get user details for user id 
 * by asynchronous call to server
 * 
 * @author maninders
 * @class GetUserRoute
 * @module UserRegistration
 * @submodule GetUser
 */
UserRegistrationApp.GetUserRoute = Ember.Route.extend({
	/**
	 * This method is to get user details from server by 
	 * asynchronous ajax call for given user id.
	 * @method getUser
	 * @param  params - Json Object
	 * @return User Object
	 */
    model : function(params){
       var url = UserRegistrationApp.BaseUrl + "registration/get-user/" + params.userId;
       return Ember.$.getJSON(url).then(function (response) {
           if(response.hasOwnProperty("status") && response["status"] === "ok"){
               var user = UserRegistrationApp.User.create({
                   userId : response.data["userId"],
                   firstName : response.data["firstName"],
                   middleName : response.data["middleName"],
                   lastName : response.data["lastName"],
                   city : response.data["city"],
                   address : response.data["address"],
                   state : response.data["state"],
                   country : response.data["country"],
                   zip : response.data["zip"],
                   email : response.data["email"]
               });
               return user;
           }
       });
    }
});

/**
 * This GetAllUsersRoute class have functionality to get all user details  
 * by asynchronous call to server 
 * @author maninders
 * @class GetUserRoute
 * @module UserRegistration
 * @submodule GetUser
 */
UserRegistrationApp.GetAllUsersRoute = Ember.Route.extend({
	/**
	 * This method is to get all user details from server by 
	 * asynchronous ajax call .
	 * @method getAllUsers
	 * @return User List
	 */
   model : function(){
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