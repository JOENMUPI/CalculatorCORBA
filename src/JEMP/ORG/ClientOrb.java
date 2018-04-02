package JEMP.ORG;

import java.util.Scanner;
import MatApp.*; //importar la interfaz idl
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class ClientOrb {
	static Mat matImpl;
	public static void main(String args[]) {
		Scanner sc = new Scanner (System.in);
		try {
			ORB orb = ORB.init(args, null);//inicializar orb para enviar peticion
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			matImpl = MatHelper.narrow(ncRef.resolve_str("mat"));
			boolean x;
			do{
				x = true;
				float a,b;
				System.out.println("\n\nCalculadora de 2 variables by mundo\n\n"
						+ "1.Suma.\n2.Resta.\n3.Multiplicacion.\n4.Divicion.\n"
						+ "5.Potencia.\n6.Raiz.\n0.Salir.\nEleccion: ");
				a = sc.nextInt();
				switch((int)a) {
					case 0 : x = false; break;
					case 1 :
						System.out.println("\nSUMA.\nIngrese primer valor: ");
						a = sc.nextFloat();
						System.out.println("\nIngrese segundo valor: ");
						b = sc.nextFloat();
						System.out.println("\nResultado: "
								+Float.toString(matImpl.suma(a, b)));
						break;
					case 2 :
						System.out.println("\nRESTA.\nIngrese primer valor: ");
						a = sc.nextFloat();
						System.out.println("\nIngrese segundo valor: ");
						b = sc.nextFloat();
						System.out.println("\nResultado: "
								+Float.toString(matImpl.resta(a, b)));
						break;
					case 3 :
						System.out.println("\nMULTIPLICACION.\n"
								+ "Ingrese primer valor: ");
						a = sc.nextFloat();
						System.out.println("\nIngrese segundo valor: ");
						b = sc.nextFloat();
						System.out.println("\nResultado: "
								+Float.toString(matImpl.multi(a, b)));
						break;
					case 4 :
						System.out.println("\nDIVICION.\n"
								+ "Ingrese primer valor: ");
						a = sc.nextFloat();
						System.out.println("\nIngrese segundo valor: ");
						b = sc.nextFloat();
						System.out.println("\nResultado: "
								+Float.toString(matImpl.divi(a, b)));
						break;
					case 5 :
						System.out.println("\nPOTENCIACION.\n"
								+ "Ingrese el numero base: ");
						a = sc.nextFloat();
						System.out.println("\nIngrese la potencia: ");
						b = sc.nextFloat();
						System.out.println("\nResultado: "
								+Float.toString(matImpl.potencia(a, b)));
						break;
					case 6 :
						System.out.println("\nRAIZ.\n"
								+ "Ingrese numero: ");
						a = sc.nextFloat();
						System.out.println("\nIngrese la base de la raiz: ");
						b = sc.nextFloat();
						System.out.println("\nResultado: "
								+Float.toString(matImpl.potencia(a, b)));
						break;
				}	
			}
			
			while(x);
			matImpl.shutdown();
		} 
		
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace(System.out);
		}
	}
}