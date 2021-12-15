<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
<style>
#fieldreg{
position:absolute;
width:500px;
top:190px;
border-color:blue;
left:200px;
}
input{
height:30px;
position:relative;
margin-left:40px;
}
legend{
font-size:30px;
color:blue;
}
button{
height:30px;
position:relative;
left:150px;
}
#rolereg{
position:relative;
left : 70px;
}
#cnfpassid{
position:relative;
left:-20px;
}
#reglab{
    font-size :20px;
    position: relative;
    top: -180px;
    left:150px;
    color:blue;
    visibility: hidden;
}

</style>
</head>
<body bgcolor = "grey">
<fieldset id = "fieldreg">
<legend>Register User</legend>

<form action = "registersucc" method = "post" id = "regform" onsubmit = "return cnfpass()">
<label>Enter Username : </label><input type = "text" name = "userreg" placeholder = "Abcd9" pattern = "[A-Z][a-zA-Z]{3,20}" title = "Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character" id = "userid" required><br><br><br>
<label>Enter Password : </label><input type = "password" name = "passreg" placeholder = "abcd@89" pattern = "[A-Za-z0-9_@/!#$%^&*|\]{6,}" title = "minimum 6 character and special characters allowed" id = "passid" required><br><br><br>
<label>Confirm Password : </label><input type = "password" name = "passreg" placeholder = "abcd@89" pattern = "[A-Za-z0-9_@/!#$%^&*|\]{6,}" title = "minimum 6 character and special characters allowed" id = "cnfpassid" required><br><br><br>
<label>Role : </label><input type = "text" name = "rolereg"id = "rolereg" placeholder = "user,admin" pattern = "[a-z]{,5}" title = "use a-z for role" required><br><br><br>
<label id = "reglab" >Password Must Be Same</label>
<button id = "regbt" type = "submit">Register</button>&ensp;&ensp;&ensp;&ensp;<button id = "resbt" type = "reset">Reset</button>
</form>
</fieldset>
</body>
<script>
let pass1 = document.getElementById("passid");
let pass2 = document.getElementById("cnfpassid");
let reglab = document.getElementById("reglab");
function cnfpass(){
if(pass1.value != pass2.value){
pass1.style.borderBlockColor = "red";
pass2.style.borderBlockColor = "red";
reglab.style.visibility = "visible";
return false;
}
return true;
}
</script>
</html>