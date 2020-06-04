<?php 
		$con=mysqli_connect("192.168.1.241","rog","fzzfvvsp.5293","freedomtech");
			
		$usuario = $_POST["usuario"];
		$contrasena = $_POST["contrasena"];

		$sql = "SELECT * FROM usuarios WHERE usuario = '$usuario' AND contrasena = '$contrasena'";
		$result = mysqli_query($con,$sql);
		
		if($result->num_rows > 0){
			echo "Autenticacion correcta" ;
		}else{
  			 echo "Usuario o contraseña incorrecto";
}
?>