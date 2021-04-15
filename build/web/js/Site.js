
//----------AddRequest-----------
function validateAddRequest() {
    var valid = true;

    //Validate the name field
    //if (document.getElementById("name").value.length == 0)
    if (document.getElementById("fname").value.search(/^[A-Za-z'\-\._ ]{2,}$/) != 0) {
        valid = false;
        document.getElementById("errName").innerHTML = "ERROR: Name is mandatory and should be at least TWO characters !";
        document.getElementById("errName").style.display = "inline";
    } else {
        document.getElementById("errName").innerHTML = "";
        document.getElementById("errName").style.display = "none";
    }
    //Validate the phone field
    if (document.getElementById("ComputerNumber").value == "")        
    {
        valid = false;
        document.getElementById("errCoputerSerialNumber").innerHTML = "ERROR: Please write your Computer Serial Number!";
        document.getElementById("errCoputerSerialNumber").style.display = "inline";
    }
    else {
        document.getElementById("errCoputerSerialNumber").innerHTML = "";
        document.getElementById("errCoputerSerialNumber").style.display = "none";
    }
    //validate the type: 
    if (document.getElementById("typeOfDevice").value == "Please select your device...") {
        valid = false;
        document.getElementById("errType").innerHTML = "ERROR : You forgot to select your device type!";
        document.getElementById("errType").style.display = "inline";
    } else {
        document.getElementById("errType").innerHTML = "";
        document.getElementById("errType").style.display = "none";
    }
    //validate the model 
    if (document.getElementById("model").value == "") {
        valid = false;
        document.getElementById("errModel").innerHTML = "ERROR: Please your must enter your model!";
        document.getElementById("errModel").style.display = "inline";
    } else {
        document.getElementById("errModel").innerHTML = "";
        document.getElementById("errModel").style.display = "none";
    }
    //validate the Memory: 
    if (document.getElementById("memoryList").value == "Please select your Memory GB...") {
        valid = false;
        document.getElementById("errMemoryGB").innerHTML = "ERROR : You forget to select Memory GB!";
        document.getElementById("errMemoryGB").style.display = "inline";
    } else {
        document.getElementById("errMemoryGB").innerHTML = "";
        document.getElementById("errMemoryGB").style.display = "none";
    }
    //validate the HardDisk: 
    if (document.getElementById("hardDiskList").value == "Please select your HardDisk GB...") {
        valid = false;
        document.getElementById("errHardDiskGB").innerHTML = "ERROR : You forget to select HardDisk GB!";
        document.getElementById("errHardDiskGB").style.display = "inline";
    } else {
        document.getElementById("errHardDiskGB").innerHTML = "";
        document.getElementById("errHardDiskGB").style.display = "none";
    }
    //Validate the Problem field
    if (document.getElementById("problemstxt").value.search(/^[A-Za-z'\-\._ ]{1,140}$/) != 0) {
        valid = false;
        document.getElementById("errProblems").innerHTML = "ERROR: You must write your Problems to make us able to help you!";
        document.getElementById("errProblems").style.display = "inline";
    } else {
        document.getElementById("errProblems").innerHTML = "";
        document.getElementById("errProblems").style.display = "none";
    }

    if (valid == false) {
        return false;    // don't submit the form data to the server because of any validation error(s)
    } else {
        return true;     // submit the form data to the server because all data looks correct without errors
    }
}
//-----------Feedbadk---------
function validateHelpbox() {
    var valid = true;

    //Validate the name field 
    if (document.getElementById("fname").value.search(/^[A-Za-z'\-\._ ]{2,}$/) != 0) {
        valid = false;
        document.getElementById("errName").innerHTML = "ERROR: Name is mandatory and should be at least Two characters !";
        document.getElementById("errName").style.display = "inline";
    } else {
        document.getElementById("errName").innerHTML = "";
        document.getElementById("errName").style.display = "none";
    }
    //Validate the Country field
    if (document.getElementById("Country").value == "Please select your Country...") {
        valid = false;
        document.getElementById("errCountry").innerHTML = "ERROR: Enter your country please!";
        document.getElementById("errCountry").style.display = "inline";
    } else {
        document.getElementById("errCountry").innerHTML = "";
        document.getElementById("errCountry").style.display = "none";
    }
    //Validate the email field
    if (document.getElementById("email").value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0) {
        valid = false;
        document.getElementById("errEmail").innerHTML = "ERROR: Email is not valid!";
        document.getElementById("errEmail").style.display = "inline";
    }
    else {
        document.getElementById("errEmail").innerHTML = "";
        document.getElementById("errEmail").style.display = "none";
    }
    //Validate the phone field
    if (document.getElementById("phone").value.search(/^(05\d{8}|9665\d{8})$/) != 0)        //e.g.  0512345678  or   966512345678
    {
        valid = false;
        document.getElementById("errPhone").innerHTML = "ERROR: Please enter your number on this format (05xxxxxxxx or 9665xxxxxxxx)!";
        document.getElementById("errPhone").style.display = "inline";
    }
    else {
        document.getElementById("errPhone").innerHTML = "";
        document.getElementById("errPhone").style.display = "none";
    }
    //Validate the  field
    if (document.getElementById("Subjectfeedback").value.search(/^[A-Za-z'\-\._ ]{6,}$/) != 0) {
        valid = false;
        document.getElementById("errSubject").innerHTML = "ERROR: Enter your subject please!";
        document.getElementById("errSubject").style.display = "inline";
    } else {
        document.getElementById("errSubject").innerHTML = "";
        document.getElementById("errSubject").style.display = "none";
    }
    //validate the Type: 
    if (document.getElementById("subject").value == "Please select the Type...") {
        valid = false;
        document.getElementById("errType").innerHTML = "ERROR : You forgot to select the type!";
        document.getElementById("errType").style.display = "inline";
    } else {
        document.getElementById("errType").innerHTML = "";
        document.getElementById("errType").style.display = "none";
    }
    //Validate the Massege field
    if (document.getElementById("msg").value.search(/^[A-Za-z'\-\._ ]{1,140}$/) != 0) {
        valid = false;
        document.getElementById("errMessage").innerHTML = "ERROR: You must write your massege!";
        document.getElementById("errMessage").style.display = "inline";
    } else {
        document.getElementById("errMessage").innerHTML = "";
        document.getElementById("errMessage").style.display = "none";
    }


    if (valid == false) {
        return false;    // don't submit the form data to the server because of any validation error(s)
    } else {
        return true;     // submit the form data to the server because all data looks correct without errors
    }
}
//----------- register validation --------------
function validateRegister()
{
    var valid = true;


    //Validate the name field
    //if (document.getElementById("name").value.length == 0)
    var x = document.getElementById("register_name").value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) == 0;
    if (x == "" || x == null)
    {
        valid = false;
        document.getElementById("errRegisterUsername").innerHTML = "enter a correct email please";
        document.getElementById("errRegisterUsername").style.display = "inline";
    } else
    {

        document.getElementById("errRegisterUsername").innerHTML = "";
        document.getElementById("errRegisterUsername").style.display = "none";
    }


    x = document.getElementById("rigester_fullname").value;
    if (x == "" || x == null)
    {
        valid = false;
        document.getElementById("errRegisterFullname").innerHTML = "enter your fullname please";
        document.getElementById("errRegisterFullname").style.display = "inline";
    } else
    {

        document.getElementById("errRegisterFullname").innerHTML = "";
        document.getElementById("errRegisterFullname").style.display = "none";
    }



    x = document.getElementById("register_password").value;
    if (x == "" || x == null)
    {
        valid = false;
        document.getElementById("errRegisterPassword").innerHTML = "enter your password please";
        document.getElementById("errRegisterPassword").style.display = "inline";
    } else
    {

        document.getElementById("errRegisterPassword").innerHTML = "";
        document.getElementById("errRegisterPassword").style.display = "none";
    }


    x = document.getElementById("register_confpassword").value;
    y = document.getElementById("register_password").value;
    if (x == "" || x == null || x != y)
    {
        valid = false;
        document.getElementById("errRegisterConfPassword").innerHTML = "Both Passwords need to be matched";
        document.getElementById("errRegisterConfPassword").style.display = "inline";
    } else
    {

        document.getElementById("errRegisterConfPassword").innerHTML = "";
        document.getElementById("errRegisterConfPassword").style.display = "none";
    }




    if (valid == false)
    {
        return false;    // don't submit the form data to the server because of any validation error(s)
    } else
    {
        return true;     // submit the form data to the server because all data looks correct without errors
    }
}
//----------------- login validation ----------------
function validateLogin()
{
    var valid = true;
    //Validate the name field
    //if (document.getElementById("name").value.length == 0)
    var x = document.getElementById("login_name").value;
    if (x == "" || x == null)
    {
        valid = false;
        document.getElementById("errLoginName").innerHTML = "enter your name please";
        document.getElementById("errLoginName").style.display = "inline";
    } else
    {

        document.getElementById("errLoginName").innerHTML = "";
        document.getElementById("errLoginName").style.display = "none";
    }



    x = document.getElementById("login_password").value;
    if (x == "" || x == null)
    {
        valid = false;
        document.getElementById("errLoginPassword").innerHTML = "enter your password please";
        document.getElementById("errLoginPassword").style.display = "inline";
    } else
    {

        document.getElementById("errLoginPassword").innerHTML = "";
        document.getElementById("errLoginPassword").style.display = "none";
    }


    if (valid == false)
    {
        return false;    // don't submit the form data to the server because of any validation error(s)
    } else
    {
        return true;     // submit the form data to the server because all data looks correct without errors
    }
}