/**
 * Created by maninders on 27/8/15.
 */

UserRegistrationApp.AddUserController = Ember.Controller.extend({
    isFormValid : true,
    validAddUserForm : function(){
        this.set("errors","");
    }.observes('firstName','middleName','lastName','email','city','address','state','zip','country'),
    actions : {
        addNewUser : function(){

            if(!UserRegistrationApp.validateForm(this))
                return;
            var self = this;
            var user = {};
            user["firstName"] = this.get('firstName');
            user["middleName"] = this.get('middleName');
            user["lastName"] = this.get('lastName');
            user["email"] = this.get("email");
            user["address"] = this.get("address");
            user["city"] = this.get("city");
            user["state"] = this.get("state");
            user["zip"] = this.get("zip");
            user["country"] = this.get("country");

            var url = UserRegistrationApp.BaseUrl + "registration/add-user";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(user),
                contentType:"application/json; charset=utf-8",
                success: function(data){
                    console.log("success");
                    self.transitionToRoute('get-all-users');
                    self.set('firstName',"");
                    self.set('middleName',"");
                    self.set('lastName',"");
                    self.set('email',"");
                    self.set('address',"");
                    self.set('city',"");
                    self.set('state',"");
                    self.set('zip',"");
                    self.set('country',"");
                },
                error: function (jqXHR, textStatus, errorThrown){
                    console.log("error");
                },
                dataType: "json"
            });
        }
    }
});