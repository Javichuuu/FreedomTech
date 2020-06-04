<?php 
		$con=mysqli_connect("192.168.1.241","rog","fzzfvvsp.5293","freedomtech");
			
		$usuario = $_POST["usuario"];

		$sql = "DELETE FROM piezas_pc WHERE usuario = '$usuario'";
		$result = mysqli_query($con,$sql);
		
		if($result->num_rows > 0){
			echo "No hay presupuesto";
		}else{
  			 echo "Presupuesto borrado";
}
?>