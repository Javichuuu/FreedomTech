<?php 
	$con=mysqli_connect("192.168.1.241","rog","fzzfvvsp.5293","freedomtech");
	
	$usuario = $_POST["usuario"];
	$email = $_POST["email"];
	$contrasena =$_POST["contrasena"];

	$sql = "INSERT INTO usuarios(usuario,email,contrasena) VALUES ('$usuario','$email','$contrasena')";
	$result = mysqli_query( $con,$sql );
	
	if($result) {
		echo "Registrado";
	}
	else {
		echo "Ha ocurrido un error";
	}
?>