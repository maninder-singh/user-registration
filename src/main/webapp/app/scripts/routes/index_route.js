/**
 * Created by maninders on 27/8/15.
 */

UserRegistrationApp.IndexRoute = Ember.Route.extend({
    afterModel : function(model, transition){
        this.transitionTo('get-all-users');
    }
});