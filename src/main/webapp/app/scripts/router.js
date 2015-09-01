UserRegistrationApp.Router.map(function () {

    this.route("add-user" , {path : "/add-user"});
    this.route("update-user" , {path : "/update-user/:user"});
    this.route("get-user",{path : "/get-user/:userId"});
    this.route("get-all-users");
});