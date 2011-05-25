package pos.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FuncionesImpl {

	public static String formateoFecha(Date fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd.MM.yy");
		String cadenaFecha = formato.format(fecha);
		return cadenaFecha;
       
    }
	
	public static java.sql.Date fechaMas(java.sql.Date fch, int dias){ 
	     Calendar cal = new GregorianCalendar(); 
	     cal.setTimeInMillis(fch. getTime()); 
	     cal.add(Calendar. DATE, dias); 
	     return new java.sql.Date(cal. getTimeInMillis()); 
	} 
}
