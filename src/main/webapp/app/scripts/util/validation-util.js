
UserRegistrationApp.validateForm = function(obj){

    var emailPattern = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    var zipPattern = /(^\d{6}$)|(^\d{3}-\d{3}$)/;
    var firstName = obj.get('firstName');
    var lastName = obj.get('lastName');
    var email = obj.get("email");
    var zip = obj.get("zip");
    var fieldName = "";

    if (firstName == undefined || firstName.length==0)
        fieldName = "First Name";
    else if (lastName == undefined || lastName.length==0)
        fieldName = "Last Name";
    else if (email == undefined || email.length==0)
        fieldName = "Email";

    if(fieldName!="") {
        obj.set("errors", "Please Enter "+fieldName);
        return false;
    }

    if(!emailPattern.test(email)){
        obj.set("errors", "Please enter valid email");
        return false;
    }

    if(!zipPattern.test(zip)){
        obj.set("errors", "Please enter valid zip");
        return false;
    }

    return true;
};