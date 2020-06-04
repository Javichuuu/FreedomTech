<?php
$con = mysqli_connect("192.168.1.241","rog","fzzfvvsp.5293","freedomtech");
$usuario = $_GET['usuario'];
 
$sql = "select * from piezas_pc where usuario like '%$usuario%'";
 
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
	array_push($result,array(
    	
		'descripcion_pc' =>$row[2],
    	'procesador' =>$row[3],
		'procesador_precio'=>$row[4],
		'placa_base'=>$row[5],
		'placa_base_precio'=>$row[6],
		'memoria_ram'=>$row[7],
		'memoria_ram_precio'=>$row[8],
		'kit_placa_procesador_ram'=>$row[9],
		'kit_precio'=>$row[10],
		'disco_duro_ssd'=>$row[11],
		'dd_ssd_precio'=>$row[12],
		'disco_duro_ssd_2'=>$row[13],
		'dd_ssd2_precio'=>$row[14],
		'disco_duro_hdd'=>$row[15],
		'dd_hdd_precio'=>$row[16],
		'disco_duro_hdd_2'=>$row[17],
		'dd_hdd2_precio'=>$row[18],
		'fuente_alimentacion'=>$row[19],
		'fuente_alim_precio'=>$row[20],
		'torre_caja'=>$row[21],
		'torre_caja_precio'=>$row[22],
		'refrigeracion'=>$row[23],
		'refrigeracion_precio'=>$row[24],
		'tarjeta_grafica'=>$row[25],
		'tarjeta_grafica_precio'=>$row[26],
		'tarjeta_red'=>$row[27],
		'tarjeta_red_precio'=>$row[28],
		'monitor'=>$row[29],
		'monitor_precio'=>$row[30],
		'teclado'=>$row[31],
		'teclado_precio'=>$row[32],
		'raton'=>$row[33],
		'raton_precio'=>$row[34],
		'cascos'=>$row[35],
		'cascos_precio'=>$row[36],
		'otros'=>$row[37],
		'otros_precio'=>$row[38],
		'precio_total'=>$row[39],
    	
	));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>