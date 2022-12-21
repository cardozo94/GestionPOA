package co.camcar.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.camcar.aop.dao.ClienteDao;
import co.camcar.aop.dao.ClienteVipDao;

public class ClasePrincipal {

	public static void main(String[] args) {
		// Leer configuración de Spring
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);
		
		//obtener el bean del contenedor de Spring
		
		ClienteDao cliente = context.getBean("clienteDao", ClienteDao.class);
		ClienteVipDao clienteVip = context.getBean("clienteVipDao", ClienteVipDao.class);
				
		//llamar al método
		
		cliente.insertaCliente(new Cliente("Camilo", "NO-VIP"), "Normal");//nombre de metodo que debe coincidir con la anotación @Before
		clienteVip.insertaClienteVIP();
		
		cliente.setCodigoClienteNormal("123456789");
		cliente.setValoracionClienteNormal("Positiva");
		
		String codigoCl = cliente.getCodigoClienteNormal();
		String valoracionCl = cliente.getValoracionClienteNormal();
		
		//Cerrar el contexto
		context.close();

	}

}
