<?php 
	$con=mysqli_connect("192.168.1.241","rog","fzzfvvsp.5293","freedomtech");
	
	$usuario = $_POST["usuario"];
    $descripcion_pc = $_POST["descripcion_pc"];
    
	$procesador = $_POST["procesador"];
    $procesador_precio = $_POST["procesador_precio"];
    
    $placa_base = $_POST["placa_base"];
    $placa_base_precio = $_POST["placa_base_precio"];

    $memoria_ram = $_POST["memoria_ram"];
    $memoria_ram_precio = $_POST["memoria_ram_precio"];

    $kit_placa_procesador_ram = $_POST["kit_placa_procesador_ram"];
    $kit_precio = $_POST["kit_precio"];

    $disco_duro_ssd = $_POST["disco_duro_ssd"];
    $dd_ssd_precio = $_POST["dd_ssd_precio"];

    $disco_duro_ssd_2 = $_POST["disco_duro_ssd_2"];
    $dd_ssd2_precio = $_POST["dd_ssd2_precio"];

    $disco_duro_hdd = $_POST["disco_duro_hdd"];
    $dd_hdd_precio = $_POST["dd_hdd_precio"];

    $disco_duro_hdd_2 = $_POST["disco_duro_hdd_2"];
    $dd_hdd2_precio = $_POST["dd_hdd2_precio"];

    $fuente_alimentacion = $_POST["fuente_alimentacion"];
    $fuente_alim_precio = $_POST["fuente_alim_precio"];

    $torre_caja = $_POST["torre_caja"];
    $torre_caja_precio = $_POST["torre_caja_precio"];

    $refrigeracion = $_POST["refrigeracion"];
    $refrigeracion_precio = $_POST["refrigeracion_precio"];

    $tarjeta_grafica = $_POST["tarjeta_grafica"];
    $tarjeta_grafica_precio = $_POST["tarjeta_grafica_precio"];

    $tarjeta_red = $_POST["tarjeta_red"];
    $tarjeta_red_precio = $_POST["tarjeta_red_precio"];

    $monitor = $_POST["monitor"];
    $monitor_precio = $_POST["monitor_precio"];

    $teclado = $_POST["teclado"];
    $teclado_precio = $_POST["teclado_precio"];

    $raton = $_POST["raton"];
    $raton_precio = $_POST["raton_precio"];

    $cascos = $_POST["cascos"];
    $cascos_precio = $_POST["cascos_precio"];

    $otros = $_POST["otros"];
    $otros_precio = $_POST["otros_precio"];

    $precio_total = $_POST["precio_total"];

	$sql = "INSERT INTO piezas_pc(
                        usuario,
                        descripcion_pc,
                        procesador,
                        procesador_precio,
                        placa_base,
                        placa_base_precio,
                        memoria_ram,
                        memoria_ram_precio,
                        kit_placa_procesador_ram,
                        kit_precio,
                        disco_duro_ssd,
                        dd_ssd_precio,
                        disco_duro_ssd_2,
                        dd_ssd2_precio,
                        disco_duro_hdd,
                        dd_hdd_precio,
                        disco_duro_hdd_2,
                        dd_hdd2_precio,
                        fuente_alimentacion,
                        fuente_alim_precio,
                        torre_caja,
                        torre_caja_precio,
                        refrigeracion,
                        refrigeracion_precio,
                        tarjeta_grafica,
                        tarjeta_grafica_precio,
                        tarjeta_red,
                        tarjeta_red_precio,
                        monitor,
                        monitor_precio,
                        teclado,
                        teclado_precio,
                        raton,
                        raton_precio,
                        cascos,
                        cascos_precio,
                        otros,
                        otros_precio,
                        precio_total)
                        VALUES
                        (
                        '$usuario',
                        '$descripcion_pc',
                        '$procesador',
                        '$procesador_precio',
                        '$placa_base',
                        '$placa_base_precio',
                        '$memoria_ram',
                        '$memoria_ram_precio',
                        '$kit_placa_procesador_ram',
                        '$kit_precio',
                        '$disco_duro_ssd',
                        '$dd_ssd_precio',
                        '$disco_duro_ssd_2',
                        '$dd_ssd2_precio',
                        '$disco_duro_hdd',
                        '$dd_hdd_precio',
                        '$disco_duro_hdd_2',
                        '$dd_hdd2_precio',
                        '$fuente_alimentacion',
                        '$fuente_alim_precio',
                        '$torre_caja',
                        '$torre_caja_precio',
                        '$refrigeracion',
                        '$refrigeracion_precio',
                        '$tarjeta_grafica',
                        '$tarjeta_grafica_precio',
                        '$tarjeta_red',
                        '$tarjeta_red_precio',
                        '$monitor',
                        '$monitor_precio',
                        '$teclado',
                        '$teclado_precio',
                        '$raton',
                        '$raton_precio',
                        '$cascos',
                        '$cascos_precio',
                        '$otros',
                        '$otros_precio',
                        '$precio_total')";

	$result = mysqli_query( $con,$sql );
	
	if($result) {
		echo "Presupuesto creado";
	}
	else {
		echo "Ha ocurrido un error";
	}
?>