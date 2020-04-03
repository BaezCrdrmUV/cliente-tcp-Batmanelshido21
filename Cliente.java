import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);
		final String host = "172.17.0.1";
		final int puerto = 5000;
		DataInputStream in;
		DataOutputStream out;
		boolean opcion = true;

		while (opcion = true) {
			try {
				Socket sc = new Socket(host, puerto);
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				System.out.println("Escribe el mensaje que deseas enviar al servidor");
				String texto = lector.nextLine();
				out.writeUTF(texto);
				String mensaje = in.readUTF();
				System.out.println(mensaje);
				if (texto.equalsIgnoreCase("bye")) {
					sc.close();
					opcion=false;
				}

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
