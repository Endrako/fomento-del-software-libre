package pos.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncionesImpl {

	public static String formateoFecha(Date fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd.MM.yy");
		String cadenaFecha = formato.format(fecha);
		return cadenaFecha;
       
    }
}
