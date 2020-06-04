<?php
$con = mysqli_connect("192.168.1.241","rog","fzzfvvsp.5293","freedomtech");
$usuario = $_GET['usuario'];
 
$sql = "select * from usuarios where usuario like '%$usuario%'";
 
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
	array_push($result,array(
    	'usuario'=>$row[1],
    	'email'=>$row[2],
    	'contrasena'=>$row[3],
	));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>