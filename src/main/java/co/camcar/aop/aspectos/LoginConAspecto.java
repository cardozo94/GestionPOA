package co.camcar.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginConAspecto {
	
	//@Pointcut("execution(public * insertaCliente(..))") //actua sobre metodo especifico
	@Pointcut("execution(* co.camcar.aop.dao.*.*(..))")// actua sobre todos los metodos en el paquete dado
	private void paraClientes() {}
	
	@Pointcut("execution(* co.camcar.aop.dao.*.get*(..))")// actua sobre todos los metodos getter en el paquete dado
	private void paraGetters() {}
	
	@Pointcut("execution(* co.camcar.aop.dao.*.set*(..))")// actua sobre todos los metodos setter en el paquete dado
	private void paraSetters() {}
	
	//combinacion de pointcutts
	@Pointcut("paraClientes() && !(paraGetters() || paraSetters())")
	private void paqueteExceptoGetterYSetter() {}
	
	//@Before("paraClientes()")
	@Before("paqueteExceptoGetterYSetter()")
	public void antesInsertarCliente() {
		System.out.println("El usuario se ha logeado");
		System.out.println("El perfil es valido");
	}
	
	//@Before("paraClientes()")	
	public void requisitosCliente() {
		System.out.println("Cliente cumple con los requisitos para ser insertado en la BBDD.");
	}
	
	//@Before("paraClientes()")
	public void requisitosTabla() {
		System.out.println("La tabla cumple con los requisitos. Menos de 3000 registros");
	}
}
