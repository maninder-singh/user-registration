/**
 * This AddUserRoute class to route and load add-user component
 * @author maninders
 * @class AddUserRoute
 * @module UserRegistration
 * @submodule AddUser
 */

UserRegistrationApp.AddUserRoute = Ember.Route.extend({
	/**
	 * This method is created for testing purpose which return default user object.
	 * @method model {setting default user object}
	 * @return User Object
	 */
   model : function () {
       return UserRegistrationApp.User.create({
          firstName : "firstName",
          middleName : "middleName",
          lastName : "lastName"
       });
   } 
});
