/**
 * Created by maninders on 27/8/15.
 */

UserRegistrationApp.AddUserRoute = Ember.Route.extend({
   model : function () {
       return UserRegistrationApp.User.create({
          firstName : "firstName",
          middleName : "middleName",
          lastName : "lastName"
       });
   } 
});
