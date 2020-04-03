import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket servidor = null;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;
		final int PUERTO = 5000;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");

			while (true) {
				sc = servidor.accept();
				System.out.println("El cliente está conectado");

				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				String mensaje = in.readUTF();
				System.out.println(mensaje);
				out.writeUTF(mensaje);
				if(mensaje.equalsIgnoreCase("bye")) {
					sc.close();
					System.out.println("Cliente desconectado");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
