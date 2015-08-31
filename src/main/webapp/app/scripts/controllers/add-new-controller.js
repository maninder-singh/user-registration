/**
 * Created by maninders on 27/8/15.
 */

UserRegistrationApp.AddUserController = Ember.Controller.extend({
    isFormValid : true,
    validAddUserForm : function(){
        var firstName = this.get('firstName');
        var middleName = this.get('middleName');
        var lastName = this.get('lastName');

        if(firstName === undefined || middleName === undefined || lastName === undefined){
            this.set('isFormValid',true);
        }else{
            if(firstName != "" && middleName != "" && lastName != ""){
                this.set('isFormValid',false);
            }else{
                this.set('isFormValid',true);
            }
        }
    }.observes('firstName','middleName','lastName'),
    actions : {
        addNewUser : function(){
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
                },
                error: function (jqXHR, textStatus, errorThrown){
                    console.log("error");
                },
                dataType: "json"
            });
            this.transitionToRoute('get-all-users');
            this.set('firstName',"");
            this.set('middleName',"");
            this.set('lastName',"");
            this.set('email',"");
            this.set('address',"");
            this.set('city',"");
            this.set('state',"");
            this.set('zip',"");
            this.set('country',"");
        }
    }
});