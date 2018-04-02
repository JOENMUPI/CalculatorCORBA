package JEMP.ORG;
import MatApp.*; //importar la interfaz idl
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class MatImpl extends MatPOA {
	private ORB orb; //crear una instancia de orb
	public void setORB(ORB orb_val) { orb = orb_val; }//setear el orb para generar las conecciones
	public float suma(float x, float y) { return x + y; }
	
	public float resta(float x, float y) { return x - y; }

	public float multi(float x, float y) { return x * y; }
	
	public float divi(float x, float y) { return x / y; }
	
	public float potencia(float x, float y) { return (float) Math.pow(x, y); }
	
	public float raiz(float x, float y) { return (float) Math.pow(x, 1/y); }//metodo q va a enviar

	public void shutdown() { orb.shutdown(false); }//cerrar orb por parte del  servidor
}

public class ServerOrb {
	public static void main(String args[]) {
		try {
			ORB orb = ORB.init(args, null); //inicializacion de conexion
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));//abrimos el root del POA
			rootpoa.the_POAManager().activate();
			MatImpl matImpl = new MatImpl(); //implementamos referencia
			matImpl.setORB(orb); //seteamos ORB
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(matImpl);
			Mat href = MatHelper.narrow(ref);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");//le damos nombre al servicio
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			NameComponent path[] = ncRef.to_name("mat");//se envia el nombre para que resiba la interface
			ncRef.rebind(path, href);
			System.out.println("ServidorOrb listo y en espera");//confirmacion de servidor conectado
			orb.run();
		}
		
		catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace(System.out);
		}
		
		System.out.println("Adios cerrando servidor");
	}
}