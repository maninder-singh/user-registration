YUI.add("yuidoc-meta", function(Y) {
   Y.YUIDoc = { meta: {
    "classes": [
        "AddUserController",
        "AddUserRoute",
        "GetUserRoute",
        "User",
        "ValidateForm"
    ],
    "modules": [
        "AddUser",
        "GetUser",
        "UserRegistration"
    ],
    "allModules": [
        {
            "displayName": "AddUser",
            "name": "AddUser",
            "description": "This controller class have functionality to validate user registration form \nand register new user"
        },
        {
            "displayName": "GetUser",
            "name": "GetUser",
            "description": "This GetAllUsersRoute class have functionality to get all user details  \nby asynchronous call to server"
        },
        {
            "displayName": "UserRegistration",
            "name": "UserRegistration",
            "description": "This module is having user related attributes."
        }
    ],
    "elements": []
} };
});